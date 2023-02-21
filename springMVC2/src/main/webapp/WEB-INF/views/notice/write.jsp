<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
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
		<h1>공지글 쓰기</h1>
		<form action="/notice/write.kh" method="post" enctype="multipart/form-data">
			<label for="title">제목 : </label><input type="text" id="title" name="noticeTitle"><br>
			<label for="writer">작성자 : </label><input type="text" id="writer" name="noticeWriter"><br>
			<label for="content">내용 : </label><textarea id="content" name="noticeContent"></textarea><br>
			<label for="file">첨부파일 : </label><input type="file" id="file" name="uploadFile"><br>
			<div>
				<input type="submit" value="완료">
				<input type="reset" value="취소">
			</div>
		</form>
	</main>
</body>
</html>