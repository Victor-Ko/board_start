<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원가입</title>
<%@include file="../pathSet.jsp" %>
<script src="${resourcePath}/js/memberInsert.js"></script>
<!-- Bootstrap -->
    <link href="${resourcePath}/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="${resourcePath}/css/bootstrap/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="${resourcePath}/css/bootstrap/style.css" media="screen" title="no title" charset="utf-8">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
 <body>
      <article class="container">
        <div class="page-header">
          <h1>회원가입 <small>Sign up</small></h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
            <div class="form-group">
              <label for="userId">아이디</label>
              <input type="text" class="form-control" id="userId" placeholder="아이디">
            </div>
         
            <div class="form-group">
              <label for="userPw">비밀번호</label>
              <input type="password" class="form-control" id="userPw" placeholder="비밀번호">
            </div>
         
            <div class="form-group">
              <label for="pwCheck">비밀번호 확인</label>
              <input type="password" class="form-control" id="pwCheck" placeholder="비밀번호 확인">
              <p class="help-block" id="pwAlert">비밀번호 확인을 위해 다시 한번 입력 해 주세요</p>
            </div>
            
            <div class="form-group">
              <label for="userName">이름</label>
              <input type="text" class="form-control" id="userName" placeholder="이름을 입력해 주세요">
            </div>
            
            <div class="form-group">
            	<label for="gender">성별</label>
            	<input id="gender" type="radio" name="gender" value="m" style="margin-left: 30px;" checked="checked">남
        		<input id="gender" type="radio" name="gender" value="w" style="margin-left: 30px;">여
            </div>
                     
         	<div class="form-group">
              <label for="birth">생년월일</label>
              <input type="text" class="form-control" id="userBirth" placeholder="생년월일을 입력해 주세요(ex : 19010101)">
            </div>

            <div class="form-group">
              <label for="Email">이메일 주소</label>
              <input type="text" class="form-control" id="userEmail" placeholder="이메일 주소를 입력해 주세요">
            </div>
         
            <div class="form-group text-center">
              <input type="button" id = "join" class="btn btn-info" value="회원가입">
              <input type="button" id = "cancel" class="btn btn-warning" value="가입취소">
            </div>
        </div>
      </article>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>