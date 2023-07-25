<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Tasks</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>Project: <c:out value="${selectedProject.title}"/></h1>
			<a href="/dashboard">back to Dashboard</a>
		</div>
		<p>Project Lead: <c:out value="${selectedProject.creator.firstName}"/></p>
		<hr />
		<form:form action="/tasks/${selectedProject.id}/create" method="post" modelAttribute="newTask" class="container w-75 mt-3">
			<div class="d-flex flex-column justify-content-center">
				<div>
					<form:errors path="taskTicket" class="text-danger"/>
					<p class="d-flex flex-row justify-content-between align-items-center">
						<form:label path="taskTicket">Add a task ticket:</form:label>
						<form:textarea cols="31" rows="3" path="taskTicket"/>
					</p>
				</div>
				<input type="submit" value="Submit"/>
			</div>
		</form:form>
		<hr />
		<div class="container w-50 mt-3">
			<c:forEach var="oneTask" items="${selectedProject.projectTasks}">
				<div class="mb-5">
					<p>Added by <c:out value="${oneTask.creatorForTask.firstName}"/> at <fmt:formatDate value="${oneTask.createdAt}" pattern="hh:mm a MMM dd"/>:</p>
					<p><c:out value="${oneTask.taskTicket}"/></p>				
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>