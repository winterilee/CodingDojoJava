<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class="text-center mt-3">Here's Your Omikuji!</h1>
	
	<h5 class="container w-50 mt-5 bg-warning p-5">In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, selling <c:out value="${endeavor}"/> for a living. The next time you see a <c:out value="${thing}"/>, you will have good luck. Also, <c:out value="${nice}"/></h5>
	
	<form action="/omikuji/return" class="text-center mt-5">
	<button>Go back</button>
	</form>
	
</body>
</html>