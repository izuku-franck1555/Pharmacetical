<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/monstyle.css">

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/creer_ligne.js"></script>

</head>
<body>
	<header>
		<nav class="container-fluid menu">
			<ul>
				<li class="item-menu"><a href="Ajouter_vente">AJOUTER VENTE</a></li>
				<li class="item-menu activer"><a href="#">MODIFIER VENTE</a></li>
				<li class="item-menu"><a href="listes_vente.jsp">LISTER VENTES</a></li>
				<li class="item-menu"><a href="Ticket_de_caisse">GENERER TICKET</a></li>
			</ul>
		</nav>
	</header>
    <div class="container col-md-6 corps">
	  <form method="post" action="#" onsubmit="return verifform()"id="form">
	      <div class="champ-group">
	      	<h2>Nom du produit</h2>
		  	<h2>Quantites</h2>
		  </div>
		  <div id="champs">
			  <div class="champ-group">
		      	<input type="text" class="item-champ-texte" name="nomProd0" placeholder="entrer le nom du produit" required> 
		      	<input type="number" class="item-champ-texte" name="prixProd0" placeholder="entrer la Quantite du produit" required> 
		      </div> 
<!-- 		      <c:out value="$vente"></c:out> -->
	      </div>
	      <div class="bouton-group">
	      	<button onclick="plus();" class="btn btn-success"> ajouter produit </button> 
	      	<button onclick="moins()" class="btn btn-success"> supprimer produit </button>
	      </div>
	      <div class="bouton-group">
		      <input type="submit" class="btn btn-success" name="envoyer" value="envoyer"/>
		      <input type="reset" class="btn btn-warning" name ="annuler" value="annuler"/>
		  </div>
	  </form>
  </div>

</body>
</html>