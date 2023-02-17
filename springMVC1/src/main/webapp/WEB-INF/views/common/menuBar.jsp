<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- false로 하면 로그인이 안된다 -->
<%-- <%@ page session="false"%> --%>
<html>
<head>
<title>Home</title>
<style type="text/css">
	h1 {
		text-align: center;
		color: #645CBB;
	}
	
	ul {
		list-style-type: none;
	}
	
	#navigator {
		margin: 0;
		padding: 0;
	}
	
	#navigator .item {
		float: left;
		width: 25%;
		text-align: center;
		line-height: 50px;
		background-color: #BFACE2;
	}
	
	#login-wrapper {
		display: flex;
		justify-content: flex-end;
	}
	
	#login-area {
		margin: 0;
		padding: 0;
	}
	
	#login-area .login-item {
		margin: 10px 0px;
	}
	
	#login-area .login-item label {
		width: 50px;
		text-align: left;
		float: left;
	}
	
	#btn-area {
		display: flex;
		justify-content: space-evenly;
	}
	
	#btn-area input {
		border: none;
		background-color: #BFACE2;
	}
	
	#btn-area input:hover {
		background-color: #A084DC;
		color: #fff;
	}

	a {
		display: block;
	}
	
	a:link, a:visited{
		text-decoration: none;
		color: black;
	}
	
	a:hover {
		cursor: pointer;
		background: #A084DC;
		color: #fff;
	}
}
</style>
</head>
<body>
	<h1>Welcome to Spring Web</h1>
	<!-- 리다이렉트용으로 사용이 가능하다(jsp 포워드 사용) -->
	<c:if test="${sessionScope.loginUser eq null }">
		<div id="login-wrapper">
			<form action="/member/login.do" method="post">
				<ul id="login-area">
					<li class="login-item">
						<label>ID : </label> 
						<input type="text" name="member-id">
					</li>
					<li class="login-item">
						<label>PW : </label> 
						<input type="password" name="member-pw">
					</li>
				</ul>
				<div id="btn-area">
					<input type="submit" value="로그인"> 
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</c:if>

	<c:if test="${sessionScope.loginUser ne null }">
		<b>${sessionScope.loginUser.memberName }</b>님 환영합니다
		<a href="/member/logout.do">로그아웃</a>
	</c:if>
	<ul id='navigator'>
		<li class="item"><a href="javascript:void(0)" onclick="goHome()">HOME</a></li>
		<li class="item"><a href="javascript:void(0)" onclick="goNoticeList()">공지사항</a></li>
		<li class="item"><a href="#">자유게시판</a></li>
		<li class="item"><a href="#">관리자권한</a></li>
	</ul>
	<script type="text/javascript">
		function goHome() {
			location.href = "/home.do";
		}
		function goNoticeList() {
			location.href = "/notice/list.do";
			return false;
		}
	</script>
</body>
</html>