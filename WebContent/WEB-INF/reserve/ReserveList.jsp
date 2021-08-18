<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function reserveList(rsv_no)
	{
		console.log(rsv_no);
		location.href="reservedetail.2jo?rsv_no="+rsv_no;
	}
</script>
</head>
<body>
<c:set var="list" value="${requestScope.list }"></c:set>
<h2>예약현황</h2>
<table>
<thead>
	<tr><th>No.</th><th>예약번호</th><th>예약일</th><th>예약변경/취소</th></tr>
</thead>
<tbody>
<c:forEach var="item" items="${list }">
	<tr>
	<td><c:out value="${item.rnum }"/></td>
	<td><c:out value="${item.rsv_no }"/></td>
	<td><c:out value="${item.rsv_date }"/></td>
	<td><input type="button" id="detail" value="예약 상세보기"
		onclick="reserveList(${item.rsv_no })"></td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>