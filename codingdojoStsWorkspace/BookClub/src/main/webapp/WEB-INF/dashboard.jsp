<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>Welcome, <c:out value="${currentUser.firstName}"/>!</h1>
			<a href="/logout">logout</a>		
		</div>
		<hr />
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h3>Books from everyone's shelves:</h3>
			<a href="/books/new">+ Add a book to my shelf!</a>		
		</div>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneBook" items="${allBooks}">
					<tr>
						<td><c:out value="${oneBook.id}"/></td>
						<td><a href="/books/show/${oneBook.id}"><c:out value="${oneBook.title}"/></a></td>
						<td><c:out value="${oneBook.author}"/></td>
						<td><c:out value="${oneBook.creator.firstName}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>