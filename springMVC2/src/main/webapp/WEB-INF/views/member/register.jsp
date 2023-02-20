<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/member/register.kh" method="post">
		ID : <input type="text" name="memberId"><br>
		PW : <input type="password" name="memberPw"><br>
		NAME : <input type="text" name="memberName"><br>
		EMAIL : <input type="text" name="memberEmail"><br>
		PHONE : <input type="text" name="memberPhone"><br>
		ADDRESS : <input type="text" name="memberAddr"><br><br>
		<input type="submit" value="완료">
		<input type="button" value="뒤로가기" onclick="goHome()">
	</form>
	<script type="text/javascript">
		function goHome(){
			location.href = "/";
		}
	</script>
</body>
</html>