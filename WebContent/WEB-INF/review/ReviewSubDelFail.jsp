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
	<script>
		alert('작성자가 아닙니다.');
		location.href = "reviewdetail.2jo?rev_no="+${rev_no};
	</script>
</body>
</html>