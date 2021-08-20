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
	function idCheck() {
		window.open("idCheckForm.2jo", "idwin", "width=400, height=350");
	}
</script>
<link rel="stylesheet" href="css/insertform.css">
</head>
<body>
	<form name="userjoin" method="post" action="insertresult.2jo">
		<ul>
			<li><label>아이디</label> <input type="text" name="id" id="id"
				size="15" readonly> <input type="button" value="ID중복확인"
				onclick="idCheck()"></li>
			<li><label for="user_pwd">패스워드</label> <input type="text"
				name="user_pwd" id="user_pwd" required="required"></li>
			<li><label for="user_name">이름</label> <input type="text"
				name="user_name" id="user_name" required="required"></li>
			<li><label for="user_phone">전화번호</label> <input type="text"
				name="user_phone" id="user_phone" required="required"></li>

			<li><input type="submit" value="회원가입"></li>
		</ul>
	</form>

</body>
</html>