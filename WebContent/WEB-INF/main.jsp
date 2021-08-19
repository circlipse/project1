<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">

</head>
<body>
<div id="main">
	<header id="header">
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<section id="section">
		<c:set var="contentpage" value="${param.page }"></c:set>
		<jsp:include page="${contentpage }"></jsp:include>
	</section>
	
	<footer id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>