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
	
	$('#userdel').click(function(){
		
		location.href="userdel.2jo";
	});
	$('#usermodi').click(function(){
		
		location.href="usermodi.2jo";
	});$('#resevedetail').click(function(){
		
		location.href="reservelist.2jo";
	});
})
</script>
</head>
<body>
	<c:set var="dto" value="${requestScope.dto}"/>
	<table >
		<tr><td>아이디</td> <td><c:out value="${dto.user_id }" /></td></tr>
		<tr><td>이름</td> <td><c:out value="${dto.user_name }" /></td></tr>
		<tr><td>전화번호</td> <td><c:out value="${dto.user_phone }" /></td></tr>
	</table>
	
<button id="userdel">탈퇴</button>
<button id="usermodi">정보수정</button>
<button id="resevedetail">예약현황</button>
	
</body>
</html>