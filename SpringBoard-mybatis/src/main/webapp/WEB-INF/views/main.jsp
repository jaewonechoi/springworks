<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHIT 홈</title>
</head>
<body>
	<h1>${sessionId}님 환영합니다.</h1>
	<h3>
		<button onclick="update()">회원정보 수정</button>
		<button onclick="logout()">로그아웃</button>
		<a href="/"><button>Home</button></a>
	</h3>
	<script>
		const logout = () => {
			location.href = "/user/logout";
		}
		
		const update = () => {
			location.href = "/user/update";
		}
	</script>
</body>
</html>