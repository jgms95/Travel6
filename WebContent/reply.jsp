<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변하기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

	<%@ include file="./com/top.jsp"%>
	<%@ include file="./com/navbar.jsp"%>


	<div class="container" style="margin: 30px auto 30px auto;">


		<h1>답글 쓰기</h1>

		<form action="reply.do?" method="post" class="was-validated">
			<input type="hidden" name="id" value="${param.id}"> <input type="hidden" name="num" value="${param.num}">
			<div class="form-group">
				<label for="id">ID : </label> <input name="id" class="form-control" readonly value="${param.id}">
			</div>
			<div class="form-group">
			<label for="writer">작성자 : </label> <input name="writer" class="form-control" readonly value="${writer}">
			</div>
			<div class="form-group">
				<label for="title">제목 : </label> <input type="text" class="form-control" placeholder="제목을 입력하세요." name="title" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			내용 : <br>
			<textarea style="width: 100%" placeholder="내용을 입력하세요." name="content" required></textarea>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
			<br>
			<button type="submit" class="btn btn-info">답변 완료</button>
			<a class="btn btn-secondary" href="qnalist.do?id=${param.id}">목록</a>
		</form>




	</div>

	<%@ include file="./com/footer.jsp"%>
</body>
</html>