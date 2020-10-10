package com.hsbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	

	PreparedStatement pst=null;
	ResultSet rs=null;
	
	DBConnection con=new DBConnection();
	

	
	public boolean check(String customer_username,String customer_password)
	{
		
		
		try{

			PreparedStatement pst=con.getPreparedStatement("select * from CustomerLogin where customer_username=? and customer_password=?");
			
			pst.setString(1, customer_username);
			pst.setString(2, customer_password);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
			
			
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
		
	}

}

