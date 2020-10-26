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
	
	<!-- construct an "update" link with movie id -->
	<c:url var="updateLink" value="/movie/showFormForUpdate">
		<c:param name="movieId" value="${movie.id }" />
	</c:url>
	
	<!-- construct an "delete" link with movie id -->
	<c:url var="deleteLink" value="/movie/delete">
		<c:param name="movieId" value="${movie.id}" />
	</c:url>
	
	<!-- construct an "add review" link with movie id -->
	<c:url var="addReviewLink" value="/review/showFormForAdd">
		<c:param name="movieId" value="${movie.id}" />
	</c:url>
	
	<!-- construct an "update review" link with review id -->
	<c:url var="updateReviewLink" value="/review/showFormForUpdate">
		<c:param name="reviewId" value="${review.revId}" />
	</c:url>
	
	<div class="header">
 		 <h1>Home Movie Library</h1>
	</div>
	
	<div id="navbar">
  		<a class = "active" href="${pageContext.request.contextPath}/movie/list">Home</a>
  		<a href="${addMovieLink}">Add</a>
	</div>
	
	<div class="content">
	<div class="w3-content w3-light-gray">

		<div class="w3-row w3-margin">
		<div class="">
		 	<h3>${movie.movTitle} (${movie.movYear})</h3>
			  
			 <h6> ${movie.movTime} min | ${movie.movGenre} | ${movie.movLang} | 
			 ${movie.movDate} (${movie.movCountry})</h6>
		</div>
			<div class="w3-third">
			  <img src="${pageContext.request.contextPath}/resources/img/${movie.id}.jpg" style="width:100%;min-height:200px">
			</div>
			<div class="w3-twothird w3-container">
			 <p>${movie.movDedcr}</p>
			  <p> <b>Director: </b> ${movie.movDir}
			 <p> <b>Stars: </b> ${movie.movCast}
			
			  
			</div>
			
			</div>
			<div class="w3-row w3-margin">
			
			<div class="w3-twothird w3-container">
			  <h4>Storyline</h4>
			  <p>
			  ${movie.movStory}
			  </p>
			</div>
			
			</div>
			<div class="w3-row w3-margin">
		
			<div class="w3-twothird w3-container">
			  <h4>Reviews</h4>
			</div>
			<div class="w3-third">
			  <a href="${addReviewLink}" class="w3-bar-item w3-button w3-dark-grey" style="width:50%">Add Review</a> 
			</div>
			</div>
			<c:forEach var="tempReview" items="${reviews}">
			
				<!-- construct an "delete review" link with review id -->
				<c:url var="deleteReviewLink" value="/review/delete">
				<c:param name="reviewId" value="${tempReview.revId}" />
				</c:url>
				
				<div class="w3-panel w3-border w3-light-grey w3-round-large w3-margin">
				
				<strong>${tempReview.revName}</strong> - ${tempReview.revRating}
				<p>${tempReview.review}
				
				<a href="${deleteReviewLink}" onclick="if (!(confirm('Are you shure you want to delete this rewiew?'))) return false" 
				class="w3-bar-item w3-button w3-dark-grey" style="width:50%">Delete review</a>
				
				
				</div>
			</c:forEach>
			
			
		</div>
		<div class="w3-bar">
				<a href="${updateLink}" class="w3-bar-item w3-button w3-dark-grey" style="width:50%">Edit</a> 
				<a href="${deleteLink}" onclick="if (!(confirm('Are you shure you want to delete this movie?'))) return false" 
					class="w3-bar-item w3-button w3-dark-grey" style="width:50%">Delete</a>
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