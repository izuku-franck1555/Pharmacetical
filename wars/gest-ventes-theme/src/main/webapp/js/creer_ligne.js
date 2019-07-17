var pere,tableau_input, ch1, ch2,mere,tab;


function verif(){
	$(document).ready(function(){

		 pere=document.getElementById("champs");
		 tableau_input=pere.getElementsByTagName('div');
		 mere=document.getElementById("tin");
		 tab=mere.getElementsByTagName('table');
		 document.getElementById("cont").setAttribute("value",tableau_input.length);
		 
		if(tableau_input.length==0){
			$(".champ-group").hide(1500);
			$(".del").hide(3000);
		}
		else{
			$(".champ-group").show(1300);
			$(".del").show(1600);
		}
		if(tab.length!=0){
			$("#form").hide();
			$(".tete").hide();
			$("body").css("background-color","gray");
		}
	})
}
verif();
 // ajouter un champ avec son "name" propre;
 function plus(){
	 pere=document.getElementById("champs");
	 tableau_input=pere.getElementsByTagName('div');
	 num_suiv = tableau_input.length + 1;
	 div=document.createElement('div');
	 div.setAttribute('class','champ-group');
	 ch1=document.createElement('input');
	 ch2=document.createElement('input');
	 ch1.setAttribute('type','text');
	 ch1.setAttribute('name','nomProd'+num_suiv);
	 ch1.setAttribute('class', 'item-champ-texte');
	 ch1.setAttribute('required','required');
	 ch1.setAttribute('placeholder','entrer le nom du nouveau produit');
	 ch2.setAttribute('type','text');
	 ch2.setAttribute('required','required');
	 ch2.setAttribute('placeholder','entrer la quantite du nouveau produit');
	 ch2.setAttribute('name','quantiteProd'+num_suiv);
	 ch2.setAttribute('class', 'item-champ-texte');
	 div.appendChild(ch1);
	 div.appendChild(ch2);
	 pere=document.getElementById('champs');
	 pere.appendChild(div);
	 document.getElementById("cont").setAttribute("value",tableau_input.length);
	 verif();
	 
}

//supprimer le dernier champ;
 function moins(){
	 pere=document.getElementById("champs");
	 tableau_input=pere.getElementsByTagName('div');
	 if(tableau_input.length>0){
		 pere.removeChild(tableau_input[tableau_input.length-1]);
		 document.getElementById("cont").setAttribute("cont",tableau_input.length);
		 verif();
		 }
		 
 }
 