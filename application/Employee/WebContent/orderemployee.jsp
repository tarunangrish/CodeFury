<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Employee Dashboard</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link href="order-management-employee.css" rel="stylesheet">

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
  </head>
  <body>
    <nav class="navbar navbar-expand fixed-top navbar-dark bg-dark">
      <a class="navbar-brand" href="#">Team Radiant</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
      </button>
    
      <div class="collapse navbar-collapse" id="navbarsExample02">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-md-0" action="LogoutEmployee" >
          <button class="btn btn-outline-info my-2 my-sm-0" name="username" type="submit">Logout</button>
        </form>
        
      </div>
    </nav>
    <br><br><br><br>
    
<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
%>


WELCOME ${username1} 
 ${time}

  
</div>



<div class="container">
  <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
      <div class="card-body">
        <h1 class="card-title pricing-card-title">Import Products</h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>10 users included</li>
          <li>Help center access</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-outline-success" onclick="document.location='index.jsp'">Import Products</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-body">
        <h1 class="card-title pricing-card-title">Create New Quote</h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>20 users included</li>
          <li>Help center access</li>
        </ul>
        
        <form action="list" >

<input type="submit" class="btn btn-lg btn-block btn-outline-success" value="Create Quote"></input>
</form>
       
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-body">
        <h1 class="card-title pricing-card-title">View Order List</h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>Access Order List Here</li>
          <li>Help center access</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-outline-success"onclick="document.location='list-of-orders.html'">Order Dashboard</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>