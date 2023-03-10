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
	margin-right: 15px;
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
			<a href="/member/logout.kh" onclick="return check()">로그아웃</a> <a
				href="/member/myPage.kh">마이페이지</a>
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
					<th>수정</th>
				</tr>
			</thead>
			<c:forEach items="${sList }" var="notice" varStatus="status">
				<tbody>
					<tr>
						<td>${notice.noticeNo }</td>
						<td><a href="/notice/detail.kh?noticeNo=${notice.noticeNo }">${notice.noticeTitle }</a></td>
						<td>${notice.noticeWriter }</td>
						<td>${notice.nCreateDate }</td>
						<td><c:if test="${empty notice.noticeFileName }">X</c:if> <c:if
								test="${!empty notice.noticeFileName }">O</c:if></td>
						<td><c:url var="nModify" value="/notice/modify.kh">
								<c:param name="noticeNo" value="${notice.noticeNo }" />
							</c:url> <a href="${nModify }">선택</a></td>
					</tr>
				</tbody>
			</c:forEach>
			<tfoot>
				<tr>
					<form action="/notice/search.kh" method="get">
						<td>
							<select name="searchCondition">
								<option value="all"
									<c:if test="${search.searchCondition == 'all' }">selected</c:if>>
									전체</option>
								<option value="writer"
									<c:if test="${search.searchCondition == 'writer' }">selected</c:if>>
									작성자</option>
								<option value="title"
									<c:if test="${search.searchCondition == 'title' }">selected</c:if>>
									제목</option>
								<option value="content"
									<c:if test="${search.searchCondition == 'content' }">selected</c:if>>
									내용</option>
							</select>
						</td>
						<td colspan="4">
							<input type="text" name="searchValue" value="${search.searchValue }" placeholder="검색어를 입력하세요">
						</td>
						<td>
							<input type="submit" value="검색">
						</td>
					</form>
				</tr>
				<tr>
					<td colspan="6" style="text-align: center">
						<c:forEach
							begin="${pi.startNavi }" end="${pi.endNavi }" var="p">
							<c:url var="pageUrl" value="/notice/search.kh">
								<c:param name="page" value="${p }"></c:param>
								<c:param name="searchValue" value="${search.searchValue }"></c:param>
								<c:param name="searchCondition" value="${search.searchCondition }"></c:param>
							</c:url>
							<a href="${pageUrl }">
								<c:if test="${p eq pi.currentPage }">
									<b>${p }</b>
								</c:if> 
								<c:if test="${p ne pi.currentPage }">${p }</c:if>
							</a>
							<%-- <a href="/notice/list.kh?page=${p }">
								<c:if test="${p eq pi.currentPage }"><b>${p }</b></c:if>
								<c:if test="${p ne pi.currentPage }">${p }</c:if>
							</a> --%>
						</c:forEach>
					</td>
				</tr>
			</tfoot>
		</table>
	</main>
</body>
</html>