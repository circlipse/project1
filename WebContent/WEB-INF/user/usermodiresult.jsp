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


	<c:choose>

		<c:when test="${result >=0}">
			<script>
				alert('수정완료');
				location.href = "userdetail.2jo";
			</script>
		</c:when>

		<c:otherwise>
			<script>
				alert('수정실패');
				location.href = "userdetail.2jo";
			</script>
		</c:otherwise>


	</c:choose>

</body>
</html>