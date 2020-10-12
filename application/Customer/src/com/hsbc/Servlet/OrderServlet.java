package com.hsbc.Servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.OrdersDAO;
import com.hsbc.data.Customer;
import com.hsbc.data.Invoice;
import com.hsbc.data.Order;

import java.util.*;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String action="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 this.doPost(request,response);
		
	}
	
	private void Approve_order(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		HttpSession session= request.getSession(false);
		    String arr[]=action.split("@");
	        System.out.println(arr[0]);
	        int a=Integer.parseInt(arr[0]);
	        OrdersDAO ord4=new OrdersDAO();
	        ord4.update_status(a);
	        
	        OrdersDAO ord1 = new OrdersDAO();
	    	int customer_id=0;
	    	try {
				 customer_id = ord1.get_customeid((String)session.getAttribute("username"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	
	    	
	        List <Order> order_list = ord1.selectAll(customer_id);
	        //System.out.println(order_list);
	        
	        
	        session.setAttribute("orderlist", order_list);
	        //RequestDispatcher dispatcher = request.getRequestDispatcher("list_of_orders.jsp");
	       // dispatcher.forward(request, response);
			response.sendRedirect("list_of_orders.jsp");
	}
		    
		    
	
	private void Show_invoice(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		PrintWriter  out= response.getWriter();
		HttpSession session= request.getSession(false);
		
		 String arr[]=action.split("@");
	        //System.out.println(arr[0]);
	        int a=Integer.parseInt(arr[0]);
	        OrdersDAO ord5=new OrdersDAO();
	        List<Invoice> l=ord5.showInvoice(a);
	        int customer_id=0;
	    	try {
				 customer_id = ord5.get_customeid((String)session.getAttribute("username"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        List<Customer>c=ord5.showCustomer(customer_id);
	        System.out.println(c);
	        //System.out.println(l);
	        if(l.size() == 0) {
	        	
	        	out.println("<html>"+"<h2>Invoice not generated, go back</h2>"+"</html>"+"<br>");
	        }
	        else {
	        	request.setAttribute("invoiceList", l);
	        	request.setAttribute("customerList", c);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("invoice.jsp");
		        dispatcher.forward(request, response);
	        }
	        
			
	        
		    
		    }




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 action = request.getParameter("btn");
		 //System.out.println(action);
        if(action.substring(action.length()-1).equals("e")) {
        	try {
				Approve_order(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        else if(action.substring(action.length()-1).equals("w")) {
        	try {
				Show_invoice(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
        }
        
       
        
	}

}
	}
