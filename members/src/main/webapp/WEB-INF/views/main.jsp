<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>members</title>
</head>
<body>
	<div class="content">
		<h2>${sessionEmail}님 환영합니다.</h2>
		<h4><button type="button" onclick="update()">내 정보 수정</button></h4>
		<h4><button type="button" onclick="logout()">로그 아웃</button></h4>
		<h4><button type="button" onclick="list()">회원목록</button></h4>
		<h4><button type="button" onclick="index()">Home</button></h4>
	</div>
<script>
	let index = function(){
		location.href = "/";	
	}
	
	let logout = function(){
		location.href = "/member/logout";
	}
	
	let list = function(){
		location.href = "/member/list";
	}
	
	let update = function(){
		location.href = "/member/detail";
	}
</script>
</body>
</html>