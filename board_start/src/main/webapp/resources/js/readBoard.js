$(document).ready(function(){
	$("#insertComment").click(function(){
		insertComment();
	});
	$("#boardModify").click(function(){
		$("#boardTitle").removeAttr("readonly");
		$("#boardContents").removeAttr("readonly");
		$("#boardModify").style.display="none";
		$("#boardUpdate").style.display="inline";
	});
	$("#boardDelete").click(function(){
		boardDelete();
	});
});

function insertComment(){
	if($("#comment").val() == ''){
		alert("댓글이 입력되지않았습니다");
	}else{
		insertCommentProc();
	}
}

function insertCommentProc(){
	var seq = $("#seq").val();
	var comDetail = $("#comment").val();
	
	var dataStr = {
			"seq" : seq,
			"comDetail" : comDetail
	};
	
	$.ajax({
		url : contextPath+"/insertComment",
		data : dataStr,
		type : "POST",
		dataType : "json",
		success:function(jRes){
			if(jRes.success == "Y" && jRes.result == "1") {
				location.reload();
			}else {
				alert("댓글 추가 실패");
				location.reload();
			}
		}
	});
}

function boardDelete(){
	var seq = $("#seq").val();
	var userId = $("#userId").val();
	
	var dataStr = {
			"seq" : seq,
			"userId" : userId
	};
	
	$.ajax({
		url : contextPath+"/deleteBoard",
		data : dataStr,
		type : "POST",
		dataType : "json",
		success:function(jRes){
			if(jRes.success == "Y" && jRes.result == "1") {
				location.href = contextPath+"/boardMain";
			}else {
				alert("삭제 실패");
			}
		}
	});
}