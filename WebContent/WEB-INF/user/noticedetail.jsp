<%@page import="dto.NoticeDTO"%>
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
function modify(notice_no)
{
	location.href="noticemodify.2jo?notice_no="+notice_no;
}
function del(notice_no)
{
	location.href="noticedelete.2jo?notice_no="+notice_no;
}
</script>
<link rel="stylesheet" href="css/noticedetail.css">
</head>
<body>
	<c:set var="dto" value="${requestScope.dto }"/>
	<c:set var="id" value="${sessionScope.id}" />
	
<%
NoticeDTO dto= (NoticeDTO) request.getAttribute("dto");
%>
	<div class="wrap">
	<table>
		<thead>
		<tr><th></th><th></th></tr>
		</thead>
		<tbody>
			<tr>
				<td>제목</td>
				<td><c:out value="${dto.notice_title }"></c:out></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><c:out value="${dto.notice_content }"></c:out></td>
			</tr>
			<%
			if(dto.getNotice_img() !=null){
			%> 
			<tr>
				<td colspan="2"><img src="uploadImage/<%=dto.getNotice_img() %>" width=512 height=384/></td>
				
			</tr>
			<%	
			}
			%>
			
		</tbody>
	</table>
	</div>

	<c:if test="${id eq 'admin' }">
	<div class="button">
		<input type="button" id="modify" value="수정" onclick="modify(${dto.notice_no})">
		<input type="button" id="del" value="삭제" onclick="del(${dto.notice_no })">
	</div>
	</c:if>
</body>
</html>