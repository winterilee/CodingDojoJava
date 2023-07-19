<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>Welcome, <c:out value="${currentUser.firstName}"/>!</h1>
			<a href="/logout">logout</a>		
		</div>
		<hr />
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h3>All Projects:</h3>
			<a href="/projects/new">+ New Project</a>		
		</div>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneProject" items="${allProjects}">
					<tr>
						<td><c:out value="${oneProject.title}"/></td>
						<td><c:out value="${oneProject.creator.firstName}"/></td>
						<td><fmt:formatDate value="${oneProject.dueDate}" pattern="MMM dd"/></td>
						<td><a href="#">Join team</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>	
</body>
</html>