package com.hsbc.servlet;




import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.dao.Category;
import com.hsbc.dao.CategoryDAO;
 
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listCategory(request, response);
    }
 
    private void listCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO dao = new CategoryDAO();
 
        try {
 
            List<Category> listCatagory = dao.list();
            request.setAttribute("listCategory", listCatagory);
 
            RequestDispatcher dispatcher = request.getRequestDispatcher("index1.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryId =(request.getParameter("category"));
 
        request.setAttribute("selectedCatId", categoryId);
 
        listCategory(request, response);
    }
}
