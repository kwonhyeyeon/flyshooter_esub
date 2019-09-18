/**
 * 구장별 경기장별 대관 예약 현황
 */

$(document).ready(function(){
	
	var p_num = $(".placeName-op:selected").val();	
	var s_no = $(".s_no").val();
	
	// datepicker 설정
    $("#datepicker").datepicker({
        dateFormat: 'yy-mm-dd' // Input Display Format 변경
        ,showOtherMonths : true // 빈 공간에 현재 월의 앞뒤 월의 날짜를 표시
        ,showMonthAfterYear : true // 년도 먼저 나오고, 뒤에 월 표시
        ,changeYear: true // 콤보박스에서 년 선택 가능
        ,changeMonth: true // 콤보박스에서 월 선택 가능                
        ,showOn: "both" // button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고 버튼을 누르거나 input을 클릭하면 달력 표시  
        ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" // 버튼 이미지 경로
        ,buttonImageOnly: true // 기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
        ,buttonText: "선택" // 버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
        ,yearSuffix: "년" // 달력의 년도 부분 뒤에 붙는 텍스트
        ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] // 달력의 월 부분 텍스트
        ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] // 달력의 월 부분 Tooltip 텍스트
        ,dayNamesMin: ['일','월','화','수','목','금','토'] // 달력의 요일 부분 텍스트
        ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] // 달력의 요일 부분 Tooltip 텍스트
        ,maxDate: "+1M" // 최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
    });                    
    
    // 초기값을 오늘 날짜로 설정
	$("#datepicker").datepicker("setDate", "today");
	//(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
	
	// datepicker 값 변경 시 해당 경기장 예약 리스트 가져오는 이벤트
//	$("#datepicker").on("change", function() {
//		
//		var r_reserve_date = $("#datepicker").val(); // 선택 날짜
//		
//		var query = {
//			p_num : p_num,
//			s_no : s_no,
//			r_reserve_date : r_reserve_date
//		};
//		
//		$.ajax({
//			type : "get",
//			url : "/client/rental/rentalList.do",
//			data : query,
//			error : function() {
//				alert("시스템 오류입니다. 관리자에게 문의하세요");
//			},
//			success : function(result) {
//				
//				
//				
//			}			
//		});
//		
//	});
	
	// 구장명 값 변경 시 해당 경기장 리스트 가져오는 이벤트
	$(".placeName").on("change", function(){
		
		var p_num = $(".placeName-op:selected").val(); // 구장명
		var s_no = $(".s_no").val(); // 경기장 일련번호
		
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