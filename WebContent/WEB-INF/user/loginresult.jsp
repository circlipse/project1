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
	
	$('#userdetail').click(function(){
		
		location.href="userdetail.2jo";
	});
})
</script>
</head>
<body>
	<c:set var="id" value="${sessionScope.id}"/>
	
	<table >
		<tr><td><c:out value="${sessionScope.id}" /></td><td>님 반갑습니다.</td> </tr>
	</table>
		
	<button id="userdetail">마이페이지</button>
</body>
</html>