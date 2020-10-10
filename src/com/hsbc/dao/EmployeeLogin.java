package com.hsbc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;



public class EmployeeLogin {

	DBConnection db=new DBConnection();
	public  String employee_login_check(String username,String password) throws SQLException {
		
		PreparedStatement pst = db.getPreparedStatement("select * from Employee where employee_username=? and employee_password=?" );
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();  
		
		
		if (rs.next()) {
			
			//return "verified";
			
			PreparedStatement pst1 = db.getPreparedStatement("select employee_date,employee_time from Employee where employee_username=? " );   
			pst1.setString(1, username);
			ResultSet rs1=pst.executeQuery();  
			
				String s="";
				while(rs1.next()) {
				Date date=rs1.getDate("employee_date");
				Time time=rs1.getTime("employee_time");
				String user=rs1.getString("employee_username");
				
				s="Last logged in on Date: "+ date + " Time :"+time;
				
				 }
				
				
			PreparedStatement pst2 = db.getPreparedStatement("update Employee set employee_date=?,employee_time=? where employee_username=? " );   
				
				LocalDateTime localDateTime = LocalDateTime.now();
			    LocalDate localDate = localDateTime.toLocalDate();
			    LocalTime localTime = localDateTime.toLocalTime();
			    java.sql.Date date = java.sql.Date.valueOf(localDate);
			    java.sql.Time time = java.sql.Time.valueOf(localTime);
				pst2.setObject(1, date);
				pst2.setObject(2, time);
				pst2.setString(3, username);
				pst2.executeUpdate();
				
				
				
				return s;
		
		
} 

		else {
            String a="User does not exist. Please check your credentials";
            return a;
            
		
	}
	
}
}