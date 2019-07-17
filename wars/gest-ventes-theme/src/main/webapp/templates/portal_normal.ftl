<!DOCTYPE html>

<#include init />
 
<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	<link rel="icon" type="image/png" href="${pathImg}/favicon.ico"/>
	<link rel="stylesheet" href="${pathCss}/bootstrap.min.css">
	 <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
	<link rel="stylesheet" href="${pathCss}/w3.css">
	<link rel="stylesheet" href="${pathCss}/monstyle.css">
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="container-fluid" id="wrapper">
	<header id="banner" class="w3-row w3-card  w3-container w3-light-green" role="banner">
		<div class="w3-panel w3-third w3-center">
			<img src="${pathImg}/ico2.jpg" class="w3-image w3-card w3-round-large" style="width:13%;height:auto;">
			<span class="w3-text-white w3-xlarge w3-center">Gestionnaire de ventes</span>
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
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />
</body>

</html>