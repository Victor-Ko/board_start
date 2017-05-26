$(document).ready(function() {
	$("#userId").get(0).focus();
	
	var cookieUserId  = getLogin("userId");
	var cookieRememberId = getLogin("rememberId");
	
	if (cookieUserId != "") {
		$("#userId").val(cookieUserId);
	}

	if (cookieRememberId != "") {
		$("#rememberId").attr("checked", "checked");
	}
	
	if ($("#userId").val().length > 0) $("#userPw").get(0).focus();
	
	$("#login").click(function() {
		 login_check();
	});

	$("#insert").click(function() {
		var popWidth = 700;
		var popHeight = 500;
		
		var popupX = (window.screen.width / 2) - (popWidth / 2);
		// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

		var popupY= (window.screen.height /2) - (popHeight / 2);
		// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

		window.open("memberInsert",'window',  'status=no, height='+popHeight+'px, width='+popWidth+'px, left='+ popupX + ', top='+ popupY + 
				', screenX='+ popupX + ', screenY= '+ popupY);
	});
});

//로그인 창 접속 시 쿠키에 데이터 있는 지 확인
function getLogin(cookie_name) {
	var cook = document.cookie + ";";
	var idx = cook.indexOf(cookie_name, 0);
	var val = "";

	if(idx != -1) {
		cook = cook.substring(idx, cook.length);
		begin = cook.indexOf("=", 0) + 1;
		end = cook.indexOf(";", begin);
		val = unescape(cook.substring(begin, end));
	}
	return val;
}

function login_check(){
	if($("#userId").val() == ""){
		alert("아이디를 입력하세요");
		$("#userId").focus();
	}else if ($("#userPw").val() == "") {
		alert("비밀번호를 입력하세요");
		$("#userPw").focus();
	}else {
		// 입력 받은 데이터로 DB 조회
		login_proc();
	}
}

function login_proc(){
	var userId = $("#userId").val();
	var userPw = $("#userPw").val();
	
	var dataStr = {
		"userId" : userId,
		"userPw" : userPw,
		"rememberId": $("#rememberId").val()
	};
	
	$.ajax({
		url : contextPath+"/login/loginChk.do",
		data : dataStr,
		type : "POST",
		dataType : "json",
		success:function(jRes){
			if(jRes.success == "Y" && jRes.result == "1") {
				// DB에서 가져온 메인 페이지 경로
				var mainPath = jRes.resData.mainPath;
				// 메인 페이지 이동
				location.href = contextPath+mainPath;
			}else {
				alert("로그인실패");
				$("#userPw").val("");
			}
		}
	});
}