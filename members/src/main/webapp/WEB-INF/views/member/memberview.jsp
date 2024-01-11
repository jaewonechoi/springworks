<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 정보 수정</title>
</head>
<body>
	<h2>나의 정보 수정</h2>
	<form action="/member/detail" method="post">
		<p>
			<input type="text" name="email" placeholder="이메일" value="${member.email}" readonly>
		</p>
		<p>
			<input type="text" name="password" placeholder="비밀번호" value="${member.password}">
		</p>
		<p>
			<input type="text" name="name" placeholder="이름" value="${member.name}" readonly>
		</p>
		<p>
			<input type="text" name="age" placeholder="나이" value="${member.age}">
		</p>
		<p>
			<input type="submit" value="수정">
			<a href="main"><button>목록</button></a>
		</p>
	</form>
</body>
</html>