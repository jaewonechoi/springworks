<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<h2>회원 정보</h2>
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
			<input type="text" name="password" value="${member.password}" readonly>
		</p>
		<p>
			<label>이름</label>
			<input type="text" name="name" value="${member.name}" readonly>
		</p>
		<p>
			<label>나이</label>
			<input type="text" name="age" value="${member.age}" readonly>
		</p>
		<p>
		<c:if test="${sessionEmail eq member.email}">
			<button type="button" onclick="update('${sessionEmail}')">수정</button>
		</c:if>
			<button type="button" onclick="list()">목록</button>
		</p>
</body>
<script>
	//목록 보기 버튼
	let list = function(){
		location.href = "/member/list";
	}
	
	let update = function(mem){
		location.href = "/member/update?email=" + mem;
	}
</script>
</html>