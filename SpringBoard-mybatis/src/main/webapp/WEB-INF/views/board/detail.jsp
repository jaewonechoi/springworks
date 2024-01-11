<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="boardview">
		<h2>글 상세보기</h2>
			<table>
				<tr>
					<td>
						<input type="text" name="boardTitle" 
						value="${board.boardTitle}" readonly>
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
						readonly>${board.boardContent}</textarea>
					</td>	
				</tr>
				<tr>
					<td>조회수 : ${board.hit}</td>
				</tr>
				<tr>
				<!-- 수정일이 없으면 작성일을 표시하고 수정일이 있는경우 수정일을 표시 -->
					<td>
						<c:choose>
							<c:when test="${empty board.updatedTime}">
								작성일 : <fmt:formatDate value="${board.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</c:when>
							<c:otherwise>
								수정일 : <fmt:formatDate value="${board.updatedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>
					<!-- 세션 적용 : 로그인한 사용자만 수정/삭제 보임 -->
					<c:if test="${board.userId eq sessionId}">
						<a href="/board/update?id=${board.id}">
							<button>수정</button>
						</a>
						<a href="/board/delete?id=${board.id}" onclick="return confirm('정말로 삭제하시겠습니까?')">
							<button>삭제</button>
						</a>
					</c:if>	
						<a href="/board/paging?page=${page}"><button>목록</button></a>
					</td>
				</tr>
			</table>
			
			<div id="reply-list">
			<!-- 댓글 목록 -->
			<c:forEach items="${replyList}" var="reply">
				<div class="reply">
					<p>${reply.replyContent}</p>
					<p>
						작성자: ${reply.replyer}
						<c:choose>
							<c:when test="${empty reply.updatedTime}">
								작성일 : <fmt:formatDate value="${reply.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</c:when>
							<c:otherwise>
								수정일 : <fmt:formatDate value="${reply.updatedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</c:otherwise>
						</c:choose>
					</p>
					<p>
						<a href="/reply/update?boardId=${board.id}&id=${reply.id}">수정</a> | 
						<a href="/reply/delete?boardId=${board.id}&id=${reply.id}"
							onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a>
					</p>
				</div>
			</c:forEach>
			</div>
			
			<!-- 댓글 등록 -->
			<c:if test="${not empty sessionId}">
				<input type="hidden" name="boardId" id="boardId" value="${board.id}">
					<p>
						<input type="text" name="replyer" id="replyer" value="${sessionId}" placeholder="작성자">
					</p>
					<p>
						<textarea rows="3" cols="50" name="replyContent" id="replyContent" placeholder="댓글을 남겨보세요"></textarea>
					</p>
					<button onclick="replyInsert()">등록</button> 			
			</c:if>
			<!-- 댓글 등록 로그인 이동 -->
			<c:if test="${empty sessionId}">
				<div class="replylogin">
					<a href="/user/login"><i class="fa-solid fa-user"></i> 로그인한 사용자만 댓글 등록이 가능합니다</a>
				</div>
			</c:if>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
	<script>
		const replyInsert = function() {
			//alert("test");
			//댓글 등록이 비어있으면 "댓글을 입력해 주세요."
			//댓글 내용이 있으면 서버에 전송
			let boardId = "${board.id}"
			let replyer = document.getElementById("replyer").value;
			let content = document.getElementById("replyContent").value;
			
			if(content == ""){
				alert("댓글을 입력해 주세요.");
				document.getElementById("replyContent").focus();
				return false;
			}
			//ajax 구현
			$.ajax({
				//요청 방식: POST, 요청주소: /reply/insert
				type: "POST",
				url: "/reply/insert",
				data:{
					boardId: boardId,
					replyer: replyer,
					replyContent: content
				},
				success: function(replyList){
					console.log("댓글 등록 성공")
					console.log(replyList);
					//댓글 목록
					let output = "";
					for(let i in replyList){
						output += "<div class='reply'>";
						output += "<p>" + replyList[i].replyContent + "</p>";
						output += "<p>작성자: " + replyList[i].replyer + "";
						output += "(작성일: " + replyList[i].createdTime + ")</p>";
												
						output += "</div>";
					}
					document.getElementById("reply-list").innerHTML = output;
					document.getElementById("replyContent").value = "";
				},
				error: function(){
					console.log("댓글 등록 실패")
				}
			});
		}
	</script>
</body>
</html>