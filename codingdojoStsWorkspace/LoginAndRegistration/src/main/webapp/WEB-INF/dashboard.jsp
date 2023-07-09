<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<h1>Welcome, <c:out value="${currentUser.username}"/>!</h1>
		<hr />
		<h3>This is your dashboard. Nothing to see here yet.</h3>
		<p class="mt-3"><a href="/logout">logout</a></p>
	</div>
</body>
</html>