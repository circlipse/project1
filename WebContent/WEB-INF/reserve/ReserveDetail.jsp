<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
/*
 * d
 */
	function reserveModify(rsv_no)
	{ 
		console.log(rsv_no);
		location.href="reservemodify.2jo?rsv_no="+rsv_no;
	}
	function reserveDelete(rsv_no)
	{
		console.log(rsv_no);
		location.href="reservedelete.2jo?rsv_no="+rsv_no;
	}
</script>
<link rel="stylesheet" href="css/reservedetail.css">
</head>
<body>
	<c:set var="id" value="${sessionScope.id }"></c:set>
	<c:set var="dto" value="${requestScope.dto }"></c:set>
	<c:set var="dto2" value="${requestScope.dto2 }"></c:set>
<div class="wrap">
<table>
<thead>
<tr><th></th><th></th><th></th></tr>
</thead>
<tbody>
	<tr>
		<td>예약번호</td>
		<td colspan="2"><c:out value="${dto.rsv_no }"></c:out></td>
	</tr>
	<tr>
		<td>예약자명</td>
		<td colspan="2"><c:out value="${dto.user_name }"></c:out></td>
	</tr>
	<tr>
		<td>연락처</td>
		<td colspan="2"><c:out value="${dto.user_phone }"></c:out></td>
	</tr>
	<tr>
		<td>예약일자</td>
		<td colspan="2"><c:out value="${dto.rsv_date }"></c:out></td>
	</tr>
	<tr>
		<td>예약시간</td>
		<td colspan="2"><c:out value="${dto.sub_date }"></c:out></td>
	</tr>
	<tr>
		<td>출발</td>
		<td colspan="2"><c:out value="${dto.addr_depart }"></c:out></td>
	</tr>
	<tr>
		<td>도착</td>
		<td colspan="2"><c:out value="${dto.addr_arrive }"></c:out></td>
	</tr>
	<tr>
		<td rowspan="2">예약 종류</td>
		<td>캐리어</td>
		<td><c:out value="${dto2.bag_val_1 }"></c:out></td>
	</tr>
	<tr>
		<td>배낭</td>
		<td><c:out value="${dto2.bag_val_2 }"></c:out></td>
	</tr>
	<tr>
		<td>배송 시 <br>당부 말씀</td>
		<td colspan="2"><c:out value="${dto.rsv_content }"></c:out></td>
	</tr>
</tbody>
</table>
</div>
<div class="button">
	<input type="button" id="modify" value="예약 변경" onclick="reserveModify(${dto.rsv_no})">
	<input type="button" id="delete" value="예약 취소" onclick="reserveDelete(${dto.rsv_no })">
</div>
</body>
</html>