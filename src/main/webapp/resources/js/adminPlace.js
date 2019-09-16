/**
 * 관리자 - 구장 관리
 */
$(document).ready(function() {
	
	// 구장 상태 변경 시 발생하는 이벤트
	$(".placeStatus").on("change", function(){
		
		$("#placeStatusForm").attr({
			"method" : "get",
			"action" : "/admin/place/placeList.do"
		});
		
		$("#placeStatusForm").submit();
		
	});
	
	// 상세페이지 링크 이동
	$(".list-hover").click(function() {
		
		var num = $(this).attr("data-num");
		$("#p_num").val(num);
		
		$("#detailForm").attr({
			"method" : "get",
			"action" : "/admin/place/placeDetail.do"
		});
		
		$("#detailForm").submit();
		
	});
	
	// 구장 승인 상태 변경 시 저장 버튼 변경
	$("#acceptSelect").on("change", function() {
		$(".save").attr("disabled", false);
		
		var accept = $("#acceptSelect option").val();
		$("#dddd").val(accept);
	});
	
	$(".save").click(function() {
		
		$("#saveForm").attr({
			"method" : "post",
			"action" : "/admin/place/updatePok.do"
		});
		
		$("#saveForm").submit();
		
	});
	
});
