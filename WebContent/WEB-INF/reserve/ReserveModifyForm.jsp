<%@page import="dto.ReserveDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reservemodify.css">
</head>
<body>
<form method="post" action="reservemodifyresult.2jo">
	<c:set var="dto" value="${requestScope.dto }"/>
	<c:set var="dto2" value="${requestScope.dto2 }"/>
<% ReserveDTO dto3=(ReserveDTO)request.getAttribute("dto2"); %>
<h2>예약 변경</h2>
<div class="wrap">
<table>
<thead>
<tr><th></th><th></th></tr>
</thead>
<tbody>
	<tr>
		<td>예약번호</td>
		<td colspan="2"><input type="text" id="rsv_no" name="rsv_no" value="${dto.rsv_no }" readonly></td>
	</tr>
	<tr>
		<td>예약자명</td>
		<td colspan="2"><input type="text" id="user_name" name="user_name" value="${dto.user_name }" readonly></td>
	</tr>
	<tr>
		<td>연락처</td>
		<td colspan="2"><input type="text" id="user_phone" name="user_phone" value="${dto.user_phone }" readonly></td>
	</tr>
	<tr>
		<td>예약일자</td>
		<td colspan="2"><input type="date" id="rsv_date" name="rsv_date" value="${dto.rsv_date }"></td>
	</tr>
	<tr>
		<td>예약시간</td>
		<td colspan="2"><input type="time" id="sub_date" name="sub_date" value="${dto.sub_date }"></td>
	</tr>
	<tr>
		<td>출발</td>
		<td colspan="2"><input type="text" id="addr_depart" name="addr_depart" value="${dto.addr_depart }"></td>
	</tr>
	<tr>
		<td>도착</td>
		<td colspan="2"><input type="text" id="addr_arrive" name="addr_arrive" value="${dto.addr_arrive }"></td>
	</tr>
	<tr>
		<td rowspan="3">예약 종류</td>
		<td>
		<label>가방 종류
        <select class="bag" name="bag">
          <option value="" disabled selected>------</option>
          <option value="캐리어" id="bag1">캐리어</option>
          <option value="백팩" id="bag2">백팩</option>
        </select>
      	</label>
      	</td>
	</tr>
	<tr class="result1">
		<td id="bagg1">캐리어
		<input type="number" min="1" max="20" id="val" name="bag_val_1" 
			value="${dto2.bag_val_1 }" onchange="sumprice()">
		<button type="button" id="delete" onclick="del1();">삭제</button></td>
	</tr>
	<tr class="result2">
		<td id="bagg2">백팩
		<input type="number" min="1" max="20" id="val" name="bag_val_2" 
			value="${dto2.bag_val_2 }" onchange="sumprice()">
		<button type="button" id="delete" onclick="del2();">삭제</button></td>
	</tr>
	<tr>
		<td><label>금액</label></td>
        <td><input type="text" name="price" id="price" value="<%=dto3.getBag_val_1()*15000 + dto3.getBag_val_2()*10000%>" readonly></td>
	</tr>
	<tr>
		<td>배송 시<br>당부 사항</td>
		<td colspan="2"><textarea cols="30" rows="5" name="rsv_content"><c:out value="${dto.rsv_content }"/></textarea></td>
	</tr>
</tbody>
</table>
</div>
<div class="button">
	<input type="submit" id="modify" value="수정 완료">
	<input type="reset" id="reset" value="취소">
	<input type="hidden" name="old_bag_val_1" value="${dto2.bag_val_1}">
	<input type="hidden" name="old_bag_val_2" value="${dto2.bag_val_2}">
</div>
</form>
<script type="text/javascript" charset="utf-8"><%@ include file="../js/bagmodify1.js"%></script>
<script type="text/javascript" charset="utf-8"><%@ include file="../js/date2.js"%></script>
</body>
</html>