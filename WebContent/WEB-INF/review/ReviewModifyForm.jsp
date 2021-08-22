<%@page import="dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reviewmodify.css">
</head>
<body>
 

<c:set var="dto" value="${requestScope.dto }"/>	

<h2>리뷰 수정</h2>
<form method="post" action="reviewmodifyresult.2jo">

<ul>
	<li>
	<label for="rev_no">번호</label>
	<input type="text" name="rev_no" id="rev_no" value=<c:out value="${dto.rev_no }"></c:out> readonly>
	</li> 
	
	<li>
	<label for="rev_title">제목</label>
	<input type="text" name="rev_title" id="rev_title" value=<c:out value="${dto.rev_title }"></c:out>>
	</li>
	
	<li id="con">
	<label for="rev_content">내용</label>
	<textarea name="rev_content" id="rev_content" rows="15" cols="100"><c:out value="${dto.rev_content }"></c:out></textarea>
	</li>
	
	<li id="rbtn">
	<input type="submit" id="rrsubmit" value="수정 완료">
	<input type="reset" id="rrreset" value="취소">
	</li>
	
	
</ul>
</form>
</body>
</html>