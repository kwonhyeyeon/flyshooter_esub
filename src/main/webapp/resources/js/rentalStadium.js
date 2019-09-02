/**
 * 
 */
$(document).ready(function(){
	
	
$("#datepicker").datepicker({
	               dateFormat : 'yy-mm-dd',
	               prevText : '이전 달',
	               nextText : '다음 달',
	               showOtherMonths : true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	               ,
	               showMonthAfterYear : true//년도 먼저 나오고, 뒤에 월 표시
	               ,
	               monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7', '8',
	                     '9', '10', '11', '12' ] //달력의 월 부분 텍스트
	               ,
	               monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
	                     '8월', '9월', '10월', '11월', '12월' ] //달력의 월 부분 Tooltip 텍스트
	               ,
	               dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] //달력의 요일 부분 텍스트
	               ,
	               dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일',
	                     '토요일' ] //달력의 요일 부분 Tooltip 텍스트
					,
					beforeShowDay : disableSomeDay, minDate: 0 , beforeShowDay : noSundays
	              	});
					
					// 제외할 날짜
					var disabledDays = ["2019-9-3", "2019-9-15"];
					// 날짜를 나타내기 전에(beforeShowDay) 실행할 함수
					function disableSomeDay(date){
						var month = date.getMonth();
						var dates = date.getDate();
						var year = date.getFullYear();
						
						// 배열에 해당하는 날짜는 0번째 index에 false를 담아 리턴해준다.
						for(i = 0; i < disabledDays.length; i++){
							if($.inArray( year + '-' + ( month + 1 ) + '-' + dates, disabledDays ) != -1){
								return [false];
							}
						}
						
						// 해당하지 않은 날짜는 주말이 아닌 경우에만 표시한다.
						var noWeekend = jQuery.datepicker.noWeekends(date);
						return noWeekend[1] ? [true] : [true];
					}
					
					// 특정요일 선택불가로 막기 0-일요일, 1-월요일, 2-화요일, 3-수요일
					function noSundays(date){
						return [date.getDay() != 0, ''];
					}
					
});