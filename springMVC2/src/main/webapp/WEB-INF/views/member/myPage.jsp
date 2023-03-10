<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style type="text/css">
	body {
			margin: 0;
		}
	form div {
		display: flex;
		justify-content: space-evenly;
		margin: 5px 0px;
	}
	label {
		display: inline-block;
		width: 100px;
	}
	input {
		margin-bottom: 5px;
	}
	b {
		font-size: xx-large;
		color: purple;
		margin-left: 15px;
	}
	header {
	    display: flex;
	    background-color: lavenderblush;
	    justify-content: space-between;
	    align-items: center;
	    height: 75px;
	}
	a {
		font-size: large;
		display: block;
		margin-right: 15px;
		margin-bottom: 5px;
		color: purple;
	}
	a:visited, a:link {
		text-decoration: none;
		color: purple;
	}
	a:hover {
		color: purple;
		font-size: x-large;
	}
	main {
	    margin: 0 auto;
	    width: 500px;
	    height: 500px;
	    display: flex;
	    flex-direction: column;
	    justify-content: center;
	    align-items: center;
	}
</style>
</head>
<body>
	<header>
		<div>
			<b>${sessionScope.loginUser.memberName }</b>님 환영합니다
		</div>
		<div>
			<b><a href="/">Go Home</a></b>
		</div>
		<div>
			<a href="/member/logout.kh" onclick="return check()">로그아웃</a>
			<a href="/member/myPage.kh">마이페이지</a>
		</div>
	</header>
	<main>
		<form action="/member/modify.kh" method="post">
			<label for="id">ID : </label><input type="text" name="memberId" value="${user.memberId }" readonly id="id"><br>
			<label for="pw">PW : </label><input type="password" name="memberPw" value="${user.memberPw }" id="pw"><br>
			<label for="name">NAME : </label><input type="text" name="memberName" value="${user.memberName }" readonly id="name"><br>
			<label for="email">EMAIL : </label><input type="text" name="memberEmail" value="${user.memberEmail }" id="email"><br>
			<label for="phone">PHONE : </label><input type="text" name="memberPhone" value="${user.memberPhone }" id="phone"><br>
			<label for="addr">ADDRESS : </label><input type="text" name="memberAddr" value="${user.memberAddr }" id="addr"><br>
			<div>
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</div>
		</form>
		<a href="/member/delete.kh?memberId=${user.memberId }" onclick="return check()">회원탈퇴</a>
	</main>
	<script type="text/javascript">
	function check() {
		if(confirm("정말로 탈퇴하시겠습니까?")){
			return true;
		}else{
			return false;
		}
	}
	</script>
</body>
</html>