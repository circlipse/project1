<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$().ready(function(){
	
	$('#notice').click(function(){
		
		location.href="noticelist.2jo";
	});
	$('#reserve').click(function(){
		
		location.href="reserveinsert.2jo";
	});
	$('#review').click(function(){
		
		location.href="reviewlist.2jo";
	});
});
</script>
</head>
<body>
  <div id="header_wrap">
	<a href="main.2jo" >
	<img src="img/h_bag.png" id="h_bag"/>
	</a>
	   <div id="nav">
		<span id="notice">공지사항</span>
		<span id="reserve">예약</span>
		<span id="review">리뷰</span>
	   </div>
	</div>
</body>
</html>