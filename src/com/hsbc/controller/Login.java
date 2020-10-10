package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
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
		System.out.println(customer_username);
		System.out.println(customer_password);

		LoginDao dao = new LoginDao();
		Boolean k=dao.check(customer_username, customer_password);
		System.out.println(k);
		if (k) {
			HttpSession session = request.getSession();
			session.setAttribute("username", customer_username);
			response.sendRedirect("welcome.jsp");

		} else {
			request.setAttribute("message", "Invalid");
			response.sendRedirect("signin.jsp");
		}

	}

}
