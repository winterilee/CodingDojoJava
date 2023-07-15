<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1><c:out value="${bookToShow.title}"/></h1>
			<a href="/dashboard">back to the shelves</a>	
		</div>
		<c:choose>
			<c:when test="${bookToShow.creator.id == userId}">
				<div class="d-flex flex-column mt-3">
					<h3>You read <c:out value="${bookToShow.title}"/> by <c:out value="${bookToShow.author}"/>.</h3>
					<h4>Here are your thoughts:</h4>				
				</div>
			</c:when>
			<c:otherwise>
				<div class="d-flex flex-column mt-3">
					<h3><c:out value="${bookToShow.creator.firstName}"/> read <c:out value="${bookToShow.title}"/> by <c:out value="${bookToShow.author}"/>.</h3>
					<h4>Here are <c:out value="${bookToShow.creator.firstName}"/>'s thoughts:</h4>
				</div>
			</c:otherwise>
		</c:choose>
		<hr/>
		<p><c:out value="${bookToShow.review}"/></p>
		<hr />
		<c:if test="${bookToShow.creator.id == userId}">
			<div class="d-flex flex-row justify-content-end">
				<form action="/books/edit/${bookToShow.id}" class="me-3">
					<button type="submit" class="btn btn-warning btn-sm">Edit</button>
				</form>
				<form action="/books/delete/${bookToShow.id}">
					<button type="submit" class="btn btn-danger btn-sm">Delete</button>
				</form>
			</div>
		</c:if>
	</div>
</body>
</html>