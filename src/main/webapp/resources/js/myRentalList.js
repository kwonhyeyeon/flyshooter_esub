/**
 * 
 */

$(document).ready(function(){
	
	// 리스트 클릭시 상세페이지로 이동.
	$(".list-hover").click(function(){
		var index = $(".list-hover").index(this);
		
		$("#r_no").val($(".list-hover:eq("+index+")").attr("data-num"));
		

		$("#goDetail").attr({
			"method":"post",
			"action":"/user/rental/rentalDetail.do"
		});
			$("#goDetail").submit();
	});
	
});