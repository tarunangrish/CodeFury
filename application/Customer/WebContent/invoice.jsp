<%@page import="com.hsbc.data.Invoice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Customer Order Management Page</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<link href="./css/order-manangement-customer.css" rel="stylesheet">
</head>


<body>


    <div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body p-0">
                    <div class="row p-5">
                        <div class="col-md-6">
                            <img src="./css/logo.svg" height=60 width=120>
                        </div>

                        <div class="col-md-6 text-right">
                        
                        <c:forEach items="${invoiceList}" var="dataItem">
                            <p class="font-weight-bold mb-1">Invoice #${dataItem.invoice_id}</p>
                            <p class="text-muted">Date : ${dataItem.invoice_date} </p>
                            </c:forEach>
                        </div>
                    </div>

                    <hr class="my-5">

                    <div class="row pb-5 p-5">
                        <div class="col-md-6">
                        
                            <p class="font-weight-bold mb-4">Customer Information</p>
                             <c:forEach items="${customerList}" var="dataItem">
                            <p class="mb-1"><b>Name</b> : ${dataItem.customer_first_name}  ${dataItem.customer_last_name} </p>
                            <p><b>Address</b> : ${dataItem.customer_street_number}, ${dataItem.customer_street_name},
                            ${dataItem.customer_city}, ${dataItem.customer_state}.</p>
                            <p class="mb-1"><b>Pincode</b> : ${dataItem.customer_pincode}</p>
                            <p class="mb-1"><b>Email</b> : ${dataItem.customer_email_id}</p>
                            </c:forEach>
                        </div>

                       
                    </div>

                    <div class="row p-5">
                        <div class="col-md-12">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th class="border-0 text-uppercase small font-weight-bold">ID</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Date</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Order ID</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">GST Type</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">GST Amount</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Invoice Amount</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
   
   									
   									 <c:forEach items="${invoiceList}" var="dataItem">
								        <tr>
								            <td>${dataItem.invoice_id}</td>
					                        <td>${dataItem.invoice_date}</td>                        
					                        <td>${dataItem.order_id}</td>
					                        <td>${dataItem.gst_type}</td>
					                       <td> ${dataItem.total_gst_amount}</td>
					                       <td> ${dataItem.total_invoice_value}</td>
					                       <td> ${dataItem.status}</td>
					                   
					                      
								            
								    	</tr>
								    </c:forEach>
                                   
                                   
   
   									
      										
                                            
                 
      
      									
   									
  								
                      
                                </tbody>
                            </table>
                        </div>
                    </div>
					<c:forEach items="${invoiceList}" var="dataItem">
                    <div class="d-flex flex-row-reverse bg-dark text-white p-4">
                        <div class="py-3 px-5 text-right">
                            <div class="mb-2">Total_amount</div>
                            <div class="h2 font-weight-light">${dataItem.total_invoice_value}</div>
                        </div>

                        <div class="py-3 px-5 text-right">
                            <div class="mb-2">Total GST</div>
                            <div class="h2 font-weight-light">${dataItem.total_gst_amount}</div>
                        </div>

                        <div class="py-3 px-5 text-right">
                            <div class="mb-2">Payment Status</div>
                            <div class="h2 font-weight-light">${dataItem.status}</div>
                        </div>
                    </div>
                    </c:forEach>
                    
                </div>
            </div>
        </div>
    </div>
      

    

</div>



</body>
</html>