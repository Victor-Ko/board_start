<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 읽기</title>
<%@include file="../pathSet.jsp" %>
<script src="${resourcePath}/js/readBoard.js"></script>
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
          <h1>게시글 읽기<small>Read Board</small></h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
            <div class="form-group">
              	<label for="boardTitle">글 제목</label>
              	<input type="text" class="form-control" id="boardTitle" readonly="readonly" value="${board[0].boardTitle}">
            </div>
         
            <div class="form-group">
              	<label for="boardContents">글 내용</label>
              	<input type="text" class="form-control" id="boardContents" style="height: 150px;" readonly="readonly" value="${board[0].boardContents}">
            </div>
           
            <div class="form-group">
		    	<label for="file">파일 첨부</label>
		    	<input type="file" id="file">
		    	<!-- <p class="help-block">Example block-level help text here.</p> -->
		  	</div>
           
           	<table class=".table-striped .table-bordered" style="width: 100%; margin-left: auto; margin-right: auto;" border="1">
				<tbody>
				<c:choose>
		            <c:when test="${fn:length(comment) > 0}">
		                <c:forEach items="${comment}" var="comment">
							<tr>
								<td>${comment.userId}</td>
								<td>${comment.comRegDate}</td>
								<td>${comment.comDetail}</td>
							</tr>
						</c:forEach>
		            </c:when>
		            <c:otherwise>
		                <tr>
		                    <td colspan="3">조회된 댓글이 없습니다.</td>
		                </tr>
		            </c:otherwise>
	        	</c:choose>
				</tbody>
			</table>
        	<br><br>
        	<div class="form-group">
        		<input type="text" class="form-control" id="comment" placeholder="댓글 입력">
        		<br>
        		<input type="button" id = "insertComment" class="btn btn-info" value="댓글 작성">
        	</div>
        
        	<div class="form-group text-center">
	            <input type="button" id = "boardModify" class="btn btn-info" value="글 수정">
	            <input type="button" id = "boardUpdate" class="btn btn-info" value="수정 완료" style="display: none;">
	            <input type="button" id = "boardDelete" class="btn btn-warning" value="작성 삭제">
            </div>
            
            <input type="hidden" id="seq" value="${board[0].boardSeq}">
            <input type="hidden" id="userId" value="${board[0].userId}">
        </div>
      </article>
</body>
</html>