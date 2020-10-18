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
	<title>Home Movie Library</title>

	<!-- reference our style sheet -->
	
	<link 	type="text/css"
			rel="stylesheet"
			href = "${pageContext.request.contextPath}/resources/css/main-style.css" />
	<link 	type="text/css"
			rel="stylesheet"
			href = "${pageContext.request.contextPath}/resources/css/w3.css" />
						
</head>
<body>

<body>

	<div class="header">
 		 <h1>Home Movie Library</h1>
	</div>
	<!-- construct an "add movie" link -->
	<c:url var="addMovieLink" value="/movie/showFormForAdd"></c:url>
	
	
	<div id="navbar">
  		<a class = "active" href="${pageContext.request.contextPath}/movie/list">Home</a>
  		<a href="${addMovieLink}">Add</a>
  		<a href="#search">Search</a>
	</div>
		<div class="content">
				
		<div class="row">
			<!-- loop over and print our movies -->
			<c:forEach var="tempMovie" items="${movies}">
			
				<!-- construct an "update" link with movie id -->
				<c:url var="updateLink" value="/movie/showFormForUpdate">
					<c:param name="movieId" value="${tempMovie.id }" />
				</c:url>
				
				<!-- construct an "delete" link with movie id -->
				<c:url var="deleteLink" value="/movie/delete">
					<c:param name="movieId" value="${tempMovie.id}" />
				</c:url>
		
  		<div class="column">
  		
  			<div class="w3-container w3-padding-16">
 				 
 				<div class="w3-card-4" style="width:100%">
   				 <header class="w3-container w3-light-grey">
      				<h3>${tempMovie.movTitle}</h3>
    			</header>
    			
   		 			<div class="w3-container">
      					<p>${tempMovie.movYear} ${tempMovie.movTime} min</p>
     		 				<hr>
     		 			<img src="${pageContext.request.contextPath}/resources/img/snatch-poster.jpg" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:100px">
      					<p>${tempMovie.movDedcr}</p><br>
    				</div>
    				
    					<a href="${addMovieLink}" class="w3-button w3-hover-green w3-dark-grey" style="width:31%">More</a>
    					<a href="${updateLink}" class="w3-button w3-dark-grey" style="width:31%">Edit</a> 
    					<a href="${deleteLink}" onclick="if (!(confirm('Are you shure you want to delete this movie?'))) return false" 
    							class="w3-button w3-dark-grey" style="width:31%">Delete</a>
 					 </div>
				</div>				
  			</div> 
 			</c:forEach>
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
</body>
</html>