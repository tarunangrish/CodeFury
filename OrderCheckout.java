package com.hsbc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.hsbc.connection.DBConnection;

public class OrderCheckout {
	DBConnection db=new DBConnection();
	public Boolean checkout(String orderid,String orderdate, String custid,String status) throws ParseException, SQLException {
		
		String sql="Insert into Order1(order_id,order_date,customer_id,status )"+"values(?,?,?,?)";
		PreparedStatement st=db.getPreparedStatement(sql);
		int p1=Integer.parseInt(orderid);
		//String date1=(Date) new SimpleDateFormat("yyyy-mm-dd").parse(orderdate);	
		int p2=Integer.parseInt(custid);
		st.setInt(1, p1);
		
		st.setDate(2, java.sql.Date.valueOf(orderdate));
		st.setInt(3, p2);
		st.setString(4,	 status);
		int rowAffected = st.executeUpdate();
		if(rowAffected == 1)
		{
		 return true;
		}
		else {
			return false;
			
		}
			
		
		
	}
	
	

}
