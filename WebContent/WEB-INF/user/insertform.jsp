<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/insertform.css">
</head>
<body>
<c:set var="useid" value="${requestScope.useid}"></c:set> 
	<c:set var="inputid" value="${requestScope.inputid}"></c:set> 
<form method="post" action="insertresult.2jo" onsubmit="return checkSubmit(${inputid},${useid });">
	<ul>
		<li><label for="id">아이디</label> <c:choose>
					<c:when test="${useid == 1 }">
						<span>사용중인 아이디 입니다.</span>
						<br>
						<input type="text" id="id" name="id" required="required">
					</c:when>
					<c:when test="${useid == 0 }">
						<span> 사용가능한 아이디 입니다.</span>
						<br>
						<input type="text" id="id" name="id" value="${inputid }"
							required="required">
					</c:when>
					<c:otherwise>
						<br>
						<input type="text" id="id" name="id" value="${inputid }"
							required="required">
					</c:otherwise>
				</c:choose> <input type="button" value="중복확인" id="overlap"></li>
		<li>
			<label for="user_pwd">패스워드</label>
			<input type="password" name="user_pwd" id="user_pwd" required="required">
		</li>
		<li>
			<label for="user_name">이름</label>
			<input type="text" name="user_name" id="user_name" required="required">
		</li>
		<li>
			<label for="user_phone">전화번호</label>
			<input type="text" name="user_phone" id="user_phone" required="required">
		</li>
		
		
		<li id="insert">
			<input type="submit" id="insert" value="회원가입">
		</li>
	</ul>
</form>
</body>
</html>