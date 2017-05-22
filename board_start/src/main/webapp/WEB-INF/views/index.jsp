<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>로그인 화면</title>
<%@include file="pathSet.jsp" %>
<script src="${resourcePath}/js/index.js"></script>
<link href="${resourcePath}/css/index.css" rel="stylesheet"> 
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
	<form onsubmit="false">
		<div class="align-center vi">
		    <div class="form-group">
              <label for="userId">아이디</label>
              <input type="text" class="form-control input-control" id="userId" placeholder="아이디">
            </div>
		    <div class="form-group">
              <label for="userPw">비밀번호</label>
              <input type="password" class="form-control input-control" id="userPw" placeholder="비밀번호">
            </div>
		    <input type="checkbox" style="margin-bottom: 30px;" id="rememberId" name="memo" checked="checked">아이디 저장
		   	<div class="form-group text-center">
              <input type="button" id="login" value="로그인" class="btn btn-warning">
              <input type="button" id="insert" value="회원가입" class="btn btn-info">
            </div>
		</div>
	</form>
</body>
</html>