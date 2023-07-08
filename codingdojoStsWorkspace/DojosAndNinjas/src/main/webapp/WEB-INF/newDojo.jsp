<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<h1>New Dojo</h1>		
		<div class="mt-3">
			<form:form action="/dojos/new/create" method="post" modelAttribute="dojo">
				<form:errors path="name" class="text-danger"/>
				<p>
					<form:label path="name">Name: </form:label>
					<form:input type="text" path="name"/>			
				</p>
				<input type="submit" value="Create"/>
			</form:form>
		</div>
		<p class="mt-3"><a href="/">Go back</a></p>	
	</div>
</body>
</html>