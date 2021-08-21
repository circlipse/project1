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
<link rel="stylesheet" href="css/noticelist.css">
</head>
<body>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="currpage" value="${requestScope.currpage }"></c:set>
	<c:set var="startblock" value="${requestScope.startblock}"></c:set>
	<c:set var="endblock" value="${requestScope.endblock}"></c:set>
	<c:set var="datacount" value="${requestScope.datacount}"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage}"></c:set>
	<c:set var="id" value="${sessionScope.id}" />
	<div class="wrap">
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${list }">
				<tr>
					<td><c:out value="${item.notice_no }"></c:out></td>
					<td><a href="noticedetail.2jo?notice_no=${item.notice_no }" class="aa"><c:out value="${item.notice_title }"></c:out></a></td>
					<td><c:out value="${item.notice_readno }"></c:out></td>
					<td>관리자</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id=num>
		<c:if test="${startblock>1}">
			<a href="noticelist.2jo?curr=${currpage-1 }" class="aa">이전</a>
		</c:if>



		<c:forEach var="index" begin="${startblock }" end="${endblock }">
			<c:if test="${currpage==index }">
				<c:out value="${index }"></c:out>
			</c:if>
			<c:if test="${currpage!=index }">
				<a href="noticelist.2jo?curr=${index}" class="aa">${index}</a>
			</c:if>
		</c:forEach>



		<c:if test="${endblock<totalpage}">
			<a href="noticelist.2jo?curr=${currpage+1 }" class="aa">다음</a>
		</c:if>
	</div>
	
	
	
	
	<c:if test="${id eq 'admin' }">
	<button id="noticeadd">글쓰기</button>
	</c:if>

	
	
	
	
</body>
</html>