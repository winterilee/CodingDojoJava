<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<div>
		<h4>Your Gold:</h4>
		<p><c:out value="${gold}"/></p>	
	</div>
	<div>
		<div>
			<h5>Farm</h5>
			<p>(earns 10-20 gold)</p>
			<form action="/farm" method="post">
				<button>Find Gold!</button>
			</form>
		</div>
		<div>
			<h5>Cave</h5>
			<p>(earns 5-10 gold)</p>
			<form action="/cave" method="post">
				<button>Find Gold!</button>
			</form>
		</div>
		<div>
			<h5>House</h5>
			<p>(earns 2-5 gold)</p>
			<form action="/house" method="post">
				<button>Find Gold!</button>
			</form>
		</div>
		<div>
			<h5>Quest</h5>
			<p>(earns/takes 0-50 gold)</p>
			<form action="/quest" method="post">
				<button>Find Gold!</button>
			</form>
		</div>
	</div>
	<div>
		<h5>Activities:</h5>
		<p>"placeholder for activities"</p>
	</div>
	<form action="/reset">
		<button>Restart</button>
	</form>
	
</body>
</html>