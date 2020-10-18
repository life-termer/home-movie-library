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
	
	<title>HML | ${movie.movTitle}</title>
	
	<!-- reference our style sheet -->
	
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
	
	
	<div class="w3-content">

		<div class="w3-row w3-margin">
		
			<div class="w3-third">
			  <img src="${pageContext.request.contextPath}/resources/img/${movie.id}.jpg" style="width:100%;min-height:200px">
			</div>
			<div class="w3-twothird w3-container">
			  <h2>${movie.movTitle}</h2>
			  
			  <h6>${movie.movYear} | ${movie.movTime} min | ${movie.movLang} | ${movie.movCountry}</h6>
			  <p>${movie.movDedcr}</p>
			</div>
			
			</div>
			<div class="w3-row w3-margin">
			
			<div class="w3-twothird w3-container">
			  <h2>Storyline</h2>
			  <p>
			  ${movie.movDedcr}
			  </p>
			</div>
			
			</div>
			<div class="w3-row w3-margin">
		
			<div class="w3-twothird w3-container">
			  <h2>Reviews</h2>
			  <p>
			  ...
			  </p>
			</div>
		</div>
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