<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>afficher</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/monstyle.css">
<script type="text/javascript" src="js/creer_ligne.js"></script>
</head>
<body>
	<header>
		<nav class="container-fluid menu">
			<ul>
				<li class="item-menu"><a href="Ajouter_vente">AJOUTER VENTE</a></li>
				<li class="item-menu"><a href="#">MODIFIER VENTE</a></li>
				<li class="item-menu"><a href="listes_vente.jsp">LISTER VENTES</a></li>
				<li class="item-menu activer"><a href="Ticket_de_caisse">GENERER TICKET</a></li>
			</ul>
		</nav>
	</header>
    <div class="container col-md-7 corps">
	  <form method="post" action="Ajouter_vente" id="form">
	      <H2>Recapitulatif</H2>
	      <table class="table">
		      <tr>
		      	<td class="title">Nom du produit</td>
			  	<td class="title">Quantité</td>
			  	<td class="title">Prix</td>
			  	<td class="title">Rayon</td>
			  	<td class="title">Etagere</td>
			  	<td class="title">Cellule</td>
			  </tr>
			${affiche}  	  
		 </table>
		 ${form}
		 <div class="bouton-single">
		 	<input type="submit" name="confirmation" class="btn btn-success" value="Generer Facture"/>
		 </div>
	  </form>
	  ${total}
  </div>

</body>
</html>