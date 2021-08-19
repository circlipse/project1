<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
<form method="post" action="reserveinsertresult.2jo">
<h2>예약</h2>
<ul>
	<li>
		<label for="user_no">회원번호</label>
		<input type="text" name="user_no" id="user_no">
	</li>
	<li>
		<label for="rsv_date">예약일</label>
		<input type="date" name="rsv_date" id="rsv_date" required>
	</li>
	<li>
		<input type="time" name="sub_date" id="sub_date" required>
	</li>
	<li>
		<label for="addr_depart">출발</label>
		<input type="text" name="addr_depart" id="addr_depart"
			placeholder="짐 맡기는 위치">
	</li>
	<li>
		<label for="addr_arrive">도착</label>
		<input type="text" name="addr_arrive" id="addr_arrive"
			placeholder="짐 찾아가는 위치">
	</li>
</ul>
	<label>가방 종류
        <select class="bag" name="bag">
        <option value="" disabled selected>------</option>
          <option value="캐리어" id="bag">캐리어</option>
          <option value="백팩" id="bag">백팩</option>
        </select>
      </label>
      <div class="result"></div>
<ul>
	<li>배송시 당부 말씀</li>
	<li><textarea cols="40" rows="10" name="rsv_content" id="rsv_content"></textarea></li>
	<li>
	<input type="submit" value="예약하기">
	<input type="reset" value="취소">
	</li>
</ul>
</form>
<script type="text/javascript" charset="utf-8"><%@ include file="../js/baginsert1.js"%></script>
</body>
</html>