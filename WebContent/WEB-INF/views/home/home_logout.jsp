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
	<link href="<spring:url value='/resources/css/main.css'/>" type="text/css" rel="stylesheet">
	
	<title>Deal-With-It</title>
</head>
<body class="bodyBgImage">
<a name="top"></a>
<header class="headerBgImage navbar-fixed-top">
  <div class="container">
    <a  style="text-decoration: none; cursor: default;" href="/logout"><img src="<spring:url value='/resources/img/Logo_Plain.png'/>" alt="Icon"></a>
    <br>
  </div>
  <div class="headerLinks">
	    <a  href="login">Login | </a>
	    <a  href="register">Register | </a>
	    <a  href="contact">Contact Us | </a>
  </div>
</header>

<div class="services container">
<c:forEach items="${bid_list}" var="item">
    <div class="row">
    <section class="col xs-12 col-sm-6 col-md-3 col-lg-2 gridCell">
      <a href="#"><img class="icon" src="<spring:url value='/resources/img/placeholder.jpg'/>" alt="Icon">
      </a>
      <h3></h3>
      <h2>₹ 999</h2>
      <span id="hms_timer" class="timer"></span>
      <p>Generic placeholder text, bla bla bla bla bla bla bla bla bla bla bla</p>
      <button type="button" class="btn btn-primary buyButton">Buy Now</button>
      <br>
    </section>
  </div><!-- row -->
  </c:forEach>   
</div><!-- content container -->


<footer class="footer navbar-fixed-bottom">
	<div class="backToTop">
		<a  href="#top">Top</a><br>
	</div>
	
	
	<a 	href="">Contact Us</a>
	<label>© 2017-2018, DealWithIt.com Inc</label>
</footer>

<script src="<spring:url value='/resources/js/jquery-2.1.4.min.js'/>"></script>
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
</body>
</html>

