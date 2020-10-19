<!--add support for JSP Standard Tag Library (JSTL) Core tags--> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- add support for Spring MVC Form Tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" />

<title>HML | Edit</title>
	<link 	type="text/css"
			rel="stylesheet"
			href = "${pageContext.request.contextPath}/resources/css/main-style.css" />
			
	<link 	type="text/css"
			rel="stylesheet"
			href = "${pageContext.request.contextPath}/resources/css/w3.css" />
	<style>
			html, body, h1, h2, h3, h4, h5, h6 {
  			font-family: "Comic Sans MS", cursive, sans-serif;
			}
	</style>
</head>
<body>

	<!-- construct an "add movie" link -->
	<c:url var="addMovieLink" value="/movie/showFormForAdd"></c:url>
	
	<div class="header">
 		 <h1>Home Movie Library</h1>
	</div>
	
	<div id="navbar">
  		<a class = "active" href="${pageContext.request.contextPath}/movie/list">Home</a>
  		<a href="${addMovieLink}">Add</a>
  		<a href="#search">Search</a>
	</div>
	
	<div class="content">
	
		<div id="container">
	
		<h1>Save Customer</h1>
		
		<!-- saveCustomer - send to Spring MVC mapping -->
		<form:form action="saveMovie" modelAttribute="movie" method="POST" enctype="multipart/form-data">
		
		<!-- need to associate this data with customer id -->
		<form:hidden path="id" />
		
			<table>
				<tbody>
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="movTitle" name="name"/></td>
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
						<td><label>Storyline:</label></td>
						<td><form:input path="movStory" /></td>
					</tr>
					<tr>
						<td><label>Upload a poster:</label></td>
						<td> 
							<input type="file" class="file" name="file"/>
    								
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		
		</form:form>
		</div>
	</div>
</body>
</html>