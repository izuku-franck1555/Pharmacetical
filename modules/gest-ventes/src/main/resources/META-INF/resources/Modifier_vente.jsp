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
				<li class="item-menu activer"><a href="#">MODIFIER VENTE</a></li>
				<li class="item-menu"><a href="listes_vente.jsp">LISTER VENTES</a></li>
				<li class="item-menu"><a href="Ticket_de_caisse">GENERER TICKET</a></li>
			</ul>
		</nav>
	</header>
    <div class="container col-md-6 corps">
	  <form method="post" action="#" id="form">
	      <H2>Modifier Vente</H2>
	      <input type="text" class="champ-texte" placeholder="identifiant de la vente" required><br>
	      <div class="bouton-group">
	      	<input type="reset" value="Annuler" class="btn btn-warning">
	      	<input type="submit" value="Valider" class="btn btn-success">
	      </div>
	  </form>
  </div>
</body>
</html>