<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="reservemodifyresult.2jo">
	<c:set var="dto" value="${requestScope.dto }"/>
	<c:set var="dto2" value="${requestScope.dto2 }"/>
<table>
<tbody>
	<tr>
		<td>예약번호</td>
		<td><input type="text" id="rsv_no" name="rsv_no" value="${dto.rsv_no }" readonly></td>
	</tr>
	<tr>
		<td>예약자명</td>
		<td><input type="text" id="user_name" name="user_name" value="${dto.user_name }" readonly></td>
	</tr>
	<tr>
		<td>연락처</td>
		<td><input type="text" id="user_phone" name="user_phone" value="${dto.user_phone }" readonly></td>
	</tr>
	<tr>
		<td>예약일자</td>
		<td><input type="date" id="rsv_date" name="rsv_date" value="${dto.rsv_date }"></td>
	</tr>
	<tr>
		<td>예약시간</td>
		<td><input type="time" id="sub_date" name="sub_date" value="${dto.sub_date }"></td>
	</tr>
	<tr>
		<td>출발</td>
		<td><input type="text" id="addr_depart" name="addr_depart" value="${dto.addr_depart }"></td>
	</tr>
	<tr>
		<td>도착</td>
		<td><input type="text" id="addr_arrive" name="addr_arrive" value="${dto.addr_arrive }"></td>
	</tr>
	<tr>
		<td rowspan="4">예약 종류</td>
		<td>
		<label>가방 종류
        <select class="bag" name="bag">
          <option value="" disabled selected>------</option>
          <option value="캐리어" id="bag">캐리어</option>
          <option value="백팩" id="bag">백팩</option>
        </select>
      	</label>
      	</td>
	</tr>
	<tr>
		<td id="bagg1" class="캐리어">캐리어
		<input type="number" min="1" max="20" id="val" name="bag_val_1" value="${dto2.bag_val_1 }">
		<button type="button" id="delete" onclick="del1();">삭제</button></td>
	</tr>
	<tr>
		<td id="bagg2" class="백팩">백팩
		<input type="number" min="1" max="20" id="val" name="bag_val_2" value="${dto2.bag_val_2 }">
		<button type="button" id="delete" onclick="del2();">삭제</button></td>
	</tr>
	<tr class="result"></tr>
	<tr>
		<td>배송시 당부 말씀</td>
		<td><textarea cols="30" rows="5" name="rsv_content"><c:out value="${dto.rsv_content }"/></textarea></td>
	</tr>
</tbody>
</table>
	<input type="submit" value="변경완료">
	<input type="reset" value="취소">
	<input type="hidden" name="old_bag_val_1" value="${dto2.bag_val_1}">
	<input type="hidden" name="old_bag_val_2" value="${dto2.bag_val_2}">
</form>
<script type="text/javascript" charset="utf-8"><%@ include file="../js/bagmodify1.js"%></script>
</body>
</html>