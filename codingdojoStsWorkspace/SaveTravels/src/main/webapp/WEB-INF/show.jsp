<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Expense</title>
</head>
<body>
	<div>
		<div>
			<h1>Expense Details</h1>
			<a href="/expenses">Go back</a>
		</div>
		<div>
			<div>
				<p>Expense Name:</p>
				<p><c:out value="${expenseToShow.name}"/></p>
			</div>
			<div>
				<p>Expense Description:</p>
				<p><c:out value="${expenseToShow.description}"/></p>
			</div>
			<div>
				<p>Vendor:</p>
				<p><c:out value="${expenseToShow.vendor}"/></p>
			</div>
			<div>
				<p>Amount Spent:</p>
				<p>$<c:out value="${expenseToShow.amount}"/></p>
			</div>
		</div>
	</div>
</body>
</html>