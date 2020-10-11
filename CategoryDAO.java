package com.hsbc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.connection.DBConnection;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class CategoryDAO {
    DBConnection db=new DBConnection();
    
    public List<Category> list() throws SQLException {
        List<Category> listCategory = new ArrayList<>();
         
        try  {
            String sql = "SELECT product_id,product_name FROM Product ";
            Statement statement = db.getStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                int id = result.getInt("product_id");
                String name = result.getString("product_name");
                Category category = new Category(id, name);
                     
                listCategory.add(category);
            }          
             System.out.println(listCategory);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listCategory;
    }
}