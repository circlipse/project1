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

<c:set var="rev_no" value="${requestScope.rev_no}"></c:set>
<c:set var="id" value="${sessionScope.id}"></c:set>
	
	
	<c:choose>

		<c:when test="${id ==null}">
			<script>
		alert('로그인이 필요합니다.');
		location.href = "reviewdetail.2jo?rev_no="+${rev_no};
	</script>
		</c:when>

		<c:otherwise>
			<script>
		alert('작성자가 아닙니다.');
		location.href = "reviewdetail.2jo?rev_no="+${rev_no};
	</script>
		</c:otherwise>


	</c:choose>
	
	
	
	
</body>
</html>