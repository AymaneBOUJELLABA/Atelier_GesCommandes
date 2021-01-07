<%@page import="ma.fstt.entities.LigneCommande"%>
<%@page import="java.util.List"%>
<%@page import="ma.fstt.entities.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Commande Details</title>
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
		          <h1>Détail de commande</h1>
		        </div>
		</div>
		<% 
			int idCmd = (Integer)request.getAttribute("id_commande");

			List<LigneCommande> lignecommandes = (List<LigneCommande>)request.getAttribute("lignescommande");
			List<Produit> produits = (List<Produit>)request.getAttribute("produits");
		%>	
	    <table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Quantité</th>
					<th scope="col">Id_Produit</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<%	if(lignecommandes!=null)
				{
					for(LigneCommande lc : lignecommandes)
					{
					%>
				    <tr>	
						<td><%= lc.getId() %></td>
						<td><%= lc.getQte() %></td>
						<td><%= lc.getId_produit() %></td>
						
						<td><a class="btn btn-danger" href="DeleteLigneCommande?id=<%= lc.getId() %>">Supprimer</a></td>
						<td><a class="btn btn-secondary" href="UpdateLigneCommande?id=<%= lc.getId() %>">Modifier</a></td>
				    </tr>
					<%}%>
				<%}%>
					<tr>
						<td>
							<button class="btn btn-primary"  id="add">Ajouter une nouvelle ligne de commande</button>
						</td>
					</tr>
				
		</table>	
		</div>
		</section>
		<div id="dialog" title="Ajouter une nouvelle ligne de commande" style="display:none;">
			<form method="POST" action="SaveLigneCommande">
				<div class="form-group">
				 	<label for="qte">Quantite:</label>
				 	<input class="form-control" type="number" name="qte" id="qte">
			 	</div>
			 	<div class="form-group">
				 	<label for="id_produit">Produit :</label>
				 	<select class="form-select" id="id_produit" name="id_produit">
					<%for(Produit p: produits)
						{%>
						<option value="<%=p.getId()%>"><%=p.getLabel() %></option>
					<%	}%>
					</select>
				</div>
				<input type="hidden" name="id_commande" id="id_commande" value="<%= idCmd %>">
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