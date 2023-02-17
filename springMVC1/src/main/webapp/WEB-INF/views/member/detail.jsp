<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
	<ul>
		<li>${member.memberId }</li>
		<li>${member.memberName }</li>
		<li>${member.memberEmail }</li>
		<li>${member.memberPhone }</li>
		<li>${member.memberAddr }</li>
		<li>${member.enrollDate }</li>
		<li>${member.updateDate }</li>
	</ul>
</body>
</html>