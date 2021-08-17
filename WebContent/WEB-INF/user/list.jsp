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
		
		location.href="insert.2jo";
	});
})
</script>

</head>
<body>

	<c:set var="list" value="${requestScope.list}"></c:set>
	
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>제목</th>
				<th>제목</th>
				<th>제목</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${list }">
				<tr>
					<td><c:out value="${item.user_no }"></c:out></td>
					<td><c:out value="${item.user_id }"></c:out></td>
					<td><c:out value="${item.user_pwd }"></c:out></td>
					<td><c:out value="${item.user_name }"></c:out></td>
					<td><c:out value="${item.user_phone }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button id="useradd">회원가입</button>
</body>
</html>