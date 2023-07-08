<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
</head>
<body>
	
	<h1>Dojos and Ninjas</h1>
	<hr />
	<div>
		<p>Dojo | <a href="/dojos/new">Create</a></p>
		<p>Ninja | <a href="/ninjas/new">Sign up</a></p>	
	</div>
	<hr />
	<div>
		<h3>Dojo List:</h3>
		<c:forEach var="oneDojo" items="${dojoList}">
			<p><a href="/show/${oneDojo.id}"><c:out value="${oneDojo.name}"/></a></p>
		</c:forEach>
	</div>
	
</body>
</html>