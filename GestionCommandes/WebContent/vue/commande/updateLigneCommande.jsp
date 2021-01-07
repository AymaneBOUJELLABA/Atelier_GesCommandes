<%@page import="ma.fstt.entities.LigneCommande"%>
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
<title>Update Ligne de Commande</title>
</head>
<body>
	<section id="hero" class="d-flex align-items-center">
		<div class="container position-relative" style="padding-top: 0px !important ;">
		<div class="row justify-content-center" style = "padding-bottom: 45px;" >
		        <div class=" text-center">
		          <h1>Modifier ligne de commande</h1>
		        </div>
		</div>
	<% LigneCommande lcmd = (LigneCommande)request.getAttribute("lcmd"); %>
	
	<form method="POST" action="UpdateLigneCommande">
		<div class="form-group">
		 	<label for="label">Quantité :</label>
		 	<input class="form-control" type="number" value="<%= lcmd.getQte() %>" name="qte" id="qte">
	 	</div>
	 	<input type="hidden" value="<%= lcmd.getId_produit() %>" name="id_produit" id="id_produit">
	 	
	 	<input type="hidden" value="<%= lcmd.getId() %>" name="id" id="id">
	 	
	 	<input type="hidden" value="<%= lcmd.getId_commande() %>" name="id_commande" id="id_commande">
	 	
	 	<input class="btn btn-success" type="submit" value="Update">
	 </form>
	 </div>
	 </section>
</body>
</html>