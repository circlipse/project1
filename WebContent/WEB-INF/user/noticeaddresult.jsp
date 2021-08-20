<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="result" value="${requestScope.result}"></c:set>
<c:set var="Notice_img" value="${requestScope.Notice_img}"></c:set>
<c:out value="${Notice_img}"></c:out>

	<c:choose>

		<c:when test="${result >=0}">
			<script>
				alert('등록완료');
				location.href = "noticelist.2jo?fullpath=<c:out value='${Notice_img}'/>";
			</script>
			
		</c:when>

		<c:otherwise>
			<script>
				alert('등록실패');
				location.href = "noticeaddform.2jo";
			</script>
		</c:otherwise>


	</c:choose>


</body>
</html>