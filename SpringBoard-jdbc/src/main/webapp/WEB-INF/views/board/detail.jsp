<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
	<h2>글 상세보기</h2>
			<table>
				<tr>
					<td>
						<label>글제목</label>
						<input type="text" name="boardTitle" value="${board.boardTitle}" readonly>
					</td>
				</tr>
				<tr>	
					<td>
						<label>글쓴이</label>
						<input type="text" name="boardWriter" value="${board.boardWriter}" readonly>
					</td>
				</tr>	
				<tr>
					<td>
						<label>글내용</label>
						<textarea rows="5" cols="50" name="boardContent" readonly>${board.boardContent}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<c:if test="${board.boardWriter eq sessionId}">
						<a href="/board/update?id=${board.id}">
							<button>수정</button>
						</a>
						<a href="/board/delete?id=${board.id}"
						 onclick="return confirm('정말로 삭제하시겠습니까?')">
						 	<button>삭제</button>
						</a>
					</c:if>
						<a href="/board/list"><button>목록</button></a>
					</td>
				</tr>
			</table>
	</div>
</body>
</html>