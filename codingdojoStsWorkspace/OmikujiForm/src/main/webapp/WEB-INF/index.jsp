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
	<h1 class="text-center mt-3">Send an Omikuji!</h1>
	
	<p class="text-center text-danger"><c:out value="${error}"/></p>
	
	<form action="/omikuji/show" method="post" class="container d-flex flex-column w-75">
		<label>Pick any number from 5 to 25:</label>
		<input type="number" name="number" />
		<label>Enter the name of any city:</label>
		<input type="text" name="city" />
		<label>Enter the name of any real person:</label>
		<input type="text" name="person" />
		<label>Enter professional endeavor or hobby:</label>
		<input type="text" name="endeavor" />
		<label>Enter any type of living thing:</label>
		<input type="text" name="thing" />
		<label>Say something nice to someone:</label>
		<textarea name="nice"cols="20" rows="5"></textarea>
		<p class="mt-3 text-center">Send and show a friend</p>
		<input type="submit" value="Send" />
	</form>
	
</body>
</html>