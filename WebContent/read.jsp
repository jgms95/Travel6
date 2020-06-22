<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.title}</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<script>
	function onDownload(num) {

		var o = document.getElementById("ifrm_filedown");

		o.src = "download.do?num=" + num;

	}
</script>

<body>
	<%@ include file="./com/top.jsp"%>
	<%@ include file="./com/navbar.jsp"%>
	<iframe id="ifrm_filedown" style="position: absolute; z-index: 1; visibility: hidden;"></iframe>



	<div class="container" style="margin: 30px auto 30px auto;">


		<h2 style="background-color: rgb(55, 55, 55); color: white;">${dto.title}</h2>
		<p>글번호: ${dto.num}&nbsp;&nbsp;&nbsp;조회수: ${dto.readcnt}</p>

		<div class="jumbotron" style="background-color: rgb(128, 128, 191); color: white;">


			<h5>
				<strong>작성자 :</strong> ${dto.writer}
			</h5>
			<h5>
				<strong>질문 내용 :</strong>
			</h5>
			<h6>${dto.content}</h6>


			<c:set var="fileName" value = "${dto.filename}"/>
			<%
				String file = (String)pageContext.getAttribute("fileName");
				String filePath = "upload/" + file;
				int pos = filePath.lastIndexOf(".");
				String fileExt = filePath.substring(pos + 1);
				fileExt = fileExt.toLowerCase();
				request.setAttribute("fileExt", fileExt);
				request.setAttribute("jpg", "jpg");
				request.setAttribute("jpeg", "jpeg");
				request.setAttribute("png", "png");
			%>

			<c:if test="${fileExt eq jpg or jpeg or png}">
				<img alt="${dto.filename}" src="upload/${dto.filename}" class="img-thumbnail">
			</c:if>





			<h5>
				<a style="color: white;" href="#" onclick="onDownload('${dto.num}')">
					<strong>파일 :</strong> ${dto.filename}
				</a>
			</h5>



		</div>
		<br>


		<c:choose>

			<c:when test="${dto.id eq param.id}">
				<a class="btn btn-warning" href="qnaUpdateui.do?num=${dto.num}&id=${param.id}&writer=${dto.writer}">수정</a>
		|
		<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">삭제</button>
				<div class="modal fade" id="myModal">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">

							<div class="modal-header">
								<h4 class="modal-title">'${dto.title}' 글 삭제</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<div class="modal-body">정말 삭제하시겠습니까?</div>

							<div class="modal-footer">
								<a class="btn btn-info" href="qnaDelete.do?num=${dto.num}&id=${param.id}">예</a>
								<button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>
							</div>

						</div>
					</div>
				</div>

		|
		<a class="btn btn-secondary" href="qnalist.do?id=${param.id}">목록</a>

			</c:when>
			<c:otherwise>
				<a class="btn btn-secondary" href="replyui.do?num=${dto.num}&id=${param.id}">답변쓰기</a>
		|
		<a class="btn btn-secondary" href="qnalist.do?id=${param.id}">목록</a>
			</c:otherwise>
		</c:choose>








		<br> <br>
		<hr>
		<h5>
			<strong> 댓글 남기기</strong>
		</h5>
		<form action="insertQnaComment.do" method="post" class="was-validated">
			<input type="hidden" name="id" value="${param.id}"> <input type="hidden" name="num" value="${dto.num}"> <input type="hidden"
				name="writer" value="${writer}">


			<div class="form-group">
				<label for="title">내용 : </label> <input type="text" class="form-control" placeholder="내용을 입력하세요." name="content" required>
				<div class="valid-feedback">입력 완료</div>
				<div class="invalid-feedback">정보를 입력해주세요.</div>
			</div>
			<button type="submit" class="btn btn-warning">작성완료</button>
		</form>
		<hr>

		<br>




		<h5>
			<strong>댓글 목록</strong>
		</h5>
		<c:forEach items="${commentlist}" var="commentdto">

			<c:if test="${commentdto.repIndent>0}">
				<h4>
					<span class="badge badge-info ">Re: ${commentdto.orgWriter} </span>
				</h4>
			</c:if>


			<div class="media border p-3">

				<div class="media-body">
					<h4>${commentdto.writer}
						<small><i>${commentdto.writeday}</i></small>
					</h4>
					<p>${commentdto.content}</p>
				</div>
			</div>



			<br>
			<c:choose>
				<c:when test="${commentdto.id eq param.id}">




					<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#myModalupdate${commentdto.num}">수정</button>
					<div class="modal fade" id="myModalupdate${commentdto.num}">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">댓글 수정</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<form action="updateComment.do" method="post" class="was-validated">

									<input type="hidden" name="id" value="${param.id}"> <input type="hidden" name="num" value="${commentdto.num}"> <input
										type="hidden" name="qnanum" value="${commentdto.qnanum}"> <input type="hidden" name="writer" value="${writer}">
									<div class="modal-body">

										<div class="form-group">
											<label for="content">내용 : </label> <input type="text" class="form-control" placeholder="내용을 입력하세요." name="content" required>
											<div class="valid-feedback">입력 완료</div>
											<div class="invalid-feedback">정보를 입력해주세요.</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-info">수정 완료</button>
										<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
									</div>
								</form>
							</div>
						</div>
					</div>







					<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#myModaldelete${commentdto.num}">삭제</button>
					<div class="modal fade" id="myModaldelete${commentdto.num}">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">댓글 삭제</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<form action="deleteComment.do" method="post" class="was-validated">

									<input type="hidden" name="id" value="${param.id}"> <input type="hidden" name="num" value="${commentdto.num}"> <input
										type="hidden" name="qnanum" value="${commentdto.qnanum}"> <input type="hidden" name="repIndent" value="${commentdto.repIndent}">
									<input type="hidden" name="repRoot" value="${commentdto.repRoot}">
									<div class="modal-body">정말 삭제하시겠습니까?</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-info">예</button>
										<button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>
									</div>
								</form>
							</div>
						</div>

					</div>

				</c:when>

				<c:otherwise>








					<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#myModal${commentdto.num}">답변 달기</button>
					<div class="modal fade" id="myModal${commentdto.num}">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">답변 달기</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>

								<form action="replyComment.do" method="post" class="was-validated">

									<input type="hidden" name="id" value="${param.id}"> <input type="hidden" name="num" value="${commentdto.num}"> <input
										type="hidden" name="qnanum" value="${commentdto.qnanum}"> <input type="hidden" name="writer" value="${writer}"> <input
										type="hidden" name="orgWriter" value="${commentdto.writer}">
									<div class="modal-body">


										<div class="form-group">
											<label for="content">내용 : </label> <input type="text" class="form-control" placeholder="내용을 입력하세요." name="content" required>
											<div class="valid-feedback">입력 완료</div>
											<div class="invalid-feedback">정보를 입력해주세요.</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-info">작성완료</button>
										<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
									</div>

								</form>

							</div>
						</div>
					</div>




				</c:otherwise>

			</c:choose>

			<hr>

		</c:forEach>



	</div>


















	<%@ include file="./com/footer.jsp"%>
</body>
</html>