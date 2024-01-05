<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<c:if test="${empty sessionId}">
		<script>
			alert("로그인후 이용 가능합니다.");
			location.href="/user/login";
		</script>
	</c:if>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="writeform">
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
							<button type="submit">등록</button>
							<button type="reset">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>