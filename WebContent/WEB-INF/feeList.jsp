<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/feelist.css">
</head>
<body>
<c:set var="id" value="${sessionScope.id }"></c:set>
<form>
<div>
<img src="img/feelist.png" id="feelist"/>
</div>

<div>
<img src="img/warning.png" id="warning"/>
</div>
<input type="hidden" name="id" value="${id}">
</form>
</body>
</html>