$(document).ready(function(){
	$("#boardInsert").click(function(){
		insertCheck();
	});
	$("#cancel").click(function(){
		$("#mask",opener.document).hide();
		window.close();
	});
});

function insertCheck(){
	if($("#boardTitle").val() == ''){
		alert("제목을 입력하세요");
		$("#boardTitle").focus();
	}else if($("#boardContents").val() == ''){
		alert("내용을 입력하세요");
		$("#boardContents").focus();
	}else{
		insertProc();
	}
}
function insertProc(){
	var boardTitle = $("#boardTitle").val();
	var boardContents = $("#boardContents").val();
	
	var dataStr = {
			"boardTitle" : boardTitle,
			"boardContents" : boardContents
	};
	
	$.ajax({
		url : contextPath+"/insertBoard",
		data : dataStr,
		type : "POST",
		dataType : "json",
		success:function(jRes){
			if(jRes.success == "Y" && jRes.result == "Success") {
				alert("작성 성공");
				window.close();
				$("#mask",opener.document).hide();
			}else {
				alert("작성 실패");
				window.close();
				$("#mask",opener.document).hide();
			}
		}
	});
}