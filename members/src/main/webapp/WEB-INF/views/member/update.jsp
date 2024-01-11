<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h2>회원 정보 수정</h2>
	<form action="/member/update" method="post">
		<p>
			<label>번호</label>
			<input type="text" name="id" value="${member.id}" readonly>
		</p>
		<p>
			<label>이메일</label>
			<input type="text" name="email" value="${member.email}" readonly>
		</p>
		<p>
			<label>비밀번호</label>
			<input type="text" name="password" value="${member.password}">
		</p>
		<p>
			<label>이름</label>
			<input type="text" name="name" value="${member.name}">
		</p>
		<p>
			<label>나이</label>
			<input type="text" name="age" value="${member.age}" readonly>
		</p>
		<p>
			<input type="submit" value="수정">
			<button type="button" onclick="list()">목록</button>
		</p>
	</form>
</body>
<script>
	//목록 보기 버튼
	let list = function(){
		location.href = "/member/list";
	}
</script>
</html>