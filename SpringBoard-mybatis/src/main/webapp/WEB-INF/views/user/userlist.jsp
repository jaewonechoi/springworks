<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="memberlist">
			<h2>회원 목록</h2>
			<table>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>나이</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.id}</td>
						<td><a href="/user?id=${user.id}">${user.userId}</a></td>
						<td>${user.userPasswd}</td>
						<td>${user.userName}</td>
						<td>${user.userAge}</td>
						<td>
							<%-- <c:if test="${sessionId eq user.userId}"> --%>
								<a href="/user/delete?id=${user.id}" onclick="return confirm('정말로 삭제하시겠습니까?')">
									<button>삭제</button>
								</a>
							<%-- </c:if> --%>
						</td>
					</tr>	
				</c:forEach>
			</table>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
	<!-- <script>
		const delete = () => {
			let id = "${user.id}"
			location.href = "/user/delete?id=" + id;
		}
	</script> -->
</body>
</html>