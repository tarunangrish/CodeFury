<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Customer Login</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="./css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <!--This section adds the navbar-->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Team Radiant</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </nav>
    <!--This section ends the navbar-->

    <form action="Login" class="form-signin jumbotron top-top shadow">
      <!--This section starts the user icon-->
  <svg width="72" height="72" viewBox="0 0 16 16" class="bi bi-person-circle mb-4" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
    <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
    <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
    <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
  </svg>
  <!--user icon ends-->

  <h1 class="h3 mb-3 font-weight-normal">Customer Sign In</h1>
  <label for="inputEmail" class="sr-only">Customer ID</label>
  <input type="email" name="inputEmail" class="form-control shadow-up" placeholder="Enter Employee ID" required autofocus>
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" name="inputPassword" class="form-control shadow" placeholder="Password" required>
  <%
  
   String s=(String)request.getAttribute("message");
		  
		  if(s!=null){
			  out.println(s);
		  }
  
  %>
  <div class="">
    <label>
      <p>For <b>Employee</b> Login, <a href="./employee-sign-in.html">Click Here</a></p>
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block btn-success shadow" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted">&copy; Team Radiant - 2020</p>
</form>

</html>