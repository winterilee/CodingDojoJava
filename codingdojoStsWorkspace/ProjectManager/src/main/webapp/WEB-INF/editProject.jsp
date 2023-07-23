<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Project</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container d-flex flex-column mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>Edit Project</h1>
			<a href="/dashboard">back to Dashboard</a>
		</div>
		<hr />
		<form:form action="/projects/update/${projectToEdit.id}" method="put" modelAttribute="projectToEdit" class="container w-75">
			<div class="d-flex flex-column justify-content-center">
				<div>
					<form:errors path="title" class="text-danger"/>
					<p class="d-flex flex-row justify-content-between align-items-center">
						<form:label path="title">Project Title:</form:label>
						<form:input type="text" path="title" class="w-50"/>
					</p>
				</div>
				<div>
					<form:errors path="description" class="text-danger"/>
					<p class="d-flex flex-row justify-content-between align-items-center">
						<form:label path="description">Project Description:</form:label>
						<form:textarea cols="31" rows="3" path="description"/>
					</p>
				</div>
				<div>
					<form:errors path="dueDate" class="text-danger"/>
					<p class="d-flex flex-row justify-content-between align-items-center">
						<form:label path="dueDate">Due Date:</form:label>
						<form:input type="date" path="dueDate" class="w-50"/>
					</p>
				</div>
				<input type="submit" value="Submit"/>
			</div>
		</form:form>
	</div>
</body>
</html>