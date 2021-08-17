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
<div id="wrap">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<section>
		<c:set var="contentpage" value="${param.page }"></c:set>
		<jsp:include page="${contentpage }"></jsp:include>
	</section>
	<footer>
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>