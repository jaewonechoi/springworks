<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
	<h2>로그인</h2>
		<form action="/user/login" method="post">
			<table>
				<tr>
					<td>
						<label>아이디</label>
						<input type="text" name="userId" placeholder="아이디">
					</td>
				</tr>
				<tr>	
					<td>
						<label>비밀번호</label>
						<input type="password" name="userPasswd" placeholder="비밀번호">
					</td>
				</tr>	
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>