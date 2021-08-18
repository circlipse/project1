<%@page import="dto.NoticeDTO"%>
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
<%
NoticeDTO dto= (NoticeDTO) request.getAttribute("dto");
%>
	<c:set var="dto" value="${requestScope.dto}"/>


<form method="post" action="noticemodifyresult.2jo">
	<ul>
		
	
	<li>
		<label for="notice_title">제목</label> 
		<input type="text" name="notice_title" id="notice_title" value="${dto.notice_title }"><br> 
	</li>	
	<li>
		<label for="notice_content">내용</label> 
		<textarea rows="3" cols="20" name="notice_content" id="notice_content">${dto.notice_content }</textarea><br> 
	</li>
	</ul>		
		
		<input type="hidden" name="notice_no" value="${dto.notice_no }">	
		<input type="submit" value="수정"> <input type="reset" value="취소">
	</form>

</body>
</html>