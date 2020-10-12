<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link href="import-products.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <nav class="navbar navbar-expand fixed-top navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Team Radiant</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
        </button>
      
        <div class="collapse navbar-collapse" id="navbarsExample02">
          <ul class="navbar-nav mr-auto">
          </ul>
          <form class="form-inline my-2 my-md-0" action="LogoutServlet" method="post">
            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Logout</button>
          </form>
        </div>
      </nav>







        
        
          
		<form class="beaut" action="FileUploadHandler" enctype="multipart/form-data" method="post">
		 <div class="form-group">
		 <label for="exampleFormControlFile1">Import Products Using<b> XML File</b></label>
         
              
				 <input class="form-control-file shadow" id="exampleFormControlFile1" type="file" name="file2" /><br>
				 </div>
               <input class="btn btn-lg btn-primary btn-success shadow"  type="submit" value="Upload" />
           </form>  
           
</body>
</html>
           
           <%
           String file_name=(String)request.getParameter("filename");
           if(file_name!=null){
        	   out.println(" File uploaded successfuly");
           }
           %>
           




