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
	<link href="<spring:url value='/resources/css/main.css'/>" type="text/css" rel="stylesheet">
	<link href="<spring:url value='/resources/css/cust_register.css'/>" type="text/css" rel="stylesheet">
	<link href="<spring:url value='/resources/css/jquery.countdownTimer.css'/>" type="text/css" rel="stylesheet">
	
	<title>Deal-With-It</title>
</head>
<body>

<!--  INSERT YOUR CODE HERE -->
This is a sample page.
<div id="countdowntimer" align="center">
	<img src="<spring:url value='/resources/img/placeholder.jpg'/>" alt="sample_bid_item" />
	<br/>
	<span id="hms_timer"></span>
</div>

</body>
<script src="<spring:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<script src="<spring:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<spring:url value='/resources/js/script.js'/>"></script>
<script src="<spring:url value='/resources/js/jquery.countdownTimer.min.js'/>"></script>
<script>
$(function(){
	$('#hms_timer').countdowntimer({
        hours : 3,
        minutes :10,
        seconds : 21,
        size : "lg"
    });
});
</script>
</html>
