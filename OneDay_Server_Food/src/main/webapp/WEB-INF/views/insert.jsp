<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>섭취정보 시스템</h1>
	<h2>섭취정보등록</h2>

	<hr>
	<form action="/food/insert/search" method="POST">
		식품명
		<input type="text" name="fd_name" value="">
		<button>검색하기</button>
	</form>
	<p> 날짜 <input type="text" name="my_date">
	<p> 섭취량 <input type="text" name="my_intake">
	<form action="/food">
		<button>등록하기</button>
	</form>
</body>
</html>