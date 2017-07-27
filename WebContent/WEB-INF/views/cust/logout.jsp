<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh"
	content="5;url=${pageContext.request.contextPath}">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">Status : ${requestScope.status123}</h3>
	<h4 align="center">Logged out successfully, will be taken to home
		page shortly</h4>

</body>