<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<h2>글목록</h2>
	<div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.id}</td>
						<td><a href="/board/detail?id=${board.id}">${board.btitle}</a></td>
						<td>${board.bwriter}</td>
						<td>${board.createdDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/"><button>Home</button></a>
	</div>
</body>
</html>