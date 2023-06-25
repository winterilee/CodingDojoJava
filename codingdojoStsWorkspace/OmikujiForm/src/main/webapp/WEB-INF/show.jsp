<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	
	<h4>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, selling <c:out value="${endeavor}"/> for a living. The next time you see a <c:out value="${thing}"/>, you will have good luck. Also <c:out value="${nice}"/>.</h4>
	
	<form action="/omikuji/return">
	<button>Go back</button>
	</form>
	
</body>
</html>