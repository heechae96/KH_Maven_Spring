<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
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
		<h1>공지사항 수정</h1>
		<form action="/notice/modify.kh" method="post" enctype="multipart/form-data">
			<!-- 사용자에겐 안보이지만 필요한 값들 -->
			<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
			<input type="hidden" name="noticeFileName" value="${notice.noticeFileName }">
			<input type="hidden" name="noticeFilePath" value="${notice.noticeFilePath }">
			
			<label for="title">제목 : </label>
			<input type="text" id="title" name="noticeTitle" value="${notice.noticeTitle }"><br>
			<label for="writer">작성자 : </label>
			<input type="text" id="writer" name="noticeWriter" value="${notice.noticeWriter }"><br>
			<label for="content">내용 : </label>
			<textarea rows="5" cols="10" name="noticeContent" id="content">${notice.noticeContent }</textarea><br>
			<label for="file">첨부파일 : </label>
			<input type="file" id="file" name="reloadFile">${notice.noticeFileName }<br>
			<div class="d-grid gap-2 col-6 mx-auto">
  				<button class="btn btn-primary" type="submit">수정</button>
			</div>
		</form>
	</main>
</body>
</html>