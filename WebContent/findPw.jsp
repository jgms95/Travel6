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
<%@ include file="./com/head.jsp"%>
</head>
<body>
<%@ include file="./com/top.jsp"%>
	<%@ include file="./com/navbar.jsp"%>

	<div class="container" style="margin: 30px 0 30px 0;">
		<h2>비밀번호 찾기</h2>
	<c:if test="${noInfo}">
			<div class="alert alert-warning">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Warning!</strong> 입력하신 정보와 맞는 비밀번호가 없습니다. 다시 입력해주세요.
			</div>
		</c:if>
		<form action="findPw.do" class="was-validated" method="post">
		<div class="form-group">
				<label for="id">Id:</label> <input type="text" class="form-control" id="id" placeholder="ID를 입력해주세요" name="id" required>
				<div class="valid-feedback">완료됨.</div>
				<div class="invalid-feedback">정보를 입력해주세요.</div>
			</div>
			<div class="form-group">
				<label for="name">Name:</label> <input type="text" class="form-control" id="name" placeholder="이름을 입력해주세요" name="name" required>
				<div class="valid-feedback">완료됨.</div>
				<div class="invalid-feedback">정보를 입력해주세요.</div>
			</div>
			<div class="form-group">
				<label for="age">Age:</label> <input type="text" class="form-control" id="age" placeholder="나이를 입력해주세요" name="age" required>
				<div class="valid-feedback">완료됨.</div>
				<div class="invalid-feedback">정보를 입력해주세요.</div>
			</div>
			<button type="submit" class="btn btn-primary">비밀번호 찾기</button>
			<a href="main.jsp" class="btn btn-primary">메인 화면으로 가기</a>
		</form>
	</div>
	<%@ include file="./com/footer.jsp" %>


</body>
</html>