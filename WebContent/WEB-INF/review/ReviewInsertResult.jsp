<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<%
	int result=(Integer)request.getAttribute("result");

	if(result>0)

		if(result>0)
		{%>
		<script>
		location.href="reviewlist.2jo";
		</script>
			
		<%}else{ %>
		<script>
		alert("리뷰 입력 실패 / 다시 작성해 주세요.");
		location.href="reviewlist.2jo";
		</script>
		
	<%}%>

</body>
</html>