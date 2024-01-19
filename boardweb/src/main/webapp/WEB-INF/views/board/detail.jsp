<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<h2>글 상세보기</h2>
	<div>
			<p><input type="text" name="btitle" value="${board.btitle}" readonly></p>
			<p><input type="text" name="bwriter" value="${board.bwriter}" readonly></p>
			<p><textarea rows="5" cols="50" name="bcontent" readonly>${board.bcontent}</textarea></p>
			<p><a href="/board/list"><button>목록</button></a>
			<a href="/board/update?id=${board.id}"><button>수정</button></a>
			<a href="/board/delete?id=${board.id}"><button onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</button></a></p>
	</div>
</body>
</html>