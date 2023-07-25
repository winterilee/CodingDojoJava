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
		<div>
			<div class="d-flex flex-row justify-content-between align-items-center">
				<h3>Available Projects:</h3>
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
					<c:forEach var="oneProject" items="${notUserProjects}">
						<tr>
							<td><a href="/projects/show/${oneProject.id}"><c:out value="${oneProject.title}"/></a></td>
							<td><c:out value="${oneProject.creator.firstName}"/></td>
							<td><fmt:formatDate value="${oneProject.dueDate}" pattern="MMM dd"/></td>
							<td><a href="/projects/join/${oneProject.id}">Join Team</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<div class="d-flex flex-row justify-content-between align-items-center">
				<h3>Your Projects:</h3>		
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
					<c:forEach var="oneProject" items="${userProjects}">
						<tr>
							<td><a href="/projects/show/${oneProject.id}"><c:out value="${oneProject.title}"/></a></td>
							<td><c:out value="${oneProject.creator.firstName}"/></td>
							<td><fmt:formatDate value="${oneProject.dueDate}" pattern="MMM dd"/></td>
							<c:choose>
								<c:when test="${oneProject.creator.id == userId}">
									<td><a href="/projects/edit/${oneProject.id}">Edit</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="/projects/unjoin/${oneProject.id}">Leave team</a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>	
</body>
</html>