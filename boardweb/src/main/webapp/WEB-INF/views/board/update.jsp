<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정하기</title>
</head>
<body>
	<h2>글 수정하기</h2>
	<form action="/board/update" method="post">
			<input type="hidden" name="id" value="${board.id}">
			<p><input type="text" name="btitle" value="${board.btitle}"></p>
			<p><input type="text" name="bwriter" value="${board.bwriter}" readonly></p>
			<p><textarea rows="5" cols="50" name="bcontent">${board.bcontent}</textarea></p>
			<p>작성일: <input type="text" value="${board.createdDate}" readonly></p>
			<p><input type="submit" value="저장">
			<a href="/board/list"><button>목록</button></a>
		</form>
</body>
</html>