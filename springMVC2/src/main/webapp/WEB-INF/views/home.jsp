<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring Web</title>
</head>
<body>
	<c:if test="${sessionScope.loginUser eq null }">
		<fieldset>
			<legend>로그인</legend>
			<form action="/member/login.kh" method="post">
				ID : <input type="text" name="memberId"> 
				PW : <input type="password" name="memberPw"> 
				<input type="submit" value="로그인"> 
				<input type="button" value="회원가입" onclick="goEnroll()">
			</form>
		</fieldset>
	</c:if>
	<c:if test="${sessionScope.loginUser ne null }">
		<b>${sessionScope.loginUser.memberName }</b>님 환영합니다
		<a href="/member/logout.kh" onclick="return check()">로그아웃</a>
		<a href="/member/myPage.kh">마이페이지</a>
	</c:if>
	<script type="text/javascript">
		function check() {
			if(confirm("정말 로그아웃 하시겠습니까?")){
				return true;
			}else{
				return false;
			}
		}
		
		function goEnroll(){
			location.href = "/member/register.kh";
		}
	</script>
</body>
</html>
