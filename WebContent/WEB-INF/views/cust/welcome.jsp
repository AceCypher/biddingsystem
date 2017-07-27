<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Number List : ${requestScope.num_list}
	<br /> Server Date : ${requestScope.srvr_dt}
	<br /> Integer List : ${requestScope.integerList}
	<br /> Customer Info : ${requestScope.customer}
	<br /> Emp Info ${requestScope.emp_info}
	<br /> Joined on
	<fmt:formatDate value="${requestScope.join_date}" pattern="dd/MM/yyyy" />
</body>
</html>