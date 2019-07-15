<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- Starting Dashboard-->
	<div class="container">
		<div class="d-flex justify-content-left align-content-start flex-wrap dashboard">
	  		<c:forEach items="${list}" var="module">
	  			<div class="p-4 box-app">
		  			<a href="${module['chemin']}"><span class="box-app-link"></span></a>
			  		<table style="width:100%">
			  			<tr><th><img src="<%=request.getContextPath()%>/images/${module['nom_image']}" width="98" height="98"></th></tr>
			  			<tr><th style="text-align: center;">${module['nom']}</th></tr>
			  		</table>
	  			</div>
	  		</c:forEach>
	  	</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function () {
			$.notiny.addTheme('green', {
  				notification_class: 'notiny-theme-green mytheme' 
			});
			$.notiny({ text: 'BIENVENUE ${personne.nom} ! ', position: 'right-top', theme: 'green', width : '400', delay : 600000});
		});
	</script>
<!-- Ending Dashboard-->