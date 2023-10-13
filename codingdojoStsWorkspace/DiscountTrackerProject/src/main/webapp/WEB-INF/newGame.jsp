<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a game in your list</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container d-flex flex-column mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>New Game</h1>
			<a href="/dashboard">back to Dashboard</a>
		</div>
		<hr />
		<form:form action="/games/create" method="post" modelAttribute="newGame" class="container w-75">
			<div class="d-flex flex-column justify-content-center">
				<div>
					<form:errors path="title" class="text-danger"/>
					<p class="d-flex flex-row justify-content-between align-items-center">
						<form:label path="title">Game:</form:label>
						<form:input type="text" path="title" class="w-50"/>
					</p>
				</div>
				<div>
					<form:errors path="price" class="text-danger"/>
					<p class="d-flex flex-row justify-content-between align-items-center">
						<form:label path="price">Price:</form:label>
						<form:input type="number" step="0.01" path="price" required="true" class="w-50"/>
					</p>
				</div>
				<form:hidden path="discount" value="false"/>
				<input type="submit" value="Submit"/>
			</div>
		</form:form>
	</div>
</body>
</html>