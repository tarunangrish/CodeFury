<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@page import="com.hsbc.servlet.ListServlet" %>
<%@page import="com.hsbc.servlet.QuoteServlet" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Create A New Quote</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="./css/create-a-new-quote.css" rel="stylesheet">
    <link href="./css/navbar-top-fixed.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-expand fixed-top navbar-dark bg-dark">
      <a class="navbar-brand" href="#">Team Radiant</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
      </button>
    
      <div class="collapse navbar-collapse" id="navbarsExample02">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-md-0">
          <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Logout</button>
        </form>
      </div>
    </nav>
    <div class="container">
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="./css/logo.svg" alt="" width="200" height="100">
    <h2>Create A New Quote</h2>
    <p class="lead">Enter Customer Details</p>
  </div>
  <form class="needs-validation" novalidate action="QuoteServlet" method="post">
    <div class="col-md-12 order-md-12">
      <h4 class="mb-3">Billing address</h4>
     
        <div class="mb-3">
          <label for="customerUsername">Customer ID</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">@</span>
            </div>
            <input type="text" onchange='saveValue(this);' class="form-control" id="username" name="cid" placeholder="Customer ID" required>
            <div class="invalid-feedback" style="width: 100%;">
              Customer ID is required.
            </div>
          </div>
        </div>
<div class="mb-3">
          <label for="orderid">Order ID</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">@</span>
            </div>
            <input type="text" class="form-control" id="orderid" name="order" placeholder="Order ID" required>
            <div class="invalid-feedback" style="width: 100%;">
            Order ID is required.
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">Order Date</label>
            <input type="date" class="form-control" id="orderDate"  name="odate" placeholder="" value="" required>
            <div class="invalid-feedback">
              Order Date is required.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">Customer GST Number</label>
            <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid GST Number is required.
            </div>
          </div>
        </div>

        <div class="mb-3">
          <label for="email">Customer Phone Number <span class="text-muted">(Optional)</span></label>
          <input type="email" class="form-control" id="mobileNumber" placeholder="Mobile Number">
          <div class="invalid-feedback">
            Please enter a valid number.
          </div>
        </div>

        <div class="mb-3">
          <label for="email">Customer Email ID <span class="text-muted">(Optional)</span></label>
          <input type="email" class="form-control" id="email" placeholder="Email ID">
          <div class="invalid-feedback">
            Please enter a valid email ID.
          </div>
        </div>

        <div class="mb-3">
          <label for="address">Shipping Address</label>
          <input type="text" class="form-control" id="address" placeholder="Address as on Aadhar Card" required>
          <div class="invalid-feedback">
            Please enter your shipping address.
          </div>
        </div>

        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">Customer City</label>
            <input type="text" class="form-control" id="orderDate" placeholder="" value="" required>
            <div class="invalid-feedback">
              City is required.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">Customer Pincode</label>
            <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Pincode is required.
            </div>
          </div>
        </div>

	
          
          <div class="row" id="productdetails">
          <div class="col-md-5 mb-3">
          <label for="products">Products</label>
             <select name="category"class="custom-select d-block w-100" id="p" required>
            <c:forEach items="${listCategory}" var="category">
                <option value="${category.id}"
                    <c:if test="${category.id eq selectedCatId}">selected="selected"</c:if>
                    >
                    ${category.name}
                </option>
            </c:forEach>
        </select>

            <div class="invalid-feedback">
              Please select a valid product.
            </div>
          </div>
         <%String val= request.getParameter("category");
         %>
        
            
          <div class="col-md-4 mb-3">
            <label for="ptype">Product Type</label>
            <select name="prodtype" class="custom-select d-block w-100" id="ptype" required>
              <option value="">Choose Product Type</option>
              <option>Type 1</option>
              <option>Type 2</option>
              <option>Type 3</option>
            </select>
            <div class="invalid-feedback">
              Please choose a product type.
            </div>
          </div>
          <%String val1= request.getParameter("prodtype");
         %>
          <div class="col-md-3 mb-3">
           <label for="q">Quantity</label>
            <select name="quantity" class="custom-select d-block w-100" id="q" required>
              <option value="">Choose Quantity</option>
              <option> 1</option>
              <option> 2</option>
              <option> 3</option>
              <option> 4</option>
              <option> 5</option>
              <option> 6</option>
              <option> 7</option>
              <option> 8</option>
              <option> 9</option>
              <option> 10</option>
            </select>
            
            <div class="invalid-feedback">
              No. of products required.
            </div>
          </div>
        </div>
<%String val2= request.getParameter("quantity");
         %>

  <br>
 

        <div class="row">

        
          <div class="col-md-6 mb-3"><input class="btn btn-outline-success btn-lg btn-block" id="addProduct" value="Add product" type="submit"></input>
            </div>
            <br>
            <br>
              <%if (val1!=null)
	  out.println("product Id is "+val);
        		   out.println("product Id is "+val1);
        		   out.println("product Id is "+val2);
	  %>
	  
   <br>

<%
  
   String s=(String)request.getAttribute("message");
		  
		  if(s!=null){
			  out.println(s);
		  }
  
  %>
            </div>
            
   </form>
            <form action="Checkout" method="post">
           <div class="mb-3">
          <label for="orderid">Order ID</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">@</span>
            </div>
            <input type="text" class="form-control" id="orderid" name="order" placeholder="Order ID" required>
            <div class="invalid-feedback" style="width: 100%;">
            Order ID is required.
            </div>
          </div>
        </div>
         <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">Order Date</label>
            <input type="date" class="form-control" id="orderDate"  name="odate" placeholder="" value="" required>
            <div class="invalid-feedback">
              Order Date is required.
            </div>
          </div>
        <div class="mb-3">
          <label for="customerUsername">Customer ID</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">@</span>
            </div>
            <input type="text" class="form-control" id="username" name="cid" placeholder="Customer ID" required>
            <div class="invalid-feedback" style="width: 100%;">
              Customer ID is required.
            </div>
          </div>
        </div>
        <button class="btn btn-outline-success btn-lg btn-block" name ="checking" type="submit">Continue to checkout</button>
       </form>
        <hr class="mb-4">
        
        
     
    </div>
  </div>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; Team Radiant</p>
  </footer>
</div>
        <script src="./css/create-a-new-quote.js"></script></body>
        <script src="./css/dynamic-form.js"></script></body>
</html>