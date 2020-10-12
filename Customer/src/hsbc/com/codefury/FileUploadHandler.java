package hsbc.com.codefury;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.hsbc.connection.DBConnection;

//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//import com.derby.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Servlet implementation class FileUploadHandler
 */
@WebServlet("/FileUploadHandler")
public class FileUploadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		 /**
         * Getting the File Uploaded
         */
		String file_name = null;
		String theFile = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent) {
            return;
        }
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List < FileItem > fields = upload.parseRequest(request);
            Iterator < FileItem > it = fields.iterator();
            if (!it.hasNext()) {
                return;
            }
            while (it.hasNext()) {
                FileItem fileItem = it.next();
                boolean isFormField = fileItem.isFormField();
                if (isFormField) {
                    if (file_name == null) {
                        if (fileItem.getFieldName().equals("file_name")) {
                        	file_name = fileItem.getString();
                        }
                    }
                } else {
                    if (fileItem.getSize() > 0) {
                    	 theFile = fileItem.getName();
                         fileItem.write(new File("C:\\Users\\HP\\Desktop\\uploaded_files\\" + fileItem.getName()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.println("<script type='text/javascript'>");
            out.println("window.location.href='index.jsp?filename="+file_name+"'");
            out.println("</script>");
            out.close();
        }
        
        
        /**
         * XML Parsing of the Uploaded File
         */
        ArrayList<ArrayList<String>> detail1s = new ArrayList<ArrayList<String>>();
		try {
	         File inputFile = new File("C:\\Users\\HP\\Desktop\\uploaded_files\\" + theFile);
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         NodeList nList = doc.getElementsByTagName("product");
	         
	         
	         
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            ArrayList<String> mm = new ArrayList<String>();
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               String id = (String)eElement.getElementsByTagName("id").item(0).getTextContent();
	               String n = (String)eElement.getElementsByTagName("name").item(0).getTextContent();
	               String p = (String)eElement.getElementsByTagName("price").item(0).getTextContent();
	               String pc = (String)eElement.getElementsByTagName("product_categories").item(0).getTextContent();
	               String cid = (String)eElement.getElementsByTagName("company_id").item(0).getTextContent();
	               
	               mm.add(id);
	               mm.add(n);
	               mm.add(p);
	               mm.add(pc);
	               mm.add(cid);
	               detail1s.add(mm);
	            }
	         }
	         System.out.println(detail1s);
	      } catch (Exception e) { 
	         e.printStackTrace();
	      }
		
		/**
		 * Putting into the Product Table!
		 */
		try
		{
			ArrayList<ArrayList<String>> partial1s = new ArrayList<ArrayList<String>>();
			HashSet<String> checkId = new HashSet<String>(); 
			try{
				int dSize = detail1s.size();
				for(int i = 0;i<dSize;i++)
				{
					checkId.add(detail1s.get(i).get(0));
				}
				int setSize = checkId.size();
				if(dSize == setSize)
				{
					System.out.println("Its going to be a Complete Filling!");
					partial1s = detail1s;
				}
				else if(dSize != setSize && dSize != 1 && setSize != 1)
				{
					System.out.println("Its going to be a Partial Filling!");
					HashMap<String,Integer> CheckingCommonId = new HashMap<String,Integer>();
					for(int i = 0;i<dSize;i++)
					{
						if(CheckingCommonId.containsKey(detail1s.get(i).get(0)))
						{
							CheckingCommonId.put(detail1s.get(i).get(0),CheckingCommonId.get(detail1s.get(i).get(0))+1);
						}
						else
						{
							CheckingCommonId.put(detail1s.get(i).get(0),1);
						}
					}
					for(int i = 0;i<dSize;i++)
					{
						if(CheckingCommonId.get(detail1s.get(i).get(0))>1)
						{
							continue;
						}
						else
						{
							partial1s.add(detail1s.get(i));
						}
					}
					System.out.println(CheckingCommonId);
					System.out.println(partial1s);
				}
				else if(dSize != 1 && setSize == 1)
				{ 
					System.out.println("Failed to fill the table!");
					partial1s = null;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			
			//Class.forName("org.apache.derby.jdbc.ClientDriver");
			
			//Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/codefurydb");
			DBConnection db=new DBConnection();
			
			PreparedStatement st = db.getPreparedStatement("insert into Product values(?,?,?,?,?)");
			
			Statement stmt = db.getStatement();
			
			
			
			
			
			for(int i = 0;i<partial1s.size();i++)
			{
				String SQL = "SELECT * FROM Product WHERE product_id = " + Integer.parseInt(partial1s.get(i).get(0));
				ResultSet rs1 = stmt.executeQuery(SQL);
				if(rs1.next())
				{
				    System.out.println("New Update! for "+ partial1s.get(i).get(0));  
//				    String SQL_Statement = "UPDATE PRODUCT SET Product_name = ?, Product_price = ?, product_category = ?, company_id = ? WHERE Product_ID = "+Integer.parseInt(partial1s.get(i).get(0));
				    String SQL_Statement = "UPDATE Product SET company_id = ?, product_name = ?, product_price = ?, product_category_level = ? WHERE product_id = "+Integer.parseInt(partial1s.get(i).get(0));
				    PreparedStatement updateQuery = db.getPreparedStatement(SQL_Statement);
//				    updateQuery.setString(1, partial1s.get(i).get(1));
//				    updateQuery.setDouble(2, Double.parseDouble(partial1s.get(i).get(2)));
//				    updateQuery.setInt(3, Integer.parseInt(partial1s.get(i).get(3)));
//				    updateQuery.setInt(4, Integer.parseInt(partial1s.get(i).get(4)));
				    updateQuery.setInt(1, Integer.parseInt(partial1s.get(i).get(4)));
				    updateQuery.setString(2, partial1s.get(i).get(1));
				    updateQuery.setDouble(3, Double.parseDouble(partial1s.get(i).get(2)));
				    updateQuery.setInt(4, Integer.parseInt(partial1s.get(i).get(3)));
                    updateQuery.executeUpdate();
//                    con.commit();
				}
				else
				{
					st.setInt(1, Integer.parseInt(partial1s.get(i).get(0)));
//					st.setString(2, partial1s.get(i).get(1));
//				    st.setDouble(3, Double.parseDouble(partial1s.get(i).get(2)));
//				    st.setInt(4, Integer.parseInt(partial1s.get(i).get(3)));
//				    st.setInt(5, Integer.parseInt(partial1s.get(i).get(4)));
				    st.setInt(2, Integer.parseInt(partial1s.get(i).get(4)));
				    st.setString(3, partial1s.get(i).get(1));
				    st.setDouble(4, Double.parseDouble(partial1s.get(i).get(2)));
				    st.setInt(5, Integer.parseInt(partial1s.get(i).get(3)));
					st.executeUpdate();
				}
			}

			st = db.getPreparedStatement("select * from Product");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getInt(5));
			}
			
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
        
	}

}
