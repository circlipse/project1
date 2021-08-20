<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/loginresult.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$().ready(function() {

		$('#userdetail').click(function() {

			location.href = "userdetail.2jo";
			//location.href = "reservelist.2jo";
		});
		$('#logout').click(function() {

			location.href = "logout.2jo";
		});
	})
</script>
</head>
<body>
	<c:set var="id" value="${sessionScope.id}" />
	<c:set var="result" value="${requestScope.result}" />
	<form>

	<table>
				<tr>
					<td><c:out value="${sessionScope.id}" /></td>
					<td>님 반갑습니다.</td>
				</tr>
			</table>
			
			<div id="btn">
			<input type="button" value="마이페이지" id="userdetail">
			<input type="button" value="로그아웃" id="logout">
			</div>
			
</form>
	<%-- <c:if test="${id !=null}">
		<c:choose>
			<c:when test="${result >0}">
				<table>
					<tr>
						<td><c:out value="${sessionScope.id}" /></td>
						<td>님 반갑습니다.</td>
					</tr>
				</table>
				<button id="userdetail">마이페이지</button>
				<button id="logout">로그아웃</button>
			</c:when>

			<c:otherwise>
				<script>
					alert('로그인이 되지 않았습니다.');
					location.href = "login.2jo";
				</script>
			</c:otherwise>

		</c:choose>
	</c:if> --%>


</body>
</html>