<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무빙백</title>
<link rel="stylesheet" href="css/main.css">
<link rel="icon" href="img/h_bag.png">

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
	
</div>
	<div id="push">
	</div>
	<footer id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>

</body>
</html>