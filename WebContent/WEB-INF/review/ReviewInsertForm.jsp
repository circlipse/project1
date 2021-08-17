<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<form method="post" action="reviewinsertresult.2jo"> 
<ul>
	<li>
	<label for="rev_title">제목</label> 
	<input type="text" id="rev_title" name="rev_title" required>
	</li>
	
	<li>
	<label for="rev_content">내용</label>
	<textarea id="rev_content" name="rev_content" required></textarea>
	</li>

	
	<li>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
	</li>
</ul>

</form>
</body>
</html>