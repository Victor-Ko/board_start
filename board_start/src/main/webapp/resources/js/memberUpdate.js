$(document).ready(function(){
	 $("input[name=gender]").attr("disabled", true); 
	 
	 $("#cancel").click(function(){
		 window.close();
	 });
	 
	 $("#modify").click(function(){
		 if($("#userPw").val() == ''){
				alert("비밀번호를 입력하세요");
		}else if($("#userPw").val() != $("#pwCheck").val()){
			alert("비밀번호가 일치하지않습니다");
		}else{
			modify_proc(); 
		}
	 })
});

function modify_proc(){
	var userId = $("#userId").val();
	var userAuth = $("#userAuth").val();
	var userPw = $("#userPw").val();
	var userEmail = $("#userEmail").val();
	
	var dataStr = {
			"userId" : userId,
			/*"userAuth" : userAuth,*/
			"userPw" : userPw,
			"userEmail": userEmail
	};
	
	$.ajax({
		url : contextPath+"/updateMember",
		data : dataStr,
		type : "POST",
		dataType : "json",
		success:function(jRes){
			if(jRes.success == "Y" && jRes.result == "Success") {
				window.close();
			}else {
				alert("수정 실패");
				window.close();
			}
		}
	});
}