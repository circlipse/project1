<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="usermodiresult.2jo">
	<ul>
	
		<li>
			<label for="user_id">아이디</label>
			<input type="text" name="user_id" id="user_id" readonly="readonly">
		</li>
		
		<li>
			<label for="user_pwd">패스워드</label>
			<input type="text" name="user_pwd" id="user_pwd" required="required">
		</li>
		
		<li>
			<label for="user_name">이름</label>
			<input type="text" name="user_name" id="user_name" required="required">
		</li>
		
		<li>
			<label for="user_phone">전화번호</label>
			<input type="text" name="user_phone" id="user_phone" required="required">
		</li>
		
		<li>
			<input type="submit" value="수정">
		</li>
		
	</ul>
</form>
</body>
</html>