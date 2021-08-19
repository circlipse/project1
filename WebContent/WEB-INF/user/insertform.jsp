<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$().ready(function() {

		$('#overlap').click(function() {
			let inputid = $('#id').val();
			
			if(!inputid){
				alert("아이디를 입력해주세요");
				return false;
			}else{
				location.href="useroverlap.2jo?inputid="+inputid;
			}
			
		});
		
			
	});
	 function checkSubmit(inputid,useid) {
			console.log('확인'+inputid);
			console.log('중복숫자'+useid);

		    let id = document.getElementById('id').value;
		    
			if(inputid!=id || useid!=0){
				alert('아이디 중복확인을 해주세요.');
				return false;
			}} ;
</script>
</head>
<body>
<c:set var="useid" value="${requestScope.useid}"></c:set> 
	<c:set var="inputid" value="${requestScope.inputid}"></c:set> 
<form method="post" action="insertresult.2jo" onsubmit="return checkSubmit(${inputid},${useid });">
	<ul>
		<li><label for="id">아이디</label> <c:choose>
					<c:when test="${useid == 1 }">
						<span>사용중인 아이디 입니다.</span>
						<br>
						<input type="text" id="id" name="id" required="required">
					</c:when>
					<c:when test="${useid == 0 }">
						<span> 사용가능한 아이디 입니다.</span>
						<br>
						<input type="text" id="id" name="id" value="${inputid }"
							required="required">
					</c:when>
					<c:otherwise>
						<br>
						<input type="text" id="id" name="id" value="${inputid }"
							required="required">
					</c:otherwise>
				</c:choose> <input type="button" value="중복확인" id="overlap"></li>
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
			<input type="submit" value="회원가입">
		</li>
	</ul>
</form>
</body>
</html>