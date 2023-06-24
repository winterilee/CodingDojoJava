<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>

<h3>You have visited <a href="http://localhost:8080/">http://localhost:8080/</a> <c:out value="${count}"></c:out> times.</h3>
<h3><a href="http://localhost:8080/">Test another visit?</a></h3>

<form action="/increment" method="post">
	<button>Increment 2</button>
</form>
<br />
<form action="/clear" method="post">
	<button>Clear Session</button>
</form>

</body>
</html>