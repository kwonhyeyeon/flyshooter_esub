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
	
	// 구장 상세페이지 링크 이동
	$("#placeDetail").click(function() {
		
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
		
		var accept = $("#acceptSelect").val();
		$("#ok").val(accept);
	});
	
	$("button.save").click(function() {
		
		$("#saveForm").attr({
			"method" : "post",
			"action" : "/admin/place/updatePok.do"
		});
		
		$("#saveForm").submit();
		
	});
	
	// 폐업 등록 버튼 클릭 시 이벤트
	$(".delete").click(function() {
		
		var result = confirm("폐업 등록을 하시겠습니까?\n변경 시 수정이 불가합니다");
		
		if(result) {
			$("#closeForm").attr({
				"method" : "post",
				"action" : "/admin/place/updateClose.do"
			});
			
			$("#closeForm").submit();
		}
		
	});
	
	// 경기장 상세 페이지로 이동
	$("#stadiumDetail").click(function() {
		
		$("#stdmDetailForm").attr({
			"method" : "post",
			"action" : "/admin/stadium/stadiumDetail.do"
		});
		
		$("#stdmDetailForm").submit();
				
	});
	
});
