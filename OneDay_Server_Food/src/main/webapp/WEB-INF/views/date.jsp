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
	<h2>날짜 검색</h2>
	
		<c:if test="${ empty DATEFOODS }"> 등록된 정보가 없습니다. </c:if>
		<table  width ="1000">
			<tr align = "center">
				<th>날짜</th>
				<th>식품명</th>
				<th>섭취량</th>
				<th>총내용량</th>
				<th>에너지</th>
				<th>단백질</th>
				<th>지방</th>
				<th>탄수화물</th>
				<th>당류</th>
			</tr>
		<c:forEach items="${DATEFOODS}" var="DATEFOOD">
			<tr>
				<td align = "center">${FOOD.my_date}</td>
				<td>${FOOD.fd_name}</td>
				<td align = "center">${FOOD.my_intake}</td>
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