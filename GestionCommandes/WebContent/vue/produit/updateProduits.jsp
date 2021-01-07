<%@page import="ma.fstt.entities.Produit"%>
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
<title>Update Produit</title>
</head>
<body>
	<section id="hero" class="d-flex align-items-center">
		<div class="container position-relative" style="padding-top: 0px !important ;">
		<div class="row justify-content-center" style = "padding-bottom: 45px;" >
		        <div class=" text-center">
		          <h1>Modifier un Produit</h1>
		        </div>
		</div>
			<% Produit p = (Produit)request.getAttribute("produit"); %>
			
			<form method="POST" action="UpdateProduit">
				<div class="form-group">
				 	<label for="label">Label:</label>
				 	<input class="form-control" type="text" value="<%= p.getLabel() %>" name="label" id="label">
			 	</div>
			 	<div class="form-group">
				 	<label for="price">Price:</label>
				 	<input class="form-control" type="text" value="<%= p.getPrice() %>" name="price" id="price">
			 	</div>
			 	<input type="hidden" value="<%= p.getId() %>" name="id" id="id">
			 	
			 	<input class="btn btn-success" type="submit" value="Update">
			 </form>
	 	</div>
	 </section>
</body>
</html>