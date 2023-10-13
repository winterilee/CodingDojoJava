<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>Welcome, <c:out value="${currentUser.firstName}"/>!</h1>
			<a href="/logout">logout</a>		
		</div>
		<hr />
		<div>
			<h3>All games:</h3>
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Price</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneGame" items="${allGames}">
						<tr>
							<td><a href="/games/show/${oneGame.id}"><c:out value="${oneGame.title}"/></a></td>
							<td>$<c:out value="${oneGame.price}"/></td>
							<c:choose>
								<c:when test="${oneGame.discount==true}">
									<td class="text-danger">On Sale</td>
								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h3>Games less than $10:</h3>
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Price</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneGame" items="${gamesLessThan10}">
						<tr>
							<td><a href="/games/show/${oneGame.id}"><c:out value="${oneGame.title}"/></a></td>
							<td>$<c:out value="${oneGame.price}"/></td>
							<c:choose>
								<c:when test="${oneGame.discount==true}">
									<td class="text-danger">On Sale</td>
								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h3>Games less than $20:</h3>
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Price</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneGame" items="${gamesLessThan20}">
						<tr>
							<td><a href="/games/show/${oneGame.id}"><c:out value="${oneGame.title}"/></a></td>
							<td>$<c:out value="${oneGame.price}"/></td>
							<c:choose>
								<c:when test="${oneGame.discount==true}">
									<td class="text-danger">On Sale</td>
								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h3>Games less than $30:</h3>
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Price</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneGame" items="${gamesLessThan30}">
						<tr>
							<td><a href="/games/show/${oneGame.id}"><c:out value="${oneGame.title}"/></a></td>
							<td>$<c:out value="${oneGame.price}"/></td>
							<c:choose>
								<c:when test="${oneGame.discount==true}">
									<td class="text-danger">On Sale</td>
								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container d-flex justify-content-end mt-3">
			<form action="/games/new">
				<button type="submit">Add a game to the list</button>
			</form>
		</div>
	</div>
</body>
</html>