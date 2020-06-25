<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<%@ include file="./com/head.jsp"%>

</head>
<body>
	<%@ include file="./com/top.jsp"%>
	<%@ include file="./com/navbar.jsp"%>

	<div class="container" style="margin: 30px 0 30px 0;">
		<h2>어서오세요!!</h2>
		<p>
			저희 Travel사이트에 가입을 위해 몇가지 입력 할 게 있습니다.
			<code>아래 빈칸을 빠짐없이 입력</code>
			해주시면 가입 할 수 있습니다.
		</p>
		
		<c:if test="${exist}">
			<div class="alert alert-warning">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Warning!</strong> 가입 불가능한 ID입니다. 다시 입력해주세요.
			</div>
		</c:if>
	

		<form action="insert.do" class="was-validated" method="post">
	
			<div class="form-group">
				<label for="id">Id:</label> <input type="text" class="form-control" id="id" placeholder="ID를 입력해주세요" name="id" required>
				<div class="valid-feedback">완료됨.</div>
				<div class="invalid-feedback">정보를 입력해주세요.</div>
			</div>
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password" class="form-control" id="pw" placeholder="Password를 입력해주세요" name="pw" required>
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
			<div class="form-group form-check">
				<label class="form-check-label"> <input class="form-check-input" type="checkbox" name="remember" required> 정보제공에 동의 합니다.

				</label>
			</div>
			<button type="submit" class="btn btn-primary">회원가입</button>
		</form>
	</div>
	<%@ include file="./com/footer.jsp"%>
</body>
</html>