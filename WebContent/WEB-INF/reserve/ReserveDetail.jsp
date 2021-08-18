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
	function reserveModify(rsv_no)
	{
		console.log(rsv_no);
		location.href="ReserveModify.jsp?no="+rsv_no;
	}
	function reserveDelete(rsv_no)
	{
		console.log(rsv_no);
		location.href="ReserveDelete.jsp?no="+rsv_no;
	}
</script>
</head>
<body>
	<c:set var="dto" value="${requestScope.dto }"></c:set>
<h2>예약 확인</h2>	
<table>
<tbody>
	<tr>
		<td>예약번호</td>
		<td><c:out value="${dto.rsv_no }"></c:out></td>
	</tr>
	<tr>
		<td>예약자명</td>
		<td><c:out value="${dto.user_name }"></c:out></td>
	</tr>
	<tr>
		<td>연락처</td>
		<td><c:out value="${dto.user_phone }"></c:out></td>
	</tr>
	<tr>
		<td>예약일자</td>
		<td><c:out value="${dto.rsv_date }"></c:out></td>
	</tr>
	<tr>
		<td>예약시간</td>
		<td><c:out value="${dto.sub_date }"></c:out></td>
	</tr>
	<tr>
		<td>출발</td>
		<td><c:out value="${dto.addr_depart }"></c:out></td>
	</tr>
	<tr>
		<td>도착</td>
		<td><c:out value="${dto.addr_arrive }"></c:out></td>
	</tr>
	<tr>
		<td>예약 종류</td>
		<td>캐리어</td>
		<td><c:out value="${dto.bag_val_1 }"></c:out></td>
	</tr>
	<tr>
		<td>배낭</td>
		<td><c:out value="${dto.bag_val_2 }"></c:out></td>
	</tr>
	<tr>
		<td>배송시 당부 말씀</td>
		<td><c:out value="${dto.rsv_content }"></c:out></td>
	</tr>
</tbody>
</table>
	<input type="button" id="modify" value="예약 변경" onclick="reserveModify(${dto.rsv_no})">
	<input type="button" id="delete" value="예약 취소" onclick="reserveDelete(${dto.rsv_no })">
</body>
</html>