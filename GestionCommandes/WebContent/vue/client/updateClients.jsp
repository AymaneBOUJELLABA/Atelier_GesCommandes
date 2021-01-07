<%@page import="ma.fstt.entities.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	
	<!-- Vendor CSS Files -->
	<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
	<link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
	<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
	<link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
	<link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
	<link href="assets/vendor/aos/aos.css" rel="stylesheet">
	
	  <!-- Template Main CSS File -->
	  <link href="assets/css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>update client</title>
</head>
<body>
	<section id="hero" class="d-flex align-items-center">
		<div class="container position-relative" style="padding-top: 0px !important ;">
		<div class="row justify-content-center" style = "padding-bottom: 45px;" >
		        <div class=" text-center">
		          <h1>Modifier un Client</h1>
		        </div>
		</div>
	<% Client c = (Client)request.getAttribute("client"); %>
	
	<form method="POST" action="UpdateServlet">
		<div class="form-group">
		 	<label for="name">Name:</label>
		 	<input class ="form-control" type="text" value="<%= c.getName() %>" name="name" id="name">
		</div>
		<div class="form-group">
		 	<label for="email">Email:</label>
		 	<input class ="form-control" type="text" value="<%= c.getEmail() %>" name="email" id="email">
	 	</div>
	 	<div class="form-group">
		 	<label for="address">Address:</label>
		 	<input class ="form-control" type="text" value="<%= c.getAddress() %>" name="address" id="address">
	 	</div>
	 	<input type="hidden" value="<%= c.getId() %>" name="id" id="id">
	 	
	 	<input class="btn btn-success" type="submit" value="Update">
	 </form>
	</div>
	</section>
</body>
</html>