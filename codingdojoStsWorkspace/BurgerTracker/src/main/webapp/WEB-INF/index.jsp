<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
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
	<div>
		<h3>Add a Burger:</h3>
		<form:form action="/new" method="post" modelAttribute="burger">
			<p>
				<form:label path="name">Burger Name</form:label>
				<form:input path="name"/>
				<form:errors path="name"/>
			</p>
			<p>
				<form:label path="restaurantName">Restaurant Name</form:label>
				<form:input path="restaurantName"/>
				<form:errors path="restaurantName"/>
			</p>
			<p>
				<form:label path="rating">Rating</form:label>
				<form:input type="number" path="rating" required="true"/>
				<form:errors path="rating"/>
			</p>
			<p>
				<form:label path="notes">Notes</form:label>
				<form:input path="notes"/>
				<form:errors path="notes"/>
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>

</body>
</html>