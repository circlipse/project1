<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/usermodi.css">
</head>
<body>
<c:set var="id" value="${sessionScope.id}"></c:set>


<h2>회원 정보 수정</h2>
<form method="post" action="usermodiresult.2jo">
	<ul>
	
		<li>
			<label for="user_id">아이디</label>
			<input type="text" name="user_id" id="user_id" value="${id }" readonly="readonly">
		</li>
		
		<li>
			<label for="user_pwd">패스워드</label>
			<input type="text" name="user_pwd" id="user_pwd" required="required">
		</li>
		
		<li>
			<label for="user_name">이름</label>
			<input type="text" name="user_name" id="user_name" required="required">
		</li>
		
		<li>
			<label for="user_phone">전화번호</label>
			<input type="text" name="user_phone" id="user_phone" required="required">
		</li>
		
		<li>
			<input type="submit" id="submit" value="수정">
			<input type="reset" id="cancel" value="취소">
		</li>
		
	</ul>
</form>
</body>
</html>