$(document).ready(function() {
	$("#join").click(function(){
		join_check();
	});
	$("#cancel").click(function(){
		window.close();
	});
});

function join_check(){
	if($("#userId").val() == ''){
		alert("아이디를 입력하세요");
	}else if($("#userPw").val() == ''){
		alert("비밀번호를 입력하세요");
	}else if($("#userName").val() == ''){
		alert("이름을 입력하세요");
	}else if($("#userBirth").val() == ''){
		alert("생일 입력하세요");
	}else if($("#userEmail").val() == ''){
		alert("이메일 입력하세요");
	}else if($("#userPw").val() != $("#pwCheck").val()){
		alert("비밀번호가 일치하지않습니다");
	}else if($("#userBirth").val().length > 8){
		alert("생일이 너무 깁니다");
	}
	else{
		join_proc();
	}
}

function join_proc(){
	var userId = $("#userId").val();
	var userPw = $("#userPw").val();
	var userFirstName = $("#userName").val().substr(1,2);
	var userLastName = $("#userName").val().substr(0,1);
	var userGender = $(':input:radio[name="gender"]:checked').val();
	var userBirth = $("#userBirth").val();
	var userEmail = $("#userEmail").val();
	
	var dataStr = {
			"userId" : userId,
			"userPw" : userPw,
			"userFirstName" : userFirstName,
			"userLastName" : userLastName,
			"userGender" : userGender,
			"userBirth" : userBirth,
			"userEmail" : userEmail
	};
	
	$.ajax({
		url : contextPath+"/insertMember",
		data : dataStr,
		type : "POST",
		dataType : "json",
		success:function(jRes){
			if(jRes.success == "Y" && jRes.result == "1") {
				window.close();
			}else if(jRes.success == 'N' && jRes.result == "NOTHING"){
				alert("가입 실패");
			}
		}
	});
}