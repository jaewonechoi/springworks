<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="memberview">
			<h2>회원 정보 수정</h2>
			<form action="/user/update" method="post">
				<input type="hidden" name="id" value="${user.id}">
				<table>
					<tr>
						<td>
							<label>아이디</label>
							<input type="text" name="userId" value="${user.userId}" readonly>
						</td>
					</tr>
					<tr>	
						<td>
							<label>비밀번호</label>
							<input type="password" name="userPasswd" value="${user.userPasswd}">
						</td>
					</tr>	
					<tr>
						<td>
							<label>이름</label>
							<input type="text" name="userName" value="${user.userName}">
						</td>
					</tr>
					<tr>
						<td>
							<label>나이</label>
							<input type="text" name="userAge" value="${user.userAge}">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit">수정하기</button>
						</td>
					</tr>
				</table>
			</form>
		</section>	
	</div>
	<jsp:include page="../layout/footer.jsp" />
	<script>
		const list = function(){
			location.href = "/user/";
		}
	</script>
</body>
</html>