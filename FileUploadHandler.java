package hsbc.com.codefury;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import javax.sql.DataSource;

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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
                         fileItem.write(new File("D:\\uploaded_files\\" + fileItem.getName()));
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
	         File inputFile = new File("D:\\uploaded_files\\" + theFile);
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
			//Class.forName("org.apache.derby.jdbc.ClientDriver");
			
//			MysqlDataSource ds=new MysqlDataSource();   //IT GIVES CONNECTION POOL
			
			//Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/codefurry");
			
//			Connection con = DriverManager.getConnection("jdbc:derby:codefurry");
			DBConnection db=new DBConnection();
			
			
			PreparedStatement st = db.getPreparedStatement("insert into product values(?,?,?,?,?)");
			
			for(int i = 0;i<detail1s.size();i++)
			{
				st.setInt(1, Integer.parseInt(detail1s.get(i).get(0)));
				st.setString(2, detail1s.get(i).get(1));
				st.setInt(3, Integer.parseInt(detail1s.get(i).get(2)));
				st.setString(4, detail1s.get(i).get(3));
				st.setInt(5, Integer.parseInt(detail1s.get(i).get(4)));
				st.executeUpdate();
			}
//			PreparedStatement st = con.prepareStatement("insert into product values(?,?,?,?,?)");
//			st.setInt(1, (int)1);
//			st.setString(2, "abc");
//			st.setInt(3, (int)123);
//			st.setInt(4, (int)2);
//			st.setInt(5, (int)12);
			
//			st.executeUpdate();
			st = db.getPreparedStatement("select * from product");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getNString(2)+" "+rs.getInt(3)+rs.getNString(4)+rs.getInt(5));
			}
			
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
        
	}

}
