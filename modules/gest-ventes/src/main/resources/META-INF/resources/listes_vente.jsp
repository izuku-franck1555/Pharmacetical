<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>afficher</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/w3.css">
<link rel="stylesheet" type="text/css" href="css/monstyle.css">
<script type="text/javascript" src="js/creer_ligne.js"></script>
</head>
<body>
	<header class="w3-row w3-card w3-container w3-light-green">
		<div class="w3-panel w3-third w3-center">
			<img src="img/ico2.jpg" class="w3-image w3-card w3-round-large" style="width:13%;height:auto;">
			<span class="w3-text-white w3-xlarge w3-center">Gestionnaire de ventes</span>
		</div>
		<nav class="w3-panel w3-bar w3-twothird w3-text-white w3-right-align">
				<a href="Ajouter_vente" class="w3-btn w3-hover-green ">AJOUTER VENTE</a>
				<a href="#" class="w3-btn w3-hover-green">MODIFIER VENTE</a>
				<a href="listes_vente.jsp" class="w3-btn w3-hover-green activer">LISTER VENTES</a>
				<a href="Ticket_de_caisse" class="w3-btn w3-hover-green">GENERER TICKET</a>
		</nav>
	</header>
    <div class="container col-md-6 corps">
	  <form method="post" action="ListerVentes" id="form">
	      <H2>Choisir la periode :
	      	<select id="periode" name="periode" onchange="checkdate(this)">
	      		<option value="jour" selected="selected">Jour</option>
	      		<option value="Annee">Année dernière</option>
	      		<option value="mois">Mois dernier</option>
	      	</select>
	      </H2>
	      <div id="date" style="padding:2em">
	      	<label for="date">Entrez la date du jour : </label> <input type="Date" name="date" required/><br>
	      </div>
	      <div class="bouton-group">
		 	<input type="submit" class="btn btn-success" value="Visualiser"/>
		 	<input type="reset" class="btn btn-warning" value="Annuler"/>
		 </div>
	      <table class="table">
	      	<thead>
		      	<tr>
		      		<th classe="title">Identifiant du produit</th>
		      		<th classe="title">Identifiant vente</th>
		      		<th classe="title">Date vente </th>
		      		<th classe="title">Quantité </th>
		      		<th classe="title">Prix </th>
		      	</tr>
		     </thead>
		     <tbody id="liste">
		     	${ liste_ventes }
		     </tbody>
	      </table>
	  </form>
  </div>
	<script>
		function checkdate(elem){
			var val = elem.value;
			alert(val);
			if(val == 'Annee')
				document.getElementById('date').style="display:none";
			else if(val == 'mois')
				document.getElementById('date').style="display:none";
			else
				document.getElementById('date').style="display:block";
		}
	</script>
</body>
</html>