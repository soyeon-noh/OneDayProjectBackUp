<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>섭취정보 시스템</h1>
	<h2>섭취정보등록</h2>

	<form action="/food/insert/search" method="POST">
		식품명
		<input type="text" name="fd_name">
		<button>검색하기</button>
	</form>

	<hr>
	<c:if test="${ empty NAMEFOODS }"> 등록된 정보가 없습니다. </c:if>
		<table>
			<tr align = "center">
				<th>식품코드</th>
				<th>식품명</th>
				<th>출시연도</th>
				<th>제조사명</th>
				<th>분류명</th>
				<th>1회제공량</th>
				<th>총내용량(g)</th>
				<th>에너지(kcal)</th>
				<th>단백질(g)</th>
				<th>지방(g)</th>
				<th>탄수화물(g)</th>
				<th>총당류(g)</th>
			</tr>
		<c:forEach items="${NAMEFOODS}" var="FOOD">
			<tr>
				<td align = "center"><a href ="?code=${FOOD.fd_code}">${FOOD.fd_code}</a></td>
				<td>${FOOD.fd_name}</td>
				<td align = "center">${FOOD.fd_year}</td>
				<td>${FOOD.cp_name}</td>
				<td align = "center">${FOOD.it_name}</td>
				<td align = "center">${FOOD.fd_container}</td>
				<td align = "center">${FOOD.fd_content}</td>
				<td align = "center">${FOOD.fd_calories}</td>
				<td align = "center">${FOOD.fd_protein}</td>
				<td align = "center">${FOOD.fd_fat}</td>
				<td align = "center">${FOOD.fd_carbo}</td>
				<td align = "center">${FOOD.fd_sugar}</td>
			</tr>
			</c:forEach>
			
		</table>
</body>
</html>