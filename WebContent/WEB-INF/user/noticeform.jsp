<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="noticeadd.2jo">
	<ul>
		<li>
			<label for="notice_title">제목</label>
			<input type="text" name="notice_title" id="notice_title" required="required">
		</li>
		<li>
			<label for="notice_content">내용</label>
			<textarea rows="3" cols="20" name="notice_content" id="notice_content" required="required"></textarea>
		</li>
		
		<li>
			<input type="submit" value="글쓰기">
			<input type="reset" value="취소">
		</li>
	</ul>
</form>

</body>
</html>