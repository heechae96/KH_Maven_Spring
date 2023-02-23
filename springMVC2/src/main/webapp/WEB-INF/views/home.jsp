<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring Web</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
</head>
<style>
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
	
	ul {
		list-style-type: none;
		height: 35px;
		background-color: pink;
		padding: 0;
		margin: 0;
	}
	
	li {
		width: 25%;
		height: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
		float: left;
	}
	
	li a {
		margin: 0;
	}
</style>
<body>
	<c:if test="${sessionScope.loginUser eq null }">
		<form action="/member/login.kh" method="post">
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">아이디</label> <input
					type="text" class="form-control" name="memberId"
					id="formGroupExampleInput" placeholder="아이디를 입력하세요">
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">비밀번호</label>
				<input type="password" class="form-control" name="memberPw"
					id="formGroupExampleInput2" placeholder="비밀번호를 입력하요">
			</div>
			<div class="d-grid gap-2">
				<button type="submit" class="btn btn-primary">완료</button>
				<button type="reset" class="btn btn-danger">취소</button>
				<button type="button" class="btn btn-success" onclick="goEnroll()">회원가입</button>
			</div>
		</form>
	</c:if>
	<c:if test="${sessionScope.loginUser ne null }">
		<header>
			<div>
				<b>${sessionScope.loginUser.memberName }</b>님 환영합니다
			</div>
			<div>
				<b><a href="/">Go Home</a></b>
			</div>
			<div>
				<a href="/member/logout.kh" onclick="return check()">로그아웃</a> <a
					href="/member/myPage.kh">마이페이지</a>
			</div>
		</header>
		<nav>
			<ul>
				<li><a href="/notice/write.kh">공지사항 쓰기</a></li>
				<li><a href="/notice/list.kh">공지사항 목록</a></li>
				<li><a>-</a></li>
				<li><a>-</a></li>
			</ul>
		</nav>
	</c:if>
	<script type="text/javascript">
		function check() {
			if (confirm("정말 로그아웃 하시겠습니까?")) {
				return true;
			} else {
				return false;
			}
		}

		function goEnroll() {
			location.href = "/member/register.kh";
		}
	</script>
</body>
</html>
