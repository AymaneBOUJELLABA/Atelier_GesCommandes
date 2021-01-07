<%@page import="ma.fstt.entities.Client"%>
<%@page import="ma.fstt.entities.Commande"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Commandes</title>
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
		          <h1>Les Commandes</h1>
		        </div>
		</div>
		
		<% 
			List<Commande> commandes = (List<Commande>)request.getAttribute("commandes");
			List<Client> clients = (List<Client>)request.getAttribute("clients");
		%>	
	    <table class="table">
			<thead>
				<tr>
					<th scope="col" >Id</th>
					<th scope="col">Date</th>
					<th scope="col">Id_client</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<%	if(commandes!=null)
				{
					for(Commande c : commandes)
					{
					%>
				    <tr>	
						<td><%= c.getId() %></td>
						<td><%= c.getDate() %></td>
						<td><%= c.getId_client() %></td>
						
						<td><a class="btn btn-danger" href="DeleteCommande?id=<%= c.getId() %>">Supprimer</a></td>
						<td><a class="btn btn-secondary" href="LignesDeCommande?id_commande=<%= c.getId() %>">Afficher Détails</a></td>
				    </tr>
					<%}%>
				<%}%>
					<tr>
						<td>
							<button type="button" class="btn btn-primary" id="add">Ajouter une nouvelle commande</button>
						</td>
					</tr>
				
		</table>
		</div>
		</section>	
		
		<div id="dialog" title="Ajouter une nouvelle commande" style="display:none;">
			<form method="POST" action="SaveCommande">
				<div class="form-group">
				 	<label for="date">Date:</label>
				 	<input class ="form-control" type="date" name="date" id="date">
				 </div>
				 <div class="form-group">
				 	<label for="id_client">Client :</label>
				 	<select class="form-select" id="id_client" name="id_client">
					<%for(Client c: clients)
						{%>
						<option value="<%= c.getId()%>"><%=c.getName() %></option>
					<%	}%>
				</select>
				</div>
			 	<input class="btn btn-success" type="submit" value="Ajouter">
			 </form>
		</div>
		
		<script type="text/javascript">
			$(document).ready(function()
			{
				$('#add').click(function()
			    {
					$('#dialog').dialog({
						height:400,
						width:600
					});
				});
			});
		</script>
	</body>
</html>