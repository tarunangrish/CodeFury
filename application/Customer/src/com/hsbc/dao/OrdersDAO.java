package com.hsbc.dao;



import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.connection.DBConnection;
import com.hsbc.data.Customer;
import com.hsbc.data.Invoice;
import com.hsbc.data.Order;






public class OrdersDAO {

	DBConnection db=new DBConnection();
	
	
	public int get_customeid(String username) throws SQLException {
		int id=0;
		PreparedStatement pst = db.getPreparedStatement("select customer_id from customer_login where customer_username=?" );
		pst.setString(1, username);
		
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()) {
			id=rs.getInt("customer_id");
			}
		
		return id;
	
	}
	
	public void update_status(int id) throws SQLException {
		PreparedStatement pst2 = db.getPreparedStatement("update orders set status=? where order_id=? " );   
		
		
		pst2.setString(1, "approved");
		pst2.setInt(2, id);
		
		pst2.executeUpdate();
		
	
	}
	
	public List<Invoice> showInvoice(int id) throws SQLException {
		 List < Invoice > inv1 = new ArrayList < > ();
		PreparedStatement pst3 = db.getPreparedStatement("select * from invoice where order_id =?" );   
		pst3.setInt(1, id);
		
		ResultSet rs1=pst3.executeQuery();
		while(rs1.next()) {
			 int invoice_id =rs1.getInt("invoice_id");
			 Date invoice_date=rs1.getDate("invoice_date");
			 int order_id=rs1.getInt("order_id");
			 String status =rs1.getString("payment_status");
			 String gst_type=rs1.getString("gst_type");
			 double total_gst_amount = rs1.getDouble("total_gst_amount");
			 double total_invoice_value = rs1.getDouble("total_invoice_value");

			inv1.add(new Invoice( invoice_id,  invoice_date,order_id,  status,  gst_type,  total_gst_amount,
			 total_invoice_value)) ;
		}
		return inv1;
		
	}
	
	public List<Customer> showCustomer(int id) throws SQLException {
		 List < Customer > cust = new ArrayList < > ();
		PreparedStatement pst4 = db.getPreparedStatement("select * from customer where customer_id =?" );   
		pst4.setInt(1, id);
		
		ResultSet rs1=pst4.executeQuery();
		while(rs1.next()) {
			
			 String customer_first_name=rs1.getString("customer_first_name");
			 String customer_middle_name=rs1.getString("customer_middle_name");
			 String customer_last_name=rs1.getString("customer_last_name");
			 int customer_street_number=rs1.getInt("customer_street_number");
			 String customer_street_name=rs1.getString("customer_street_name");
			 String customer_city=rs1.getString("customer_city");
			 String customer_state=rs1.getString("customer_state");
		     String customer_pincode=rs1.getString("customer_pincode");;
			 String customer_email_id=rs1.getString("customer_email_id");;

			cust.add(new Customer( id,  customer_first_name,  customer_middle_name, customer_last_name,
					 customer_street_number,  customer_street_name,  customer_city,  customer_state,
					 customer_pincode,  customer_email_id)) ;
		}
		return cust;
		
	}
	
	

	
	

	public List < Order > selectAll(int user_id) {

        
        List < Order > ord1 = new ArrayList < > ();

        
        try (

             
            PreparedStatement preparedStatement = db.getPreparedStatement("select * from orders where customer_id = ?");) {
        	preparedStatement.setInt(1, user_id );
            System.out.println(preparedStatement);
            
            ResultSet rs = preparedStatement.executeQuery();

          
            while (rs.next()) {
                
                
                
                 int order_id =rs.getInt("order_id");
            	 Date order_date=rs.getDate("order_date");
            	 String shipping_agency=rs.getString("shipping_agency");
            	 String status= rs.getString("status");
            	 int customer_id =rs.getInt("customer_id");
            	 int company_id=rs.getInt("company_id");
            	 double shipping_cost=rs.getDouble("shipping_cost");
            	 double total_order_value=rs.getDouble("total_order_value");
                
            	
                ord1.add(new Order( order_id,  order_date,  shipping_agency,  status,  customer_id,  company_id,
            			 shipping_cost,  total_order_value ));
                System.out.println(ord1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ord1;
    }

}
