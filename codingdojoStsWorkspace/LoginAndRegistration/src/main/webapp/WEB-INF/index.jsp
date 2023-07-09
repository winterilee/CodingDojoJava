<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container d-flex flex-column mt-3">
		<div>
			<h1>Welcome!</h1>
			<h4>Join our growing community.</h4>	
		</div>
		<div class="d-flex flex-row mt-3 justify-content-between">
			<div class="d-flex flex-column">
				<h3>Register</h3>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<div>
						<form:errors path="username" class="text-danger"/>
						<p class="d-flex flex-row justify-content-between align-items-center">
							<form:label path="username">Username:</form:label>
							<form:input type="text" path="username"/>
						</p>
					</div>
					<div>
						<form:errors path="email" class="text-danger"/>
						<p class="d-flex flex-row justify-content-between align-items-center">
							<form:label path="email">Email:</form:label>
							<form:input type="email" path="email"/>
						</p>
					</div>
					<div>
						<form:errors path="password" class="text-danger"/>
						<p class="d-flex flex-row justify-content-between align-items-center">
							<form:label path="password">Password:</form:label>
							<form:input type="password" path="password"/>
						</p>
					</div>
					<div>
						<form:errors path="confirm" class="text-danger"/>
						<p class="d-flex flex-row justify-content-between align-items-center">
							<form:label path="confirm">Confirm Password:</form:label>
							<form:input type="password" path="confirm"/>
						</p>
					</div>
					<input type="submit" value="Register"/>
				</form:form>
			</div>
			<div class="d-flex flex-column">
				<h3>Login</h3>
				<form:form action="/login" method="post" modelAttribute="loginUser">
					<div>
						<form:errors path="email" class="text-danger"/>
						<p class="d-flex flex-row justify-content-between align-items-center">
							<form:label path="email">Email:</form:label>
							<form:input type="email" path="email"/>
						</p>
					</div>
					<div>
						<form:errors path="password" class="text-danger"/>
						<p class="d-flex flex-row justify-content-between align-items-center">
							<form:label path="password">Password:</form:label>
							<form:input type="password" path="password"/>
						</p>
					</div>
					<input type="submit" value="Login"/>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>