<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container d-flex flex-column w-75 mt-3">
		<div class="d-flex flex-row justify-content-between align-items-center">
			<h1>Edit Expense</h1>
			<a href="/expenses">Go back</a>
		</div>
		<form:form action="/expenses/update/${expenseToEdit.id}" method="post" modelAttribute="expenseToEdit" class="mt-3">
			<input type="hidden" name="_method" value="put">
			<div class="d-flex flex-column">
				<form:errors path="name" class="text-danger"/>
				<p class="d-flex flex-row justify-content-between">
					<form:label path="name">Expense Name:</form:label>
					<form:input type="text" path="name"/>
				</p>
			</div>
			<div class="d-flex flex-column">
				<form:errors path="vendor" class="text-danger"/>
				<p class="d-flex flex-row justify-content-between">
					<form:label path="vendor">Vendor:</form:label>
					<form:input type="text" path="vendor"/>
				</p>
			</div>
			<div class="d-flex flex-column">
				<form:errors path="amount" class="text-danger"/>
				<p class="d-flex flex-row justify-content-between">
					<form:label path="amount">Amount:</form:label>
					<form:input type="number" step="0.01" path="amount" required="true"/>
				</p>
			</div>
			<div class="d-flex flex-column">
				<form:errors path="description" class="text-danger"/>
				<p class="d-flex flex-row justify-content-between">
					<form:label path="description">Description:</form:label>
					<form:textarea cols="23" rows="3" path="description"/>
				</p>
			</div>
			<p class="d-flex flex-row-reverse">
				<input type="submit" value="Submit"/>
			</p>
		</form:form>
	</div>
</body>
</html>