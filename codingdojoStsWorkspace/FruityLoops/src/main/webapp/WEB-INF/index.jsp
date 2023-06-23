<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Store</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Delius&display=swap');
</style>
</head>
<body>
	<div class="container">
		<h1 class="header">Fruit Store</h1>
		<table>
			<tbody class="tbody">
				<tr class="tr">
					<th class="td">Name</th>
					<th class="td">Price</th>
				</tr>
				<c:forEach var="oneFruit" items="${fruitList}">
					<tr class="tr">
						<td class="td"><c:out value="${oneFruit.name}"></c:out></td>
						<td class="td">$<c:out value="${oneFruit.price}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>