/**
 * 구장별 경기장별 대관 예약 현황
 */

$(document).ready(function(){
	
	var p_num = $(".placeName-op:selected").val();	
	var s_no = $(".s_no").val();
	
	var stadiumList =$(".empty").val();
	if(stadiumList == null) {
		$("stadiumList").html("<p class='noStadium'>경기장이 없습니다. 경기장을 등록해주세요</p>");
	}
	
//	$.ajax({
//		type : "get",
//		url : "/client/rental/rentalList.do",
//		data : {
//			p_num : p_num,
//			s_no : s_no
//		},
//		error : function() {
//			alert("시스템 오류입니다. 관리자에게 문의하세요");
//		},
//		success : function(result) {
//			
//			// 해당 영역 리로드
//			$(".stadiumList").load(window.location.href + $(".stadiumList"));
//			$(".stadiumList").html(result);
//			
//		}
//		
//	});
	
	// 구장명 값 변경 시 해당 경기장 리스트 가져오는 이벤트
	$(".placeName").on("change", function(){
		
		var p_num = $(".placeName-op:selected").val();
		
		$.ajax({
			type : "post",
			url : "/client/rental/rentalList.do",
			data : {
				p_num : p_num,
				s_no : s_no
			},
			error : function() {
				alert("시스템 오류입니다. 관리자에게 문의하세요");
			},
			success : function(result) {
				
				// 해당 영역 리로드
				$(".stadiumList").load(window.location.href + $(".stadiumList"));
				$(".stadiumList").html(result);
				
			}
			
		});
		
	});
	
});