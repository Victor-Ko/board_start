<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<%@include file="pathSet.jsp" %>
<script src="${resourcePath}/js/boardMain.js"></script>
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
<style type="text/css">
	th{
		text-align: center;
	}
	td{
		text-align: center;
	}
	#writeBoard{
		float: right; 
		margin-right: 100px;
	}
	#mask {  
	  position:absolute;  
	  z-index:9999;  
	  background-color:#000;  
	  display:none;  
	  left:0;
	  top:0;
	}
</style>
</head>
<body>
	<div id="mask"></div>
	<div class="row" style="background: skyblue; text-align: center;">
	 	<div class="col-sm-5" style="border-right: solid 1px; margin-top: 5px">게시판</div>
	 	<div class="col-sm-4" style="border-right: solid 1px; margin-top: 5px">${memberInfo.getUserLastName()}${memberInfo.getUserFirstName()}님 환영합니다</div>
	 	<div class="col-sm-3">
	 		<input type="button" id="memberModify" class="btn btn-info" value="회원정보 수정">
	 		<input type="button" id="logout" class="btn btn-warning" value="로그아웃">
	 	</div>
	</div>
	<table class=".table-striped .table-bordered" style="width: 90%; margin-left: auto; margin-right: auto;" border="1">
			<thead>
				<tr>
					<th style="width: 10%">글 번호</th>
					<th style="width: 50%">제목</th>
					<th style="width: 10%">작성자</th>
					<th style="width: 20%">작성일</th>
					<th style="width: 10%">조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
	            <c:when test="${fn:length(board) > 0}">
	                <c:forEach items="${board}" var="board">
						<tr>
							<td>${board.boardSeq}</td>
							<td>
								<a href="#this" id="read"> ${board.boardTitle}</a>
								<input type="hidden" id="seq" value="${board.boardSeq}">
							</td>
							<td>${board.userId}</td>
							<td>${board.boardRegDate}</td>
							<td>${board.boardViews}</td>
						</tr>
					</c:forEach>
	            </c:when>
	            <c:otherwise>
	                <tr>
	                    <td colspan="5">조회된 결과가 없습니다.</td>
	                </tr>
	            </c:otherwise>
        	</c:choose>
			</tbody>
	</table>
	<div class="col-sm-12">
	 		<input type="button" id="writeBoard" class="btn btn-info" value="글쓰기">
	</div>
</body>
</html>