<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fm"%>

<!DOCTYPE html>
<html>
<head>
<title>Q&amp;A</title>
<meta charset="utf-8">
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
		<h1>Q&amp;A</h1>
		<p>
			<strong>회원 전용</strong> Q&amp;A 게시판입니다. 궁금하신 사항은 '<strong>질문하기</strong>'로 문의해주세요.
		</p>


		<div class="dropdown">
			<button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown">나의 Q&amp;A</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="asklist.do?id=${param.id}">나의 질문 목록</a>
				 <div class="dropdown-divider"></div>
				<a class="dropdown-item" href="replylist.do?id=${param.id}">나의 답변 목록</a>
			</div>
		</div>
		<br> 

		<table class="table table-hover">

			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td width="300px">

							<c:forEach begin="1" end="${dto.repIndent}">&nbsp;&nbsp;</c:forEach>
							<a style="color: rgb(34,141,168);" href="read.do?num=${dto.num}&id=${param.id}"><strong>${dto.title}</strong></a>

						</td>

						<td>${dto.writer}</td>
						<td>${dto.writeday}</td>
						<td>${dto.readcnt}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>






		<ul class="pagination justify-content-center">
			<li class="page-item ${to.curPage eq 1 ? 'disabled' : '' }"><a class="page-link"
					href="qnalist.do?curPage=${to.curPage ne 1 ? (to.curPage - 1) : 1 }&id=${param.id}">Previous</a></li>
			<c:forEach begin="${to.beginPageNum }" end="${to.stopPageNum }" var="idx">
				<li class="page-item ${idx eq to.curPage ? 'active' : '' }"><a class="page-link" href="qnalist.do?curPage=${idx }&id=${param.id}">${idx }</a></li>
			</c:forEach>
			<li class="page-item ${to.curPage eq to.totalPage ? 'disabled' : '' }"><a class="page-link"
					href="qnalist.do?curPage=${to.curPage ne to.totalPage ? to.curPage + 1 : to.totalPage }&id=${param.id}">Next</a></li>
		</ul>


		<a style="position: relative; left: 90%" href="askui.do?id=${param.id}&writer=${writer}" class="btn btn-info">
			<strong>질문하기</strong>
		</a>





	</div>


	<%@ include file="./com/footer.jsp"%>
</body>
</html>