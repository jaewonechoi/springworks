<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류가 발생했습니다</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id=container>
		<h2>페이지에 오류가 발생 했습니다.</h2>
		<h4>${exception.getMessage()}</h4>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>