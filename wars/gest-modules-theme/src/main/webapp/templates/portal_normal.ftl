<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	<link rel="icon" type="image/png" href="${pathImg}/favicon.ico"/>

</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
		<!-- Starting nav bar-->
        <div id="app" class="container">
            <nav class="navbar navbar-expand-lg navbar-light navbar-custom">
                <a class="navbar-brand" href="#">
                        <img src="${pathImg}/ico2.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
                    Gestionnaire de Modules
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div id="navbarNavDropdown" class="navbar-collapse collapse">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                          	<div class="drop">
							  <button class="dropbut">
							  	Consulter
							  	<img src="${pathImg}/fleche2.png">
							  </button>
							  <div class="drop-content">
							  	<a href="${company_url}/connexion">Liste des modules</a>
							  	<a href="${company_url}/connexion">Liste des users</a>
							  </div>
							</div>
	                    </li>
                        <li class="nav-item">
                            <a class="nav-link" href="{{ url('/login') }}">Attribuer un module</a>
                        </li>
                    </ul>
                </div>
            </nav>
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
     
	<!-- Starting Footer-->
        <div id="app" class="container">
            <nav class="navbar navbar-expand-lg navbar-light navbar-custom">
            </nav>
        </div>
    <!-- Ending Footer-->
</div>
	
	<script src="${pathJs}/jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="${pathJs}/bootstrap.min.js"></script>
<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>