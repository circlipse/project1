<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$().ready(function(){
	
	$('#useradd').click(function(){
		
		location.href="userinsert.2jo";
	});
})
</script>

</head>
<body>
<form action="loginresult.2jo" method="post">
	<ul>
		<li>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id">
		</li>
		<li>
			<label for="pwd">패스워드</label>
			<input type="text" name="pwd" id="pwd">
		</li>
		<li>
			<input type="submit" value="로그인">
		</li>
			
	</ul>
</form>
<button id="useradd">회원가입</button>
</body>
</html>