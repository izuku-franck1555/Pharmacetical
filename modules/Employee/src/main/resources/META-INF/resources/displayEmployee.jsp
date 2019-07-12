<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.portlet.ProcessAction"%>
<%@ include file="/init.jsp" %>
<%@page import="java.util.Map"%>
<portlet:defineObjects />
<h1>Display Employee Details</h1>
<%
Map<String,String> employeeMap=(Map<String,String>) renderRequest.getAttribute("employeeMap");
if(employeeMap!=null){
%>
Emplyee Name: ${var}     <br/>
Emplyee Address: <%=employeeMap.get("employeeAddress")%><br/>
<%}%>