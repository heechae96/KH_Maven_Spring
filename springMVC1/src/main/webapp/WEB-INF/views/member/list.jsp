<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<!-- JavaScript Bundle with Popper -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<table class="table table-hover table-bordered">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>가입날짜</th>
			<th>수정날짜</th>
		</tr>
		<c:forEach items="${mList }" var="member" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="/member/detail.do?memberId=${member.memberId }">${member.memberId }</a></td>
				<td>${member.enrollDate }</td>
				<td>${member.updateDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>