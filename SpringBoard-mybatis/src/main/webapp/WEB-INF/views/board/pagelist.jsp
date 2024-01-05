<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="boardlist">
			<h2>글목록</h2>
			<table>
				<thead>
					<tr>
						<th>글번호</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardList}" var="board">
						<tr>
							<td>${board.id}</td>
							<td><a href="/board?id=${board.id}&page=${paging.page}">${board.boardTitle}</a></td>
							<td>${board.userId}</td>
							<td>${board.hit}</td>
							<td>
								<c:choose>
									<c:when test="${empty board.updatedTime}">
										<fmt:formatDate value="${board.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
									</c:when>
									<c:otherwise>
										<fmt:formatDate value="${board.updatedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 페이지 처리  영역 -->
			<div class="pagenation">
			<!-- 이전 페이지 -->
				<c:choose>
					<c:when test="${paging.page <= 1}">
						<span>[이전]</span>
					</c:when>
					<c:otherwise>
						<a href="/board/paging?page=${paging.page - 1}">[이전]</a>
					</c:otherwise>
				</c:choose>
			<!-- 현재 페이지 -->
				<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
					<a href="/board/paging?page=${i}">${i}</a>
				</c:forEach>
				<!-- 다음 페이지 -->
				<c:choose>
					<c:when test="${paging.page >= paging.maxPage}">
						<span>[다음]</span>
					</c:when>
					<c:otherwise>
						<a href="/board/paging?page=${paging.page + 1}">[다음]</a>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- 글쓰기 버튼 -->
			<div>
				<a href="/board/write">
					<button>글쓰기</button>
				</a>
			</div>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>