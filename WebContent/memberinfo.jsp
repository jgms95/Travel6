<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 정보</title>
<%@ include file="./com/head.jsp"%>
</head>
<body>
	<%@ include file="./com/top.jsp"%>
	<%@ include file="./com/navbar.jsp"%>

	<div class="container" style="margin: 30px 0 30px 0;">
		<h2>${dto.id }님의 회원 정보</h2>
		<p>이곳에서 회원 정보 수정, 탈퇴등을 할수 있습니다.</p>
		<div class="card" style="width: 400px">
			<img class="card-img-top" src="./img/img_avatar1.png" alt="Card image" style="width: 100%">
			<div class="card-body">
				<h4 class="card-title">${dto.id }</h4>
				<p class="card-text">${dto.name }님은 현재${dto.age }세 입니다.</p>
				<a href="updateui.do?id=${dto.id }" class="btn btn-primary">수정</a>

				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteModel">탈퇴</button>
				<div class="modal fade" id="deleteModel">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">

							<div class="modal-header">
								<h4 class="modal-title">'${dto.id}' 님 탈퇴</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<div class="modal-body">정말 탈퇴하시겠습니까?</div>

							<div class="modal-footer">
								<a class="btn btn-info" href="delete.do?id=${dto.id }">예</a>
								<button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>
							</div>

						</div>
					</div>
				</div>



			</div>
		</div>
	</div>
	<%@ include file="./com/footer.jsp"%>
</body>
</html>