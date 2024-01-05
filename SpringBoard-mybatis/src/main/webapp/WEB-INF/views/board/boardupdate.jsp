<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="boardview">
		<form action="/board/update" method="post">
			<input type="hidden" name="id" value="${board.id}">
			<h2>글 수정</h2>
				<table>
					<tr>
						<td>
							<input type="text" name="boardTitle" 
							value="${board.boardTitle}">
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="userId" 
							value="${board.userId}" readonly>
						</td>
					</tr>	
					<tr>
						<td>
							<textarea rows="5" cols="60" name="boardContent" 
							>${board.boardContent}</textarea>
						</td>	
					</tr>
					<tr>
						<td>조회수 : ${board.hit}</td>
					</tr>
					<tr>
						<td>작성일 : <fmt:formatDate value="${board.updatedTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
					<tr>
						<td>
							<button type="submit">수정</button>
							<button>취소</button>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>