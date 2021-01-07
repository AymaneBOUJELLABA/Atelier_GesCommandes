<%@page import="ma.fstt.entities.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Produits</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
 	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
	

</head>
<body>
<header id="header" class="fixed-top">
	<div class="container d-flex align-items-center">
      <h1 class="logo mr-auto"><a href="index.jsp">Gestion des commandes</a></h1>
      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li><a href="ListClient">Clients</a></li>
          <li><a href="ListProduit">Produits</a></li>
          <li><a href="ListCommandes">Commandes</a></li>
         </ul>
      </nav>
      </div>
	</header>
	<section id="hero" class="d-flex align-items-center">
		<div class="container position-relative" style="padding-top: 0px !important ;">
			<div class="row justify-content-center" style = "padding-bottom: 45px;" >
			        <div class=" text-center">
			          <h1>Les Produits</h1>
			        </div>
			</div>
		<% List<Produit> produits = (List<Produit>)request.getAttribute("produits");
			   String err = (String)request.getAttribute("err");
		%>
	
		<c:if test="${not empty err}">
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
			  <strong><%= err %></strong>
			  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
			
			<%request.setAttribute("err", ""); %>
		</c:if>	
	    <table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Label</th>
					<th scope="col">Prix</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<%for(Produit p : produits)
				{
				%>
			    <tr>	
					<td><%= p.getId() %></td>
					<td><%= p.getLabel() %></td>
					<td><%= p.getPrice() %></td>
					
					<td><a class="btn btn-danger" href="DeleteProduit?id=<%= p.getId() %>">Supprimer</a></td>
					<td><a class="btn btn-secondary" href="UpdateProduit?id=<%= p.getId() %>">Modifier</a></td>
			    </tr>
				<%}%>
				
				<tr>
					<td>
						<button type="button" class="btn btn-primary" id="add">Ajouter un nouveau Produit</button>
					</td>
				</tr>
		</table>	
		</div>
		</section>
		<div id="dialog" title="Ajouter un nouveau produit">
		</div>
		
		<script type="text/javascript">
		$(document).ready(function()
		{
			$('#add').click(function()
		    {
				$('#dialog').html('<form method="POST" action="SaveProduit">'+
						'<div class="form-group">'+
						 	'<label for="label">Label:</label>'+
						 	'<input class="form-control" type="text" placeholder="Insert Label" name="label" id="label">'+
					 	'</div>'+
					 	'<div class="form-group">'+
						 	'<label for="price">Prix:</label>'+
						 	'<input class="form-control" type="text" placeholder="Insert Price" name="price" id="price">'+
					 	'</div>'+
					 	'<input class="btn btn-success" type="submit" value="Ajouter"></form>');
				$('#dialog').dialog({
					height:400,
					width:600,
				});
			});
		});

		</script>
	</body>
</html>