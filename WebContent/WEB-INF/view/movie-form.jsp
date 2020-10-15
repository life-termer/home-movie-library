<!-- add support for Spring MVC Form Tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>
	
	<link 	type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" >
			
	<link 	type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" >
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2> CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<h3>Save Customer</h3>
		
		<!-- saveCustomer - send to Spting MVC mapping -->
		<form:form action="saveMovie" modelAttribute="movie" method="POST">
		
		<!-- need to associate this data with customer id -->
		<form:hidden path="id" />
		
			<table>
				<tbody>
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="movTitle" /></td>
					</tr>
					<tr>
						<td><label>Year:</label></td>
						<td><form:input path="movYear" /></td>
					</tr>
					<tr>
						<td><label>Time:</label></td>
						<td><form:input path="movTime" /></td>
					</tr>
					<tr>
						<td><label>Language:</label></td>
						<td><form:input path="movLang" /></td>
					</tr>
					<tr>
						<td><label>Release Date:</label></td>
						<td><form:input path="movDate" /></td>
					</tr>
					<tr>
						<td><label>Release Country:</label></td>
						<td><form:input path="movCountry" /></td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="movDedcr" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		
		</form:form>
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/movie/list">Back to List</a>
</body>
</html>