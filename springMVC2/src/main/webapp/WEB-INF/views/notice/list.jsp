<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<style type="text/css">
	input {
		border: none;
		font-size: xx-large;
	}
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
		background-color: lavenderblush;
		width: 100%;
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
	    margin: 10px;
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
		<h1>공지사항 목록</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>첨부파일</th>
				</tr>
			</thead>
			<c:forEach items="${list }" var="notice" varStatus="status">
			<tbody>
				<tr>
					<td>${notice.noticeNo }</td>
					<td><a href="/notice/detail.kh?noticeNo=${notice.noticeNo }">${notice.noticeTitle }</a></td>
					<td>${notice.noticeWriter }</td>
					<td>${notice.nCreateDate }</td>
					<td>
						<c:if test="${empty notice.noticeFileName }">X</c:if>
						<c:if test="${!empty notice.noticeFileName }">O</c:if>
					</td>
				</tr>
			</tbody>
			</c:forEach>
			<tfoot>
				<tr>
					<td colspan="5">
						<input type="text" placeholder="검색어를 입력하세요">
					</td>
				</tr>
			</tfoot>
		</table>
	</main>
</body>
</html>