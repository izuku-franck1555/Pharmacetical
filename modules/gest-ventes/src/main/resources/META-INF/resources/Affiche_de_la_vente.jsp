<%@ include file="/init.jsp" %>
	<div>
		<nav class="container-fluid menu">
			<ul>
				<li class="item-menu activer"><a href="Ajouter_vente">AJOUTER VENTE</a></li>
				<li class="item-menu"><a href="#">MODIFIER VENTE</a></li>
				<li class="item-menu"><a href="listes_vente.jsp">LISTER VENTES</a></li>
				<li class="item-menu"><a href="Ticket_de_caisse">GENERER TICKET</a></li>
			</ul>
		</nav>
	</div>
    <div class="container col-md-6 corps">
	  
	  <form method="post" action="Ajouter_vente" id="form">
	      <H2>Recapitulatif</H2>
	      <input type="hidden" name="conteur" id="cont" value="0">
	      <table class="table">
		      <tr>
		      	<td class="title">Nom du produit</td>
			  	<td class="title">Quantité</td>
			  	<td class="title">Prix</td>
			  </tr>
			  ${produit}
		 </table>
		 <div class="group-champ">
		 	<h2>TOTAL : ${total}</h2>
		 </div>
		 <div class="warning">
		 	<span>${absents}</span>
		 </div>
		 <div class="bouton-group">
		 	<input type="submit" name="confirmation" class="btn btn-success" value="Modifier"/>
	 		<input type="submit" name="confirmation" class="btn btn-success" value="Generer Facture"/>
		 </div>
	  </form>
	  
	  <form method="post" action="Ticket_de_caisse">
	  	${produits}
	  	<div class="bouton-group">
	  		<input type="hidden" name="conteur" id="cont2" value="0">
	 		<input type="submit" name="confirmation" class="btn btn-success" value="Generer Ticket"/>
	 	</div>
	  </form>
  </div>
	<script>
	function test(){
		alert('bonjour');
	}
		function count_produit(){
			var produits = document.getElementsByClassName("produit");
			alert (produits.length);
			document.getElementById("cont").setAttribute('value',produits.length);
			document.getElementById("cont2").setAttribute('value',produits.length);
		}
	</script>