<%@page import="com.hsbc.data.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.hsbc.dao.OrdersDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<head>


<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Customer Order Management Page</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="./css/order-manangement-customer.css" rel="stylesheet">
</head>

<body>
    <nav class="navbar navbar-expand fixed-top navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Team Radiant</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
        </button>
      
        <div class="collapse navbar-collapse" id="navbarsExample02">
          <ul class="navbar-nav mr-auto">
          </ul>
          <form class="form-inline my-2 my-md-0" action="Logout" method="post">
            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Logout</button>
          </form>
        </div>
      </nav>
      <br><br><br><br>
      
<form method="post" action="OrderServlet">
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-4">
                        <h2>Customer Order <b>Management Dashboard</b></h2>
                    </div>
                   
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Date</th>
                        <th>Shipping Cost</th>
                        <th>Order Value</th>						
                        <th>Status</th>						
                        <th>Show Invoice</th>
                        <th>Order Details</th>
                    </tr>
                </thead>
                <tbody>
                
                    
                    <c:forEach items="${orderlist}" var="dataItem">
			        <tr>
			            <td>${dataItem.order_id}</td>
                        <td>${dataItem.order_date}</td>                        
                        <td>${dataItem.shipping_cost}</td>
                        <td>${dataItem.total_order_value}</td>
                       <td><span class="status text-success">&bull;</span> ${dataItem.status}</td>
                       
                        <td><button type="submit" name="btn" value="${dataItem.order_id }@show" class="btn btn-default btn-primary btn-block" aria-label="Left Align">Show Invoice
                            </button></td>
                        <td><button type="submit"name="btn" value="${dataItem.order_id }@approve" class="btn btn-success btn-block" aria-label="Left Align">Approve
                            </button></td>
			            
			    	</tr>
			    </c:forEach>
                   
                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Showing <b>Dynamic</b> out of <b>Dynamic</b> entries</div>
            </div>
            
        </div>
    </div>        
</div>     
</form>
</body>
</html>
