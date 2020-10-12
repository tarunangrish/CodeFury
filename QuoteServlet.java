package com.hsbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.connection.DBConnection;
import com.hsbc.dao.AddProd;
import com.hsbc.dao.OrderCheckout;

/**
 * Servlet implementation class QuoteServlet
 */
@WebServlet( "/QuoteServlet")
public class QuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		  PrintWriter out=response.getWriter();
		  
		   String p=request.getParameter("category");
		   String ptype=request.getParameter("prodtype");
		   String q=request.getParameter("quantity");
		   String o=request.getParameter("order");
		   
		   
		   AddProd a=new AddProd();
		  try {
			String result= a.add(o,p, ptype, q);
			RequestDispatcher d=request.getRequestDispatcher("list");
			request.setAttribute("message", result);
			d.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		} 
	}


