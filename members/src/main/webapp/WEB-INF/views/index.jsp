<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>members</title>
<style>
	.content{margin-left: 30px;}
</style>
</head>
<body>
	<div class="content">
	<c:choose>
		<c:when test="${empty sessionEmail}">
			<h2>Members 프로젝트 입니다.</h2>
			<h4><a href="/member/join">회원 가입</a></h4>
			<h4><a href="/member/login">로그인</a></h4>
			<h4><a href="/member/list">회원목록</a></h4>
		</c:when>
		<c:otherwise>
		<h2>${sessionEmail}님 환영합니다.</h2>
			<h4><button type="button" onclick="update()">내 정보 수정</button></h4>
			<h4><button type="button" onclick="logout()">로그 아웃</button></h4>
			<h4><button type="button" onclick="list()">회원목록</button></h4>
			<h4><button type="button" onclick="index()">Home</button></h4>
		</c:otherwise>	
	</c:choose>
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