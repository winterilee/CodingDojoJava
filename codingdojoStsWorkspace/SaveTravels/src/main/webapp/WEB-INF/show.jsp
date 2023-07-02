<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>Expense Details</h1>
			<a href="/expenses">Go back</a>
		</div>
		<div class="d-flex flex-column mt-3">
			<div class="d-flex flex-row justify-content-between">
				<p>Expense Name:</p>
				<p><c:out value="${expenseToShow.name}"/></p>
			</div>
			<div class="d-flex flex-row justify-content-between">
				<p>Expense Description:</p>
				<p><c:out value="${expenseToShow.description}"/></p>
			</div>
			<div class="d-flex flex-row justify-content-between">
				<p>Vendor:</p>
				<p><c:out value="${expenseToShow.vendor}"/></p>
			</div>
			<div class="d-flex flex-row justify-content-between">
				<p>Amount Spent:</p>
				<p>$<c:out value="${expenseToShow.amount}"/></p>
			</div>
		</div>
	</div>
</body>
</html>