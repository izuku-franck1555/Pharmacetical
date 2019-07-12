<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.portlet.ProcessAction"%>
<%@ include file="/init.jsp" %>
<portlet:defineObjects />
<portlet:actionURL var="addEmployeeActionURL" windowState="normal" name="addEmployee">
</portlet:actionURL>
<h1> Add Employee</h1>
<form action="<%= addEmployeeActionURL %>" name="emplyeeForm" method="POST">
Employee Name<br/>
<input  type="text" name="<portlet:namespace/>employeeName" id="<portlet:namespace/>employeeName" placeholder="${placeholder1}"/><br/>
Employee Address<br/>
<input type="text" name="<portlet:namespace/>employeeAddress" id="<portlet:namespace/>employeeAddress" placeholder="${placeholder2}"/><br/>
<input type="submit" name="addEmployee" id="addEmployee" value="Add Employee"/>
</form>