<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deal-With-It</title>
<link href="<spring:url value='/resources/css/main.css'/>" type="text/css"
	rel="stylesheet"/>
<link href="<spring:url value='/resources/bootstrap/css/bootstrap.css'/>" type="text/css" 
	rel="stylesheet" />
</head>
<body>
<h3> ${requestScope.status}</h3>
	<form:form modelAttribute="customer" method="post">
		<table>

			<tr>
				<td>Enter Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>

			</tr>

		</table>
	</form:form>
</body>
<!-- jQuery 1.9 -->
<%--Bootstrap JS --%>
<script src="<spring:url value='/resources/js/jquery.1.9.1.min.js'/>"></script>
<script src="<spring:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
</html>