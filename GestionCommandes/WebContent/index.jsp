<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  
  
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

  <!-- Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">


<title>GD</title>
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
		<div class="container position-relative" >
			<div class="row justify-content-center">
		        <div class="col-xl-7 col-lg-9 text-center">
		          <h1>Une gestion total des commandes</h1>
		          <h2>L'ajout, la modification et suppresion </h2>
		        </div>
		    </div>
			<div class="row icon-boxes">
        		<div class="col-md-6 col-lg-4 d-flex align-items-stretch mb-5 mb-lg-0" >
          			<div class="icon-box">
            			<div class="icon"><i class="ri-user-line"></i></div>
				            <h4 class="title"><a href="ListClient">Clients</a></h4>
				            <p class="description">Listes des clients avec leur fonctionalités </p>
				        </div>
        		</div>
        		<div class="col-md-6 col-lg-4 d-flex align-items-stretch mb-5 mb-lg-0" >
		          <div class="icon-box">
		            <div class="icon"><i class="ri-store-line"></i></div>
			            <h4 class="title"><a href="ListProduit">Produits</a></h4>
			            <p class="description">Ensemble des produits et espace pour les ajouter</p>
		          </div>
        		</div>	
        		<div class="col-md-6 col-lg-4 d-flex align-items-stretch mb-5 mb-lg-0" >
		          <div class="icon-box">
		            <div class="icon"><i class="ri-shopping-basket-line"></i></div>
			            <h4 class="title"><a href="ListCommandes">Commandes</a></h4>
			            <p class="description">Espace des commande connecter avec tous les lignes des commandes</p>
		          </div>
        </div>
        	</div>
		</div>
	
	</section>
	
</body>
</html>