<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>


<body>
	<c:set var="dto" value="${requestScope.dto }"/>
	
<!-- 	<table class="table table-striped"> -->
<table>
	<tr>
		<td>번호</td><td><c:out value="${dto.rev_no }"></c:out></td>
	</tr>
	<tr>
		<td>제목</td><td><c:out value="${dto.rev_title }"></c:out></td>
	</tr>
	<tr>
		<td>내용</td><td><c:out value="${dto.rev_content }"></c:out></td>
	</tr>
</table>

<a href="reviewmodify.2jo?rev_no=${dto.rev_no }">수정</a>
<a href="reviewdelete.2jo?rev_no=${dto.rev_no }">삭제</a>
	
<br>
<br>
<label>-댓글-</label>
<form method="post" action="subadd.2jo">  <!-- properties에 추가 -->
	<input type="hidden" name="num" value="${dto.rev_no }">  
	<textarea rows="3" cols="20" name="content" required></textarea><br>
	<!-- (+추가) login 이후 id(or사용자 이름)  -->
	<input type="submit" value="추가">
</form>
</body>
</html>