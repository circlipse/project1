<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reviewinsert.css">
</head>

<body>

<c:set var="id" value="${sessionScope.id }"/>	
<h2>리뷰 작성</h2>
<form method="post" action="reviewinsertresult.2jo"> 
<ul>
	<li>
	<label for="rev_title">제목</label> 
	<input type="text" id="rrev_title" name="rev_title" required>
	</li>
	
	<li>
	<label for="rev_content">작성자</label>
	<input type="text" id="rid" name="id" value="${id }" readonly>
	</li>
	
	
	<li id="con">
	<label for="rev_content">내용</label>
	<textarea id="rev_contents" name="rev_content" rows="15" cols="100" required></textarea>
	</li>
	

	<li id="rput">
	<input type="submit" id="rsubmit" value="등록">
	<input type="reset" id="rreset" value="취소">
	</li>
</ul>

</form>
</body>
</html>