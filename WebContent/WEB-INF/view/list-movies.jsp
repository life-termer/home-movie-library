<!--add support for JSP Standard Tag Library (JSTL) Core tags--> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>List Movies</title>

	<!-- reference our style sheet -->
	
	<link 	type="text/css"
			rel="stylesheet"
			href = "${pageContext.request.contextPath}/resources/css/style.css" />
			
</head>
<body>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<!-- put a new button: Add Movie -->
		<input type="button" value="Add Movie"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" 
		/>         
	
		<!-- add our html table here -->
		
		<table>
			<tr>
				<th>Title</th>
				<th>Year</th>
				<th>Time</th>
				<th>Language</th>
				<th>Date</th>
				<th>Country</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
			
			<!-- loop over and print our movies -->
			<c:forEach var="tempMovie" items="${movies}">
			
				<!-- construct an "update" link with movie id -->
				<c:url var="updateLink" value="/movie/showFormForUpdate">
					<c:param name="" value="${tempMovie.id }" />
				</c:url>
				
				<!-- construct an "delete" link with movie id -->
				<c:url var="deleteLink" value="/movie/delete">
					<c:param name="" value="${tempMovie.id }" />
				</c:url>
			
				<tr>
					<td> ${tempMovie.movTitle} </td>
					<td> ${tempMovie.movYear} </td>
					<td> ${tempMovie.movTime} </td>
					<td> ${tempMovie.movLang} </td>
					<td> ${tempMovie.movDate} </td>
					<td> ${tempMovie.movCountry} </td>
					<td> ${tempMovie.movDedcr} </td>
				
					<td> 
					
						<!-- display the update link -->
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
						onclick="if (!(confirm('Are you shure you want to delete this movie?'))) return false">
						Delete</a>
						<!-- confirm(...) JavaScript - displays a confirmation popup dialog -->
					</td>
				</tr>
			</c:forEach>
			
			
		</table>
		
		</div>
	</div>

</body>

</body>
</html>