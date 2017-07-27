<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<spring:url value='/css/main.css'/>" type="text/css"
	rel="stylesheet">
</head>
<body>
	<h3>Last Action Status : ${requestScope.status}</h3>
	<h3 align="center">Customer List</h3>
	<table>
		<c:forEach var="cust" items="${requestScope.cust_list}">
			<tr>
			<td>${cust.name}</td>
				<td>${cust.email}</td>
				<%-- <td><fmt:formatDate value="${cust.regDate}"
						pattern="dd-MM-yyyy" /></td> --%>
						<td><a href="<spring:url value='update?id=${cust.id}'/>">Update Customer</a></td>
						<td><a href="<spring:url value='delete/${cust.id}'/>">Un-subscribe Customer</a></td>
						<td><a href="<spring:url value='temp/${cust.id}'/>">Template Access</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3 align="center">
		<a href="register">Add Customer</a>
	</h3>

</body>