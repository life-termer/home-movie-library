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
	<title>Insert title here</title>
	
	<!-- reference our style sheet -->
	
	<link 	type="text/css"
			rel="stylesheet"
			href = "${pageContext.request.contextPath}/resources/css/main-style.css" />
</head>
<body>
	<!-- construct an "add movie" link -->
	<c:url var="addMovieLink" value="/movie/showFormForAdd"></c:url>
	
	<div class="header">
 		 <h1>Header</h1>
	</div>
	
	<div id="navbar">
  		<a class = "active" href="${pageContext.request.contextPath}/movie/list">Home</a>
  		<a href="${addMovieLink}">Add</a>
  		<a href="#search">Search</a>
	</div>
	
	<div class="content">
	<div class="row">
  		<div class="column">
    		<h2>Column</h2>
   				<p>Text</p>
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