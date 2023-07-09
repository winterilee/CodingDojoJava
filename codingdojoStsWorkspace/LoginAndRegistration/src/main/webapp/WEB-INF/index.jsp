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
</head>
<body>
	<div>
		<h1>Welcome!</h1>
		<h4>Join our growing community.</h4>	
	</div>
	<div>
		<h3>Register</h3>
		<form:form action="/register" method="post" modelAttribute="newUser">
			<div>
				<form:errors path="username"/>
				<p>
					<form:label path="username">Username:</form:label>
					<form:input type="text" path="username"/>
				</p>
			</div>
			<div>
				<form:errors path="email"/>
				<p>
					<form:label path="email">Email:</form:label>
					<form:input type="email" path="email"/>
				</p>
			</div>
			<div>
				<form:errors path="password"/>
				<p>
					<form:label path="password">Password:</form:label>
					<form:input type="password" path="password"/>
				</p>
			</div>
			<div>
				<form:errors path="confirm"/>
				<p>
					<form:label path="confirm">Confirm Password:</form:label>
					<form:input type="password" path="confirm"/>
				</p>
			</div>
			<input type="submit" value="Register"/>
		</form:form>
	</div>
</body>
</html>