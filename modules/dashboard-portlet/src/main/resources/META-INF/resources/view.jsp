<%@ include file="/init.jsp" %>

<!-- Starting Dashboard-->
	<div class="container">
		<div class="d-flex justify-content-left align-content-start flex-wrap dashboard">
	  		<div class="p-4 box-app">
	  			<a href="#1"><span class="box-app-link"></span></a>
		  		<table style="width:100%">
		  			<tr><th><img src="<%=request.getContextPath()%>/images/gest-vente-mod.png" width="98" height="98"></th></tr>
		  			<tr><th style="text-align: center;">Gestionnaire de ventes</th></tr>
		  		</table>
	  		</div>
  			<div class="p-4 box-app">
 				<a href="#2"><span class="box-app-link"></span></a>
  				<table style="width:100%">
  					<tr><th><img src="<%=request.getContextPath()%>/images/gest-stock-mod.png" width="98" height="98"></th></tr>
  					<tr><th style="text-align: center;">Gestionnaire de stocks</th></tr>
  				</table>
  			</div>
	       	<div class="p-4 box-app">
 				<a href="#3"><span class="box-app-link"></span></a>
  				<table style="width:100%">
  					<tr><th><img src="<%=request.getContextPath()%>/images/messages-mod.png" width="98" height="98"></th></tr>
  					<tr><th style="text-align: center;">Messages</th></tr>
  				</table>
		  	</div>
		  	<div class="p-4 box-app">
   	   			<a href="#4"><span class="box-app-link"></span></a>
  				<table style="width:100%">
  					<tr><th><img src="<%=request.getContextPath()%>/images/settings-mod.png" width="98" height="98"></th></tr>
  					<tr><th style="text-align: center;">Settings</th></tr>
  				</table>
	  		</div>
	  		<div class="p-4 box-app">
 				<a href="#5"><span class="box-app-link"></span></a>
  				<table style="width:100%">
  					<tr><th><img src="<%=request.getContextPath()%>/images/gestionnaire-mod.png" width="98" height="98"></th></tr>
  					<tr><th style="text-align: center;">Gestionnaire de modules</th></tr>
  				</table>
	  		</div>
	  	</div>
	</div>
<!-- Ending Dashboard-->