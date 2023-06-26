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
	<div class="container d-flex flex-column w-75">
		<div class="d-flex flex-row mt-4 gap-3">
			<h4>Your Gold:</h4>
			<p class="fw-bold fs-5"><c:out value="${gold}"/></p>	
		</div>
		<div class="d-flex flex-row justify-content-between mt-3">
			<div class="bg-warning p-2">
				<h5>Farm</h5>
				<p>(earns 10-20 gold)</p>
				<form action="/action" method="post" class="text-center">
					<input type="submit" value="Find Gold!" name="farm"/>
				</form>
			</div>
			<div class="bg-warning p-2">
				<h5>Cave</h5>
				<p>(earns 5-10 gold)</p>
				<form action="/action" method="post" class="text-center">
					<input type="submit" value="Find Gold!" name="cave"/>
				</form>
			</div>
			<div class="bg-warning p-2">
				<h5>House</h5>
				<p>(earns 2-5 gold)</p>
				<form action="/action" method="post" class="text-center">
					<input type="submit" value="Find Gold!" name="house"/>
				</form>
			</div>
			<div class="bg-warning p-2">
				<h5>Quest</h5>
				<p>(earns/takes 0-50 gold)</p>
				<form action="/action" method="post" class="text-center">
					<input type="submit" value="Find Gold!" name="quest"/>
				</form>
			</div>
		</div>
		<div class="d-flex flex-column mt-5">
			<h5>Activities:</h5>
			<c:forEach var="activity" items="${activities}">
				<c:if test="${activity.contains('earned')}">
					<p class="text-success"><c:out value="${activity}"></c:out></p>				
				</c:if>
				<c:if test="${activity.contains('lost')}">
					<p class="text-danger"><c:out value="${activity}"></c:out></p>				
				</c:if>
			</c:forEach>
		</div>
		<form action="/reset" class="text-center mt-5">
			<button>Restart</button>
		</form>
	</div>
</body>
</html>