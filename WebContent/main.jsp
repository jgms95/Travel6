<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<title>Main</title>
<%@ include file="./com/head.jsp" %>
</head>
<body>
<%@ include file="./com/top.jsp" %>
<%@ include file="./com/navbar.jsp" %>
<div style="margin: 30px 30px 30px 30px;">
  <div class="row">
    <div class="col-sm-2">
    <h3>Welcome</h3>
      <h5>Enjoy your travel</h5>
            <img src="./img/title.jpg" alt="Card image" style="width: 100%">
      <p><strong>'Travel'에 오신 것을 환영합니다.</strong></p>
      <p>여행은 도시와 시간을 이어준다. 그러나 내게 가장 아름답고 철학적인 여행은 그렇게 머무는 사이 생겨나는 틈에 있다.</p>
      <p> - 폴 발레리</p>
      <br><br>
      <h4 style="color: rgb(3,99,135);"><strong>바로가기</strong></h4>
      <br>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">추천 여행지</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">숙박 정보</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">여행 메이트</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">맛집 정보</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">공지 사항</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${empty login.id ? 'loginui.do' : 'board6qnalist.do?id=' }${login.id }">Q&amp;A</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-5">
     <h3>추천 여행지</h3>
      <h5>Where to go</h5>
       <img src="./img/travel1.jpg" alt="Card image" style="width: 100%">

      <br><br>
      <h3>숙박 정보</h3>
      <h5>Where to stay</h5>
      <img src="./img/travel2.jpg" alt="Card image" style="width: 100%">
       <br>
         </div>
       <div class="col-sm-5">
      <h3>여행 메이트</h3>
      <h5>Whom to travel with</h5>
      <img src="./img/travel4.jpg" alt="Card image" style="width: 100%">
   
      <br><br>
      <h3>맛집 정보</h3>
      <h5>Where to eat</h5>
         <img src="./img/travel3.jpg" alt="Card image" style="width: 100%">
    
      
      
    </div>
  </div>
</div>
<%@ include file="./com/footer.jsp" %>
</body>
</html>