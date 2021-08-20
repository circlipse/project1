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
	<c:set var="id" value="${requestScope.id}"></c:set>

<c:choose>

	<c:when test="${result==0}">
		<c:out value="사용 가능한 아이디입니다."></c:out>
		<!-- <a href='javascript:apply(\"" + id + "\")'>[적용]</a> -->
		
		<input type="button" value="적용" onclick="idInput()">
	<script>
		function idInput(id) {
			opener
			opener.document.userjoin.id.value = "${id}";
			window.close();
		}
	</script>
	</c:when>
	<c:otherwise>
		<p style='color: red'>해당 아이디는 사용 중 입니다.</p>
	</c:otherwise>
	
</c:choose>

	
</body>
</html>