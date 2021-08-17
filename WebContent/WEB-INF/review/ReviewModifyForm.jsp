<%@page import="dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<c:set var="dto" value="${requestScope.dto }"/>	

<form method="post" action="reviewmodifyresult.2jo">

	<label for="rev_no">번호</label>
	<input type="text" name="rev_no" id="rev_no" value=<c:out value="${dto.rev_no }"></c:out>>
	<br>
	<label for="rev_title">제목</label>
	<input type="text" name="rev_title" id="rev_title" value=<c:out value="${dto.rev_title }"></c:out>>
	<br>
	<label for="rev_content">내용</label>
	<input type="text" name="rev_content" id="rev_content" value=<c:out value="${dto.rev_content }"></c:out>>
	<br>

	<input type="submit" value="수정 완료">
	<input type="reset" value="취소">

</form>
</body>
</html>