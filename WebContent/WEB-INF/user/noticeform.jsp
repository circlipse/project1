<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/noticeform.css">
</head>
<body>
<form method="post" action="noticeadd.2jo" encType = "multipart/form-data" >
	<ul>
		<li>
			<label for="notice_title">제목</label>
			<input type="text" name="notice_title" id="notice_title" required="required">
		</li>
		<li>
			<label for="notice_content">내용</label>
			<textarea rows="10" cols="40" name="notice_content" id="notice_content" required="required"></textarea>
		</li>
		
		<li>
			<input type="submit" value="글쓰기">
			<input type="reset" value="취소">
		</li>
	</ul>
	<div>
	<input type="file" name="fileName">
	</div>
</form>

</body>
</html>