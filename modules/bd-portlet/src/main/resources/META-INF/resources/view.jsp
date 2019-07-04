<%@page import="javax.portlet.ProcessAction"%>
<%@ include file="/init.jsp" %>
<portlet:actionURL name="processAction" var="processAction" />
<aui:form method="post" action="<%= processAction %>">
<aui:input name="nom" label="Nom : " />
<aui:input name="prenom" label="Prenom : " />
<aui:button type="submit" value="Envoyer !" />
</aui:form>