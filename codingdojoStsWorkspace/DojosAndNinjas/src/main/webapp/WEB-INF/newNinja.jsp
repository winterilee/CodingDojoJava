<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>

	<h1>New Ninja</h1>

	<div>
		<form:form action="/ninjas/new/create" method="post" modelAttribute="ninja">
			<div>
				<form:errors path="firstName"/>
				<p>
					<form:label path="firstName">First Name: </form:label>
					<form:input type="text" path="firstName"/>
				</p>			
			</div>
			<div>
				<form:errors path="lastName"/>
				<p>
					<form:label path="lastName">Last Name: </form:label>
					<form:input type="text" path="lastName"/>
				</p>			
			</div>
			<div>
				<form:errors path="age"/>
				<p>
					<form:label path="age">Age: </form:label>
					<form:input type="number" path="age" step="1" required="true"/>
				</p>			
			</div>
			<div>
				<form:select path="dojo">
					<c:forEach var="oneDojo" items="${dojoList}">
						<option value="${oneDojo.id}">${oneDojo.name}</option>
					</c:forEach>
				</form:select>
			</div>
			<input type="submit" value="Sign up"/>
		</form:form>
	</div>

	<p><a href="/">Go back</a></p>
	
</body>
</html>