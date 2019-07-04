<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	<link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet">
    <link rel="icon" type="image/png" href="${pathImg}/favicon.ico"/>
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

	<header id="banner" role="banner">
		<!-- Starting nav bar-->
		<div id="app">
	        <div id="app" class="container-fluid">
	            <nav class="navbar navbar-expand-lg navbar-light navbar-custom">
	                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	                    <span class="navbar-toggler-icon"></span>
	                </button>
	                <div id="navbarNavDropdown" class="navbar-collapse collapse">
	                    <ul class="navbar-nav ml-auto">
	                    	<li class="nav-item button-nav">
	                    		<img src="${pathImg}/refresh.png" width="27" height="22">
	                    	</li>
	                    	<li class="nav-item button-nav">
	                    		<img src="${pathImg}/messages.png" width="30" height="25"> 
	                    		<span class="number-messages"> 10 </span>
	                    	</li>
	                    	<li class="nav-item button-nav">
	                    		<img src="${pathImg}/settings.png" width="28" height="23"> 
	                    	</li>
	                        <li class="nav-item">
	                          	<div class="dropdown">
		                          	<button class="drop-button dropdown-toggle button-nav" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	  									Franck Tonle
	  								</button>
	  								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	    								<a class="dropdown-item" href="#">Parametres</a>
	    								<a class="dropdown-item" href="#">Deconnexion</a>
	  								</div>
	  							</div>
	                        </li>
	                    </ul>
	                </div>
	            </nav>
	        </div>
	    </div>
        <!-- Ending nav bar-->
	</header>

	<section id="content">
		<h1 class="hide-accessible">${the_title}</h1>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<footer id="footer" role="contentinfo">
		<!-- Starting Footer-->
        <div class="d-flex justify-content-center align-content-start flex-wrap">
        	<div class="p-4 bloc"><span id="text"> Pharmacetical </span></div>
        </div>
        <!-- Ending Footer-->
	</footer>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="${pathJs}/jquery-3.2.1.min.js"></script>
<script src="${pathJs}/bootstrap.min.js"></script>
<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>