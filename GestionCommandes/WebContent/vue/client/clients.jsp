<%@page import="ma.fstt.entities.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
	  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	  <!-- Template Main CSS File -->
	  <link href="assets/css/style.css" rel="stylesheet">
	
		<meta charset="ISO-8859-1">
		<title>Clients</title>
  		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="/resources/demos/style.css">
	 	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	 	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
		          <h1>Les Clients</h1>
		        </div>
		</div>
	<% List<Client> clients = (List<Client>)request.getAttribute("ListClients");
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
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Address</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<%for(Client c : clients)
				{
				%>
			    <tr>	
					<td><%= c.getId() %></td>
					<td><%= c.getName() %></td>
					<td><%= c.getEmail() %></td>
					<td><%= c.getAddress() %></td>
					
					<td><a class="btn btn-danger" href="DeleteServlet?id=<%= c.getId() %>">Supprimer</a></td>
					<td><a class="btn btn-secondary" href="UpdateServlet?id=<%= c.getId() %>">Modifier</a></td>
			    </tr>
				<%}%>
				
				<tr>
					<td>
						<button type="button" class="btn btn-primary" id="add">Ajouter un nouveau Client</button>
					</td>
				</tr>
		</table>	
		
	</div>
	</section>
		
		
		
		<div id="dialog" title="Ajouter un nouveau client">
		</div>
		
		<script type="text/javascript">
		$(document).ready(function()
		{
			$('#add').click(function()
		    {
				$('#dialog').html(' <form method="POST" action="SaveServlet">'+
						'<div class="form-group">'+
					 	'<label for="name">Name:</label>'+
					 	'<input class="form-control" type="text" placeholder="Insert name" name="name" id="name">'+
					 	'</div>'+
					 	'<div class="form-group">'+
					 	'<label for="email">Email:</label>'+
					 	'<input class="form-control" type="text" placeholder="Insert Email" name="email" id="email">'+
					 	'</div>'+
					 	'<div class="form-group">'+
					 	'<label for="address">Address:</label>'+
					 	'<input class="form-control" type="text" placeholder="Insert Address" name="address" id="address">'+
					 	'</div>'+
					 	'<input class="btn btn-success" type="submit" value="Ajouter"></form>');
				$('#dialog').dialog({
					height:400,
					width:600
				});
			});
		});

		</script>
	</body>
</html>