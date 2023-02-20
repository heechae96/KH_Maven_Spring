<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<h1>마이페이지</h1>
	<form action="/member/modify.kh" method="post">
		ID : <input type="text" name="memberId" value="${user.memberId }" readonly><br>
		PW : <input type="password" name="memberPw" value="${user.memberPw }"><br>
		NAME : <input type="text" name="memberName" value="${user.memberName }" readonly><br>
		EMAIL : <input type="text" name="memberEmail" value="${user.memberEmail }"><br>
		PHONE : <input type="text" name="memberPhone" value="${user.memberPhone }"><br>
		ADDRESS : <input type="text" name="memberAddr" value="${user.memberAddr }"><br><br>
		<input type="submit" value="수정하기">
		<input type="button" value="뒤로가기" onclick="goHome()">
	</form>
	<script type="text/javascript">
	function goHome(){
		location.href = "/";
	}
	</script>
</body>
</html>