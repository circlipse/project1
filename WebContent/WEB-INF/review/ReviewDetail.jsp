<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reviewdetail.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>

function subdelete(subno, rev_no)
{
	location.href="subdelete.2jo?subno="+subno+"&rev_no="+rev_no;
}

$(document).ready(function () {
	let no=${dto.rev_no};
	
	$.ajax({
		url:'subdetail.2jo'    
		,data:{'rev_no' : no}
		,method:'post'
		,dataType:'json'    
		,success:function(data)
		{
			$.each(data, function (index, item) {
				let result="<tr>";
			     result+="<td>"+item.user_id+"</td>";
			     result+="<td>"+item.subcontent;
				     
				     result+="&nbsp;&nbsp;<input type='button' value='삭제' onclick=subdelete("+item.subno+","+item.rev_no+")>";
				     result+="</td></tr>";

			$('#result').append(result);
			});
			
		}
		,error:function(xhr){
			console.log('error'+xhr);
		}
	});
});
</script>
</head>
<body>


	<c:set var="dto" value="${requestScope.dto }"/>
	
	<c:set var="id" value="${sessionScope.id }"/>
	
<div id="tdetail">
<table id="detail">
	<tr>
		<td>번호</td><td><c:out value="${dto.rev_no }"></c:out></td>
	</tr>
	<tr>
		<td>제목</td><td><c:out value="${dto.rev_title }"></c:out></td>
	</tr>
	<tr>
		<td>작성자</td><td><c:out value="${dto.user_id }"></c:out></td>
	</tr>
	<tr>
		<td>내용</td><td><pre><c:out value="${dto.rev_content }"></c:out></pre></td>
	</tr>
</table>
</div>


<c:if test="${sessionScope.id==dto.user_id }">
<div class="btn">
	<span id="modi">
	<a href="reviewmodify.2jo?rev_no=${dto.rev_no }">글 수정</a>
	</span>
	<span id="del">
	<a href="reviewdelete.2jo?rev_no=${dto.rev_no }">삭제</a>
	</span>
</div>
</c:if>


<div id="comment">
<label>-댓글-</label>
<form method="post" action="subinsert.2jo">  
	<input type="hidden" name="rev_no" value="${dto.rev_no }">  
	<input type="text" id="user_id" name ="user_id" value="${id }" readonly="readonly"><br>
	<textarea rows="3" cols="40" name="subcontent" required></textarea><br>
	<input type="submit" value="추가">
</form>

<table id="result"></table>
</div>

<div id="tolist">
<a href="reviewlist.2jo">목록으로</a> 
</div>
</body>
</html>