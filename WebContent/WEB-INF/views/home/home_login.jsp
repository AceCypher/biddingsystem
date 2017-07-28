<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<c:choose>
    <c:when test="${bid_list == null || bid_list.size() == 0}">
        <div id="post-alert" class="alert alert-warning" role="alert">
            <spring:message text="Error Showing bids."/>
        </div>
    </c:when>
</c:choose>
<div class="services container">
   <c:forEach items="${bid_list}" var="item">
   		<c:set var="keyString">${item.id}</c:set>
    		<div class="row">
		    <section class="col xs-12 col-sm-6 col-md-3 col-lg-2 gridCell">
		      <h2>${prod_list[keyString].productName}</h2>
		      <a href="#"><img class="icon" src="<spring:url value='/resources/img/${prod_list[keyString].productImageUrl}'/>" alt="Icon">
		      </a>
		      <h3 id="bid_amt_${keyString}">₹ ${item.finalBidAmount}</h3>
		      <!-- productBaseAmount -->
		      <input type="hidden" name="product" value="${keyString}" />
		      <input type="hidden" id="time_${keyString}" name="time_${keyString}" value="${prod_time[keyString]}" />
		      <input type="hidden" name="bid_start" value="${item.timerStart}" />
		      <input type="hidden" name="bid_end" value="${item.timerEnd}" />
		      <span id="${keyString}" mdd="timer_${keyString}" class="timer"></span><br/>
		      <h3>${prod_list[keyString].productDesc}</h3>
		      <button type="button" id="btn_${keyString}" class="btn btn-primary buyButton bidButton">Bid Now by ₹ 100</button>		      
		      <br/>
		    </section>
		</div>
     </c:forEach> 
     <!-- <span style="display:none" id="xx" class="timer"></span>
     <span style="display:none" id="xy" class="timer"></span>
     <span style="display:none" id="yx" class="timer"></span> -->
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
	$('.timer').each(function(i, obj) {
    		
    		var prodId = $(this).attr('id');
    		var timeString = $("#time_"+prodId).val();
    		var curTime = timeString.split('-');
    		
    		var x = $('#'+prodId).countdowntimer({
    	        hours :00,//curTime[0],
    	        minutes :00,//curTime[1],
    	        seconds :curTime[2],
    	        size : "md"
    	    });
    		
    		console.log(" Product Id " + prodId +" CurrTime Arr " + curTime.toSource() + " TimeString " + timeString +" timer "+x.toSource());
	});
	$("button.bidButton").on("click", function(){
		var bidId = $(this).attr('id').split('_')[1];
		var saveData = $.ajax({
		      type: 'POST',
		      url: "${pageContext.servletContext.contextPath}/home/check",
		      data: {'bidId' : bidId},
		      dataType: "text",
		      success: function(resultData) { 
		    	  				/* alert(resultData.toSource()); */
		    	  				if(resultData.length > 0){
		    	  					$("#bid_amt_"+bidId).html(resultData);
		    	  					alert("Bidding Successful!");
		    	  				}
		    	  				else{
		    	  					alert("Bidding failed. Server timeout!");
		    	  					$("#"+bidId+".colorDefinition").removeAttr("id").html("--Bid Ended--");
		    	  					$("#btn_"+bidId).attr('disable', 'disable').addClass('disabled').unbind( "click" );
		    	  					$(this).html("--Bid Ended--");
		    	  					console.log(bidId+ " bidding failed! ");
		    	  				}
  	  				}
		});
	});
	
});


window.setInterval(function(){
	$('.colorDefinition').each(function(i, obj) {
		var bidId = $(this).attr('id');
		if($(this).text()=='00:00:00'){
			var bidId = $(this).attr('id');
			console.log($(this).attr('id') + " Ended!");
			$("#btn_"+$(this).attr('id')).attr('disable', 'disable').addClass('disabled').unbind( "click" );
			$(this).html("--Bid Ended--");
		}
		var saveData = $.ajax({
		      type: 'POST',
		      url: "${pageContext.servletContext.contextPath}/home/updatePrice",
		      data: {'bidId' : bidId},
		      dataType: "text",
		      success: function(resultData) { 
		    	  				if(resultData.length > 0){
		    	  					$("#bid_amt_"+bidId).html(resultData);
		    	  				}
	  				}
		});
	});
}, 1000);


</script>
</body>
</html>