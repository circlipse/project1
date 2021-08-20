<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reserveinsert.css">
</head>
<body>
<c:set var="id" value="${sessionScope.id }"></c:set>
<c:set var="user_no" value="${requestScope.user_no }"></c:set>

<form method="post" action="reserveinsertresult.2jo?user_no=${user_no}">
<h2>예약</h2>
<ul>
	<li>
		<label for="rsv_date">예약일</label>
		<input type="date" name="rsv_date" id="rsv_date" required>
	</li>
	<li>
		<label for="sub_date">예약시간</label>
		<input type="time" name="sub_date" id="sub_date" required>
	</li>
	<li>
		<label for="addr_depart">출발</label>
		<input type="text" name="addr_depart" id="addr_depart"
			placeholder="짐 맡기는 위치">
	</li>
	<li>
		<label for="addr_arrive">도착</label>
		<input type="text" name="addr_arrive" id="addr_arrive"
			placeholder="짐 찾아가는 위치">
	</li>
	<li>
        <label>가방 종류</label>
        <select class="bag" name="bag">
        <option value="" disabled selected>--- 선택 ---</option>
        <option value="캐리어" id="bag">캐리어</option>
        <option value="백팩" id="bag">백팩</option>
        </select>
    </li>
    <li>
        <div class="result1"></div>
        <div class="result2"></div>
    </li>
    <li><label>배송시 당부 말씀</label></li>
    <li><textarea cols="40" rows="10" name="rsv_content" id="rsv_content"></textarea></li>
    </ul>
        <input type="submit" id="rsv" value="예약하기">
        <input type="reset" id="cancel" value="취소">
		<input type="hidden" name="id" value="${id }">
</form>
<script type="text/javascript" charset="utf-8"><%@ include file="../js/baginsert.js"%></script>
<script type="text/javascript" charset="utf-8"><%@ include file="../js/date.js"%></script>
</body>
</html>