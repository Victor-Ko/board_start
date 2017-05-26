$(document).ready(function(){
	$("#logout").click(function(){
		logout();
	});
	$("#memberModify").click(function(){
		var popWidth = 700;
		var popHeight = 500;
		
		var popupX = (window.screen.width / 2) - (popWidth / 2);
		// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

		var popupY= (window.screen.height /2) - (popHeight / 2);
		// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

		window.open("memberUpdate",'window',  'status=no, height='+popHeight+'px, width='+popWidth+'px, left='+ popupX + ', top='+ popupY + 
				', screenX='+ popupX + ', screenY= '+ popupY);
	});
	$("#read").click(function() {
		readBoard();
	});
	$("#writeBoard").click(function() {
		location.href = contextPath+"/boardInsert";
	});
});

function logout(){
	$.ajax({
		url : contextPath+"/logout",
		success:function(jRes){
			location.href = contextPath+"/";
		}
	});
}
function readBoard() {
	var boardSeq = $("#seq").val();
	
	$.ajax({
		url : contextPath+"/boardSelect",
		data : boardSeq,
		type : "POST",
		dataType : "json"
	});
}