<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<h1>Burger Tracker</h1>
		<table>
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating (out of 5)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${burgerList}">
					<tr>
						<td><c:out value="${burger.name}"/></td>
						<td><c:out value="${burger.restaurantName}"/></td>
						<td><c:out value="${burger.rating}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container d-flex flex-column w-50 mt-5">
		<h3>Add a Burger:</h3>
		<form:form action="/new" method="post" modelAttribute="burger">
			<div class="d-flex flex-column">
				<form:errors path="name" class="text-danger"/>
				<p class="d-flex flex-row justify-content-between">
					<form:label path="name">Burger Name</form:label>
					<form:input path="name"/>
				</p>
			</div>
			<div class="d-flex flex-column">
				<form:errors path="restaurantName" class="text-danger"/>
				<p class="d-flex flex-row justify-content-between">
					<form:label path="restaurantName">Restaurant Name</form:label>
					<form:input path="restaurantName"/>
				</p>
			</div>
			<div class="d-flex flex-column">
				<form:errors path="rating" class="text-danger"/>
				<p class="d-flex flex-row justify-content-between">
					<form:label path="rating">Rating</form:label>
					<form:input type="number" path="rating" required="true"/>
				</p>
			</div>
			<div class="d-flex flex-column">
				<form:errors path="notes" class="text-danger"/>
				<p class="d-flex flex-row justify-content-between">
					<form:label path="notes">Notes</form:label>
					<form:input path="notes"/>
				</p>
			</div>
			<span class="d-flex flex-row-reverse">
			<input type="submit" value="Submit"/>
			</span>
		</form:form>
	</div>

</body>
</html>