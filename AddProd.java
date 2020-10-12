package com.hsbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hsbc.connection.DBConnection;

public class AddProd {
DBConnection db=new DBConnection();
public String add(String o,String p,String ptype,String q) throws SQLException {
	String sql="Insert into Order_Product(order_id,product_id,quantity )"+"values(?,?,?)";
	PreparedStatement st=db.getPreparedStatement(sql);
	int p1=Integer.parseInt(p);
	int p2=Integer.parseInt(q);
	int p3=Integer.parseInt(o);
	st.setInt(1, p3);
st.setInt(2, p1);
st.setInt(3, p2);
int rowAffected = st.executeUpdate();
if(rowAffected == 1)
{
 return "Inserted";
}
else {
	return "Not inserrted";
	
}
	
}
}
