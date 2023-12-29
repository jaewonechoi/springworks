<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스 페이지</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
	<h2>khit 홈입니다.</h2>
		<div class="main-pic">
			<img src="/resources/images/bear.jpg" alt="곰인형">
		</div>
		<div class="menu">
		<c:if test="${empty sessionId}">
			<!-- <a href="/board/write">글쓰기</a>&nbsp;&nbsp;&nbsp; -->
			<a href="/board/list">글목록</a>&nbsp;&nbsp;&nbsp;
			<a href="/user/join">회원가입</a>&nbsp;&nbsp;&nbsp;
			<a href="/user/login">로그인</a>&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${not empty sessionId}">
			<a href="/board/write">글쓰기</a>&nbsp;&nbsp;&nbsp;
			<a href="/board/list">글목록</a>&nbsp;&nbsp;&nbsp;
			<a href="/user/join">회원가입</a>&nbsp;&nbsp;&nbsp;
			<a href="/user/login">로그인</a>&nbsp;&nbsp;&nbsp;
		</c:if>	
		</div>
	</div>
</body>
</html>