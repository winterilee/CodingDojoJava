<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Store</title>
</head>
<body>
	<div>
		<h1>Fruit Store</h1>
		<table>
			<tbody>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
				<c:forEach var="oneFruit" items="${fruitList}">
					<tr>
						<td><c:out value="${oneFruit.name}"></c:out></td>
						<td><c:out value="${oneFruit.price}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>