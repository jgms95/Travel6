<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fm" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<%@ include file="../com/head.jsp"%>
</head>
<body>
<%@ include file="../com/top.jsp"%>
	<%@ include file="../com/navbar.jsp"%>
<div class="container" style="margin: 30px 0 30px 0;">
		<h2>${dto.id}님(${dto.name}, ${dto.age}세)의 비밀번호 정보</h2>
		<div class="card" style="width: 400px">
			<img class="card-img-top" src="./img/img_avatar1.png" alt="Card image" style="width: 100%">
			<div class="card-body">
				<h4 class="card-title">${dto.id}님의 비밀번호 : ${dto.pw}</h4>
				<h4 class="card-title">${dto.id }님 계정의 상태 : ${meaning}</h4>
				<a href="loginui.do?" class="btn btn-primary">로그인하기</a>
		</div>
	</div>
	</div>
	<%@ include file="../com/footer.jsp"%>
</body>
</html>