<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
	<h2>글쓰기</h2>
		<form action="/board/write" method="post">
			<table>
				<tr>
					<td>
						<input type="text" name="boardTitle" placeholder="글제목" required>
					</td>
				</tr>
				<tr>	
					<td>
						<input type="text" name="userId" value="${sessionId}" placeholder="글쓴이" required>
					</td>
				</tr>	
				<tr>
					<td>
						<textarea rows="5" cols="50" name="boardContent" placeholder="글내용"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>