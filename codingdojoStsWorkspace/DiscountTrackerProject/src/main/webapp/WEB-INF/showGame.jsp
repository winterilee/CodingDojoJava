<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>${gameToShow.title}</h1>
			<a href="/dashboard">back to Dashboard</a>
		</div>
		<div>
			<table class="table table-hover mt-3">
				<tbody>
					<tr>
						<th>Game title:</th>
						<td><c:out value="${gameToShow.title}"/></td>
					</tr>
					<tr>
						<th>Price:</th>
						<td>$<c:out value="${gameToShow.price}"/></td>
					</tr>
				</tbody>
			</table>
		</div>
		<c:if test="${gameToShow.creator.id == userId}">
			<div class="d-flex flex-row justify-content-end">
				<form action="/games/edit/${gameToShow.id}" class="me-3">
					<button type="submit" class="btn btn-warning btn-sm">Edit</button>
				</form>
				<form action="/games/delete/${gameToShow.id}">
					<button type="submit" class="btn btn-danger btn-sm">Delete</button>
				</form>
			</div>
		</c:if>
	</div>
</body>
</html>