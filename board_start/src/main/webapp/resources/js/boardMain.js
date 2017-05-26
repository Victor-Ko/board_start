$(document).ready(function(){
	var popWidth = 700;
	var popHeight = 500;
	
	var popupX = (window.screen.width / 2) - (popWidth / 2);
	// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height /2) - (popHeight / 2);
	// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
	
	$("#logout").click(function(){
		logout();
	});
	$("#memberModify").click(function(){
		window.open("memberUpdate",'window',  'status=no, height='+popHeight+'px, width='+popWidth+'px, left='+ popupX + ', top='+ popupY + 
				', screenX='+ popupX + ', screenY= '+ popupY);
		wrapWindowByMask();
	});
	$("#read").click(function() {
		readBoard();
	});
	$("#writeBoard").click(function() {
		window.open("boardInsert",'window',  'status=no, height='+popHeight+'px, width='+popWidth+'px, left='+ popupX + ', top='+ popupY + 
				', screenX='+ popupX + ', screenY= '+ popupY);
		wrapWindowByMask();
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
function wrapWindowByMask(){
	//화면의 높이와 너비를 구한다.
	var maskHeight = $(document).height();  
	var maskWidth = $(window).width();  

	//마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
	$('#mask').css({'width':maskWidth,'height':maskHeight, 'z-index':9000});  

	//애니메이션 효과 - 일단 1초동안 까맣게 됐다가 80% 불투명도로 간다.
	$('#mask').fadeIn(300);      
	$('#mask').fadeTo("slow",0.6);
}