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
	

		<form action="/select/date" method="GET">
			날짜
			<input type="text" name="my_date">
			<button>조회</button>
		</form>
		
		<c:if test="${ empty FOOD }"> 없다요 </c:if>
		<table>
			<th>날짜</th>
			<th>식품명</th>
			<th>섭취량</th>
			<th>총내용량</th>
			<th>에너지</th>
			<th>단백질</th>
			<th>지방</th>
			<th>탄수화물</th>
			<th>당류</th>
			
			<c:forEach items="${FOOD}" var="FOOD">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			
			</c:forEach>
			
		</table>
		
		
		<form action="/insert">
			<button>섭취정보등록</button>
		</form>
		
</body>
</html>