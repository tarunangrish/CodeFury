package com.hsbc.Servlet;

/*import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.*;

@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerLoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String customer_username = request.getParameter("inputEmail");
		String customer_password = request.getParameter("inputPassword");

		CustomerLogin dao = new CustomerLogin();

		try {
			if (dao.check(customer_username, customer_password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", customer_username);
				response.sendRedirect("ordermanagementcustomer.jsp");

			} else {
				request.setAttribute("message", "Invalid");
				response.sendRedirect("CustomerLogin.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}*/
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.*;
import com.hsbc.data.Order;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("signin.jsp");
		//this.doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String customer_username = request.getParameter("inputUsername");
		String customer_password = request.getParameter("inputPassword");
		System.out.println(customer_username);
		System.out.println(customer_password);

		LoginDao dao = new LoginDao();
		Boolean k=dao.check(customer_username, customer_password);
		System.out.println(k);
		if (k) {
			HttpSession session = request.getSession();
			
			session.setAttribute("username", customer_username);
			
			//String customer_username = (String)session.getAttribute("user");
	    	
	    	// find out customer id
	    	OrdersDAO ord1 = new OrdersDAO();
	    	int customer_id=0;
	    	try {
				 customer_id = ord1.get_customeid((String)session.getAttribute("username"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	
	    	
	        List <Order> order_list = ord1.selectAll(customer_id);
	        System.out.println(order_list);
	        
	        //System.out.println(listTodo1);
	        session.setAttribute("orderlist", order_list);
	        //RequestDispatcher dispatcher = request.getRequestDispatcher("list_of_orders.jsp");
	       // dispatcher.forward(request, response);
			response.sendRedirect("list_of_orders.jsp");

		} else {
			
			RequestDispatcher d=request.getRequestDispatcher("signin.jsp");
			request.setAttribute("message", "Invalid credentials");
			d.forward(request, response);
		}

	}

}