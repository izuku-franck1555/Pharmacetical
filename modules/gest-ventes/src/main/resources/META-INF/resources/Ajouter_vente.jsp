<%@ include file="/init.jsp" %>
	<portlet:renderURL name="AjouterVente" var="AjouterVenteURL" />
	<portlet:renderURL name="ListerVente" var="ListerVenteURL" />
	<portlet:renderURL name="ModifierVente" var="ModifierVenteURL" />
	<portlet:renderURL name="GenererTicket" var="GenererTicketURL" />
	<portlet:actionURL name="AfficherVente" var="AfficherVenteURL" />
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/creer_ligne.js"></script>
		<nav class="w3-container w3-light-green w3-bar w3-text-white w3-center-align">
				<a href="${AjouterVenteURL}" class="w3-btn w3-hover-green activer">AJOUTER VENTE</a>
				<a href="${ModifierVenteURL}" class="w3-btn w3-hover-green">MODIFIER VENTE</a>
				<a href="${ListerVenteURL}" class="w3-btn w3-hover-green">LISTER VENTES</a>
				<a href="${GenererTicketURL}" class="w3-btn w3-hover-green">GENERER TICKET</a>
		</nav>
	
    <div class="container col-md-6 corps col-xs-12" id="tin">
	  <form method="post" action="${AfficherVenteURL}" id="form">
	      <div class="champ-group">
	      	<h2>Nom du produit</h2>
		  	<h2>Quantites</h2>
		  </div>
		  <div id="champs">
			  ${produit}
	      </div>
	      <div class="bouton-group">
	      	<label for="t"><a onclick="plus();" class="ndel btn btn-success"> ajouter produit </a> </label> 
	      	<a onclick="moins()" class="del btn btn-success"> supprimer produit </a>
	      </div>
		      	<input type="hidden" name="conteur" id="cont" value="0" required="required"/>
	      <div class="bouton-group">
		      <input type="submit" class="del btn btn-success" name="envoyer" value="envoyer"/>
		      <input type="reset" class="del btn btn-warning" name ="annuler" value="annuler"/>
		  </div>
	  </form>
	 ${affiche} 
		 <div class="group-champ">
		 	<h2>${total}</h2>
		 </div>
  </div>
