<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="<spring:url value='/resources/bootstrap/css/bootstrap.css'/>" type="text/css" rel="stylesheet" />
	<link href="<spring:url value='/resources/css/jquery.countdownTimer.css'/>" type="text/css" rel="stylesheet">
	<link href="<spring:url value='/resources/css/main.css?ver=2.2'/>" type="text/css" rel="stylesheet">
	
	<title>Deal-With-It</title>
</head>
<body class="bodyBgImage">
<%-- <header class="headerBgImage navbar-fixed-top">
  <div class="container">
    <a rev="12.89" style="text-decoration: none; cursor: default;" href="/logout"><img src="<spring:url value='/resources/img/siteName.png'/>" alt="Icon"></a>
    <br>
    <div class="headerLinks">
	    <a href="login">Customer Login | </a>
	    <a href="list">Customer List | </a>
	    <a href="register">Register | </a>
	    <a href="dashboard">Dashboard | </a>
    </div>
  </div>
</header> --%>

<div class="services container">
    <div class="row">
    <form:form modelAttribute="bid" method="post">
		<table>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td>Enter Product Id</td>
				<td><form:input path="productId" /></td>
				<td><form:errors path="productId" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Customer Id</td>
				<td><form:input path="customerId" /></td>
				<td><form:errors path="customerId" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Start Time in dd-mm-yyyy</td>
				<td><form:input path="timerStart" /></td>
				<td><form:errors path="timerStart" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter End Time in dd-mm-yyyy</td>
				<td><form:input path="timerEnd" /></td>
				<td><form:errors path="timerEnd" cssClass="error"/></td>
			</tr>
			
			
			<tr>
				<td>Enter Base Amount</td>
				<td><form:input path="finalBidAmount" /></td>
				<td><form:errors path="finalBidAmount" cssClass="error"/></td>
			</tr>
			
			
			<tr>
				<td><input type="submit" value="Register Me" /></td>

			</tr>

		</table>
	</form:form>  
  </div><!-- row -->   
</div><!-- content container -->

<footer class="footer navbar-fixed-bottom">
  <a class="headerLinks" href="login">Customer Login </a><br>
  <a class="headerLinks" href="list">Customer List </a><br>
  <a class="headerLinks" href="register">Register </a><br>
  <a class="headerLinks" href="dashboard">Bids Page </a><br>
</footer>
<script src="<spring:url value='/resources/js/jquery-2.1.4.min.js'/>"></script>
<script src="<spring:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<spring:url value='/resources/js/script.js'/>"></script>
<script src="<spring:url value='/resources/js/jquery.countdownTimer.min.js'/>"></script>
</body>
</html>
</html>
