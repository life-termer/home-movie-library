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
			href = "https://www.w3schools.com/w3css/4/w3.css" />
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
 		 <h2>Home Movie Library</h2>
	</div>
	
	<div id="navbar">
  		<a class = "active" href="${pageContext.request.contextPath}/movie/list">Home</a>
  		<a href="${addMovieLink}">Add</a>
  		<a href="#search">Search</a>
	</div>
	
	<div class="content">
		<h3 class="w3-center">Add | Edit Movie</h3>
	
	
		<!-- saveCustomer - send to Spring MVC mapping -->
		<form:form action="saveMovie" modelAttribute="movie" method="POST" enctype="multipart/form-data">
		
		<!-- need to associate this data with movie id -->
		<form:hidden path="id" />
		<div class="w3-content w3-light-gray">
		
			<table class="w3-table-all w3-hoverable">
				<tr>
					<td>Title:</td>
					<td><form:input path="movTitle" name="name"/></td>
				</tr>
				<tr>
					<td>Year:</td>
					<td><form:input path="movYear" /></td>
				</tr>
				<tr>
					<td>Time:</td>
					<td><form:input path="movTime" /></td>
				</tr>
				<tr>
					<td>Language:</td>
					<td><form:input path="movLang" /></td>
				</tr>
				<tr>
					<td>Release Date:</td>
					<td><form:input path="movDate" /></td>
				</tr>
				<tr>
					<td>Release Country:</td>
					<td><form:input path="movCountry" /></td>
				</tr>
				<tr>
					<td>Genre:</td>
					<td><form:input path="movGenre" /></td>
				</tr>
				<tr>
					<td>Director:</td>
					<td><form:input path="movDir" /></td>
				</tr>
				<tr>
					<td>Stars:</td>
					<td><form:input path="movCast" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:textarea path="movDedcr"  rows="5" cols="30"/></td>
				</tr>
				<tr>
					<td>Storyline:</td>
					<td><form:textarea path="movStory" rows="5" cols="30"/></td>
				</tr>
				<tr>
					<td>Upload a poster:</td>
					<td><input type="file" class="file" name="file"/></td>
				</tr> 
				   
    		</table>
    		<input class="w3-button w3-block w3-teal" type="submit" value="Save" class="save" />

			</div>						
		</form:form>
		
	</div>
		<div class="footer">
 		 <h3>Footer</h3>
	</div>
	<script>
		window.onscroll = function() {myFunction()};

		var navbar = document.getElementById("navbar");
		var sticky = navbar.offsetTop;

		function myFunction() {
  			if (window.pageYOffset >= sticky) {
   			 navbar.classList.add("sticky")
  		} else {
   		 navbar.classList.remove("sticky");
  		}
	}
	</script>
</body>
</html>