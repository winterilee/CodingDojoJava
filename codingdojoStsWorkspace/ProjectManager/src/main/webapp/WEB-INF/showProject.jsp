<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Detail</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>Project Details</h1>
			<a href="/dashboard">back to Dashboard</a>
		</div>
		<div>
			<table class="table table-hover mt-3">
				<tbody>
					<tr>
						<th>Project:</th>
						<td><c:out value="${projectToShow.title}"/></td>
					</tr>
					<tr>
						<th>Description:</th>
						<td><c:out value="${projectToShow.description}"/></td>
					</tr>
					<tr>
						<th>Due Date:</th>
						<td><fmt:formatDate value="${projectToShow.dueDate}" pattern="MM/dd/yyyy"/></td>
					</tr>
				</tbody>
			</table>
		</div>
		<c:if test="${projectToShow.creator.id == userId}">
			<div class="d-flex flex-row justify-content-end">
				<form action="/projects/delete/${projectToShow.id}">
					<button type="submit" class="btn btn-danger btn-sm">Delete Project</button>
				</form>
			</div>
		</c:if>
		<a href="/tasks/${projectToShow.id}">See Tasks</a>
	</div>
</body>
</html>