<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
</head>
<body>
	<div>
		<h1>Save Travels</h1>
		<table>
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenseList}">
					<tr>
						<td><a href="/expenses/show/${expense.id}"><c:out value="${expense.name}"/></a></td>
						<td><c:out value="${expense.vendor}"/></td>
						<td>$<c:out value="${expense.amount}"/></td>
						<td>
							<a href="/expenses/edit/${expense.id}">edit</a>
							<form action="/expenses/delete/${expense.id}" method="post">
								<input type="hidden" name="_method" value="delete">
    							<input type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<h2>Add an expense:</h2>
		<form:form action="/expenses/new" method="post" modelAttribute="expense">
			<div>
				<form:errors path="name"/>
				<p>
					<form:label path="name">Expense Name:</form:label>
					<form:input type="text" path="name"/>
				</p>
			</div>
			<div>
				<form:errors path="vendor"/>
				<p>
					<form:label path="vendor">Vendor:</form:label>
					<form:input type="text" path="vendor"/>
				</p>
			</div>
			<div>
				<form:errors path="amount"/>
				<p>
					<form:label path="amount">Amount:</form:label>
					<form:input type="number" step="0.01" path="amount" required="true"/>
				</p>
			</div>
			<div>
				<form:errors path="description"/>
				<p>
					<form:label path="description">Description:</form:label>
					<form:textarea rows="3" path="description"/>
				</p>
			</div>
			<p>
				<input type="submit" value="Submit"/>
			</p>
		</form:form>
	</div>
</body>
</html>