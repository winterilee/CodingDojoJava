<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
	<h1>Send and Omikuji!</h1>
	
	<form action="/omikuji" method="post">
		<label>Pick any number from 5 to 25</label>
		<input type="number" name="number" />
		<label>Enter the name of any city</label>
		<input type="text" name="city" />
		<label>Enter professional endeavor or hobby</label>
		<input type="text" name="endeavor" />
		<label>Enter any type of living thing</label>
		<input type="text" name="thing" />
		<label>Say something nice to someone:</label>
		<textarea name="nice"cols="10" rows="3"></textarea>
		<p>Send and show a friend</p>
		<input type="submit" value="Send" />
	</form>
	
</body>
</html>