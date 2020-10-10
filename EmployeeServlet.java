package com.hsbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.dao.EmployeeLogin;



/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("employeelogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String username=request.getParameter("empusername");
		String password=request.getParameter("emppassword");
		EmployeeLogin e=new EmployeeLogin();
		try {
			String a=e.employee_login_check(username, password);
			System.out.println(a);
			
			
			String b=a.substring(0, 4);
			if(b.equals("Last")) {// means it has validated correctly
				//out.println(a);
				//response.sendRedirect("welcome.html");
				request.setAttribute("myname",a);
				request.getRequestDispatcher("order_management_employee.jsp").forward(request, response);
				}
			else {
				RequestDispatcher d=request.getRequestDispatcher("employeelogin.jsp");
				request.setAttribute("answer", a);
				d.forward(request, response);
				out.println(a);

			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
