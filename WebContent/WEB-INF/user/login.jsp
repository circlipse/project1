<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!--  <script>
$().ready(function(){
	
	$('#useradd').click(function(){
		
		location.href="insert.2jo";
	});
})
</script>
-->

</head>
<body>
<c:set var="referer" value="${requestScope.referer }"/>

<form action="loginresult.2jo" method="post">
<img src="img/jeju.jpg" id="jeju"/>
	<ul id="ip">
		<li>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id">
		</li>
		<li>
			<label for="pwd">패스워드</label>
			<input type="password" name="pwd" id="pwd">
		</li>

		<li id="login">
			<input type="submit" id="login" value="로그인">
		
		</li>
		
		<li id="userinsert">
		아직 회원이 아니십니까?
		<a href="userinsert.2jo">회원가입</a>
		</li>
	</ul>

<input type="hidden" name="referer" value="${referer}">
</form>
		<div class="info">
			<img src="img/info.jpg" id="infoimg" />
		</div>
</body>
</html>