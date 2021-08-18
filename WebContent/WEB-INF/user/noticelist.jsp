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
	$().ready(function() {

		$('#noticeadd').click(function() {

			location.href = "noticeaddform.2jo";
		});
	})
</script>
</head>
<body>
<c:set var="list" value="${requestScope.list}"></c:set>
	
	<table>
		<thead>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${list }">
				<tr>
					<td><c:out value="${item.notice_no }"></c:out></td>
					<td><c:out value="${item.notice_title }"></c:out></td>
					<td><c:out value="${item.notice_readno }"></c:out></td>
					<td>관리자</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button id="noticeadd">글쓰기</button>
</body>
</html>