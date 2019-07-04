<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	<link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet">
	<link rel="icon" type="image/png" href="${pathImg}/favicon.ico"/>
	<link href="${pathCss}/bootstrap.min.css" rel="stylesheet">
    <link href="${pathCss}/util.css" rel="stylesheet">
    <link href="${pathCss}/form.css" rel="stylesheet">
    <link href="${pathCss}/main.css" rel="stylesheet">
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

	<header id="banner" role="banner">
		<div id="app" class="container">
            <nav class="navbar navbar-expand-lg navbar-light navbar-custom">
                <a class="navbar-brand" href="#">
                        <img src="${pathImg}/ico2.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
                    Pharmatical
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div id="navbarNavDropdown" class="navbar-collapse collapse">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="{{ url('/login') }}">Acceuil</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="{{ url('/login') }}">Se Connecter</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
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
		<div id="app" class="container">
            <nav class="navbar navbar-expand-lg navbar-light navbar-custom">
            </nav>
        </div>
	</footer>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>