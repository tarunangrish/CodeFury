package com.hsbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	String sql="select * from CustomerLogin where customer_username=? and customer_password=?";
	
	String url="jdbc:mysql://localhost:3306/CustomerLogin";
	
	public boolean check(String customer_username,String customer_password)
	{
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, customer_username);
			st.setString(2, customer_password);
			
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}

