<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					     result+="<td>"+item.subcontent;
					     
					     result+="<input type='button' value='삭제' onclick=subdelete("+item.subno+","+item.rev_no+")>";
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
	
<!-- 	<table class="table table-striped"> -->
<table>
	<tr>
		<td>번호</td><td><c:out value="${dto.rev_no }"></c:out></td>
	</tr>
	<tr>
		<td>제목</td><td><c:out value="${dto.rev_title }"></c:out></td>
	</tr>
	<tr>
		<td>내용</td><td><c:out value="${dto.rev_content }"></c:out></td>
	</tr>
</table>

<a href="reviewmodify.2jo?rev_no=${dto.rev_no }">수정</a>
<a href="reviewdelete.2jo?rev_no=${dto.rev_no }">삭제</a>
	
<br>
<br>
<label>-댓글-</label>
<form method="post" action="subinsert.2jo">  
	<input type="hidden" name="rev_no" value="${dto.rev_no }">  
	<textarea rows="3" cols="20" name="subcontent" required></textarea><br>
	<!-- (+추가) login 이후 id(or사용자 이름)  -->
	<input type="submit" value="추가">
</form>

<table id="result"></table>

<br><br>

<a href="reviewlist.2jo">목록으로</a> 
</body>
</html>