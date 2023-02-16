<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 웹</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="/member/login.do" method="post">
		ID : <input type="text" name="member-id">
		PW : <input type="password" name="member-pw">
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	</form>
</body>
</html>