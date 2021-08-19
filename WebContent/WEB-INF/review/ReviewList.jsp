<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reviewlist.css">


</head>
<body>  

<c:set var="reviewlist" value="${requestScope.reviewlist }"></c:set>
<c:set var="currpage" value="${requestScope.currpage}"></c:set>
<c:set var="datacount" value="${requestScope.datacount }"></c:set>
<c:set var="startblock" value="${requestScope.startblock }"></c:set>
<c:set var="endblock" value="${requestScope.endblock }"></c:set>
<c:set var="totalpage" value="${requestScope.totalpage }"></c:set>
<c:set var="startrow" value="${requestScope.startrow }"></c:set>

<form>
<table>
	<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr>
	</thead>
	
	<tbody>
	<c:set var="rev_no" value="${startrow -1 }"></c:set>
	<c:forEach var="item" items="${reviewlist }">
	<c:set var="rev_no" value="${rev_no +1 }"></c:set>
	<tr>
	<td><c:out value="${rev_no }"></c:out></td>
	<td><a href="reviewdetail.2jo?rev_no=${item.rev_no }"><c:out value="${item.rev_title }"></c:out></a></td>
	<td><c:out value="${item.user_id }"></c:out></td>
	<td><c:out value="${item.rev_readno}"></c:out></td>
	</tr>
	</c:forEach>
	</tbody>
</table>

<div id="paging">
 <c:if test="${startblock>1 }">
    <a href="reviewlist.2jo?curr=${currpage-1}">이전</a>
 </c:if>


<c:forEach var="index" begin="${startblock }" end="${endblock }">
  <c:if test="${currpage==index }">
     <c:out value="${index }"></c:out>
  </c:if>
  <c:if test="${currpage!=index }">
      <a href="reviewlist.2jo?curr=${index}">${index}</a> 
  </c:if>
</c:forEach>


<c:if test="${endblock<totalpage}">
  <a href="reviewlist.2jo?curr=${currpage+1 }">다음</a>
</c:if>
</div>

<div id="write">
<a href="reviewinsert.2jo" >글쓰기</a>
</div>

</form>
</body>
</html>