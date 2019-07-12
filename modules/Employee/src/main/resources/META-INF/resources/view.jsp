<%@ include file="/init.jsp" %>
<portlet:defineObjects />
<portlet:renderURL  var="addEmployee" windowState="normal">
<portlet:param name="mvcPath" value="/addEmployee.jsp"/>
</portlet:renderURL>
<h1>Welcome to Liferay MVC Employee Portlet</h1>
<a href="<%=addEmployee.toString()%>">Add Employee</a><br/>