/**
 * 관리자 - 구장 관리
 */
$(document).ready(function() {
	
	// 구장 상태 변경 시 리스트 재출력
	$(".placeStatus").on("change", function(){
		
		$("#placeStatusForm").attr({
			"method" : "get",
			"action" : "/admin/place/placeList.do"
		});
		
		$("#placeStatusForm").submit();
				
	});
	
});
 