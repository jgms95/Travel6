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
      <h5>Title description, Sep 2, 2017</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
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
          <a class="nav-link" href="${empty login.id ? 'loginui.do' : 'qnalist.do?id=' }${login.id }">Q&amp;A</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-5">
     <h3>추천 여행지</h3>
      <h5>Where to go: </h5>
       <img src="./img/travel1.jpg" alt="Card image" style="width: 100%">
      <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
      <br>
      <h3>숙박 정보</h3>
      <h5>Where to stay</h5>
      <img src="./img/travel2.jpg" alt="Card image" style="width: 100%">
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
      <br>
         </div>
       <div class="col-sm-5">
      <h3>여행 메이트</h3>
      <h5>Whom to travel with</h5>
      <img src="./img/travel4.jpg" alt="Card image" style="width: 100%">
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
      <br>
      <h3>맛집 정보</h3>
      <h5>Title description, Sep 2, 2017</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
 
      
    </div>
  </div>
</div>
<%@ include file="./com/footer.jsp" %>
</body>
</html>