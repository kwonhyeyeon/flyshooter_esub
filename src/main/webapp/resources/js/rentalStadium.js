/**
 * 
 */
$(document).ready(function(){
	var h_start = $('#holiday_start').val();
	var h_end = $('#holiday_end').val();
	var p_holiday = $('#holiday').val();
	var arr = holiDay();
	
				$("#datepicker").datepicker({
	               dateFormat : 'yy-mm-dd',
	               prevText : '이전 달',
	               nextText : '다음 달',
	               showOtherMonths : false //빈 공간에 현재월의 앞뒤월의 날짜를 표시
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
					minDate : 1
					,
					maxDate : "+1M"
					,
					constrainInput : false
					,
					beforeShowDay : disableSomeDay
					
					
				});		
					
				// 휴업시작일과 영업재개일 사이 기간을(Date) 구하여 리턴함.
				function dayCount(){
					
					var cnt = dateSplit(h_end, -1).getTime() - dateSplit(h_start, -1).getTime();
					
					return Math.floor(cnt / (24 * 60 * 60 * 1000));
				}
				
				// 휴업시작일부터 영업재개일동안의 1일단위 날짜 구하여 배열로 리턴
				function holiDay(){
					var arr = [];
					for(var i = 0; i < dayCount(); i++){
						arr[i] = dateSplit(h_start, i);
					}
					return arr;
				}
				

				//날짜를 나타내기 전에(beforeShowDay) 실행할 함수
				function disableSomeDay(date){
					var month = date.getMonth();
					var dates = date.getDate();
					var year = date.getFullYear();
					
					// 배열에 해당하는 날짜는 0번째 index에 false를 담아 리턴해준다.
					for(i = 0; i < arr.length; i++){
						if( ($.inArray( year + '-' + ( month + 1 ) + '-' + dates, arr ) != -1) ){
							return [false];
						}
					}
					
					return [date.getDay() != p_holiday, ''];
				}
				
				
				function dateSplit(arg, type){
					var param = arg.split('-');
					if( type == -1 ){
					return new Date( param[0], eval(param[1]-1), param[2] );
				}
					var argu = new Date( param[0], param[1], param[2]);
					argu.setMonth( eval( argu.getMonth() - 1 ) );
					argu.setDate( argu.getDate() + type );
					argu.setMonth( eval( argu.getMonth() + 1 ));
					return argu.getFullYear() + "-" + argu.getMonth() + "-" + argu.getDate() ;
				}
				
				
				$("#datepicker").change(function(){
					$("#stadiumSelectBox").val("경기장선택");
					$("#selectTime").html("");
					$("#goRental").hide();
				});
				
				// 경기장을 선택할경우 비동기로 예약가능한 시간을 조회하는 함수
				$("#stadiumSelectBox").change(function(){
					$("#goRental").hide();
					var selectDay = selectedDay();
					var p_open = $("#p_open").val();
					var p_close = $("#p_close").val();
					var param = stadiumInfoSplit();
					
					if(!(selectDay)){
						if(param[0] != '경기장선택'){
							$("#stadiumSelectBox").val("경기장선택");
							alert("예약일을 선택하십시오");
						}
						return
					}
					if(param[0] == '경기장선택'){
						return
					}
					
					var query = {
							selectDay : selectDay,
							s_no : param[0],
							s_hours : param[1],
							p_open : p_open,
							p_close : p_close
							};
					
					// 선택된 경기장의 시간조회 비동기 처리
					$.ajax({
						type:"post",
						url:"/user/rental/searchTime.do",
						data:query,
						error: function() {
							 alert("대관시간 조회에 실패하였습니다.\n다시 시도해주십시오.");
						},
						success:function(result){
							$("#selectTime").html(result);
							
						}
						
					});
					
					
				});
				
				// 예약시간을 선택할경우 동적으로 결제금액을 계산해서 넣어주는 함수
				$(document).on("change","input[name='reservationTime']:radio",function(){  
					$("#goRental").hide();
					// 8,2,20000,10000,30000,20000
					var r_money = setDay();
					var i_money = setTotalMoney();
					$("#payment").text(r_money);
					if(i_money){
						$("#totalMoney").text(eval(r_money) + eval(i_money));
					}else{
						$("#totalMoney").text(eval(r_money));
					}
					
					$("#goRental").show();
				});
				
				// 다음단계 이동전 해당시간대가 예약중인지 비동기로 확인하는 함수
				$(document).on("click","#goRentalBtn",function(){  
						$("#goRental").hide();
						param = makeOverlapKey();
						// 선택된 시간대가 현재 예약이 진행중인지 확인하는 비동기처리
						$.ajax({
							type:"post",
							url:"/user/rental/reservationCheck.do",
							data:{overlapKey : param},
							error: function() {
								alert("비동기 실패");
							},
							success:function(result){
								if(eval(result)){
									formSetting();
									openDialog();
								}else{
									alert("해당 시간에는 이미 대관이 진행중입니다.");
								}
								
								
							}
							
						});
						
					
				});
				// 결제창 모달창
				function openDialog(){
					$("#dialog").dialog({
						title : 'fly_shooter 결제창',
						model : true,
						width : '584',
						height : '400',
						closeOnEscape:false,
						open:function(event, ui){
							$(".ui-dialog-titlebar-close", $(this).parent()).hide();
						},
						resizeable : false,
						show : {
							effect : "blind",
							duration : 1000
						},
						hide : {
							effect : "explode",
							duration : 1000
						},
						buttons:[
							{
								// 버튼 텍스트
								text:'취소',
								click:function(){
									$(this).dialog("close");
									$("#insertRentalForm").find("input[type='text']").val("");
									resetDialog();
									// 결제 취소시 해당 시간대 예약중테이블에서 삭제
									$.ajax({
										type:"post",
										url:"/user/rental/removeReservation.do",
										error: function() {
										},
										success:function(result){
											alert("대관이 취소되었습니다.");
										}
										
									});
									
								}
							},
							{
								text:'결제',
								click:function(){
									//$(this).dialog("close");
									setInsertRentalForm();	
									resetDialog();
									
									$("#insertRentalForm").attr({
										"method":"post",
										"action":"/user/rental/insertRental.do"
									});
									if(confirm("대관하시겠습니까?")){
										$("#insertRentalForm").submit();
										$("#insertRentalForm").find("input[type='text']").val("");
									}
								}
							}
						]
					});
				}
				// 결제 모달창에서 결제 유형 변경시 이벤트
				$(document).on("change","input[name='r_pay_type']:radio",function(){
					var type = $("input:radio[name='r_pay_type']:checked").val();
					
					// type = 2 (계좌이체), 1 (카드결제)
					if(type == '2'){
						$("#creditCard").hide();
						$("#accountTransfer").show();
						
					}else{
						$("#accountTransfer").hide();
						$("#creditCard").show();
					}
					
				});
				
				// 용품별 가격설정
				$(".r_ec").change(function(){
					var price = $(this).parent("tr").attr("data-num");
					var ec = $(this).children().val();
					$(this).next().next().children('span').text( eval(ec*price)+"원");
					
					var i_price = setTotalMoney();
					var r_pay = $("#payment").text();
					$("#itemsPrice").text(i_price);
					var result = 0;
					if(r_pay){
						 result = eval(i_price)+eval(r_pay);
						$("#totalMoney").text(result);
					}else{
						$("#totalMoney").text(i_price);
					}
					
				});
				
				$("#showItems").click(function(){
					$("#showItems").hide();
					$("#items").show();
				});
				
				$("#hideItems").click(function(){
					$("#items").hide();
					$("#showItems").show();
				});
				
				
				
});		
		// 용품일련번호, 대여수량 구해오기
		function setInsertItems(){
			var length = $(".i_ea").length;
			
			var i_no = [];
			var i_ea = [];
			
			for(var i=0; i<length; i++) {
				if($('.i_ea').eq(i).val() && $('.i_ea').eq(i).val() > 0){
					i_ea.push( $(".i_ea").eq(i).val() );
					i_no.push( $(".i_no").eq(i).text() );
				}
			}
			$("#items_no").val(i_no);
			$("#items_ea").val(i_ea);
		}

		function replaceAll(str, searchStr, replaceStr){
			return str.split(searchStr).join(replaceStr);
		}

		function setTotalMoney(){
			/*
			 * price의 값 전체를 한줄로 받아옴
			 * 받아온 값에서 '원'을 +로 치환
			 * 마지막 문자 자르고 계산하면 가격총액이 나옴 
			 */
			var arr = $(".price").text();
			var arrStr = replaceAll(arr,"원","+");
			var str = arrStr.slice(0,-1);
			
			var result = eval(str);
			
			return result;
		}

		function resetDialog(){
			$(".input").val("");
			$("#selectCard").val("선택하세요");
			$("input:radio[name='bank']:radio[value='신한']").prop('checked', true); 
			$("input:radio[name='r_bank']:radio[value='신한']").prop('checked', true); 
			
		}
	
		function setInsertRentalForm(){
			var type = $("input:radio[name='r_pay_type']:checked").val();
			$("#r_pay_type").val(type);
			// type = 2 (계좌이체), 1 (카드결제)
			if(type == "2"){
				$("#r_bank").val($("input:radio[name='r_bank']:checked").val());
				$("#r_account_num").val($("#r_ac_num").val());
				$("#r_account").val($("#r_ac").val());
			}else{
				$("#r_bank").val("");
				$("#r_account_num").val("");
				$("#r_account").val("");
			}
		}
		function makeOverlapKey(){
			var selectDay = selectedDay();
			var time = radioSplit();
			var s_no = stadiumInfoSplit();
			
			// 예약중인 대관테이블에 저장될 key값
			var param = s_no[0]+""+selectDay+""+time[0];
			
			return param;
		}

		function formSetting(){
			setInsertItems();
			var s_no = stadiumInfoSplit();
			var r_start = radioSplit();
			var r_total_pay = $("#payment").text();
			var i_money = setTotalMoney();
			if(i_money){
				r_total_pay = eval(r_total_pay) + eval(i_money);
			}else{
				r_total_pay = eval(r_total_pay);
			}
			$("#r_reserve_date").val(selectedDay());
			$("#s_no").val(s_no[0]);
			$("#r_start").val(r_start[0]);
			$("#r_total_pay").val(r_total_pay);
			$("#total_money").text(r_total_pay);
		}
				
		// 주말,평일설정
		function setDay(){
			var fee = stadiumInfoSplit();
			var time = radioSplit();
			var selectDay = selectedDay();
			var day = new Date(selectDay).getDay();
			var result;
			
			// 주말요금 
			if(day == 0 || day == 6){
					return setFee(fee[1], time[0], fee[4], fee[5]);
			}else{	// 평일요금
					return setFee(fee[1], time[0], fee[2], fee[3]);
			}
			return 0;
		}
		
		// 결제금액 계산
		function setFee(param, param2, param3, param4){
			// 최소이용시간이 1시간인경우
			if(param == 1){
				// 시작시간이 20시 이후인경우 야간요금으로 계산
				if( param2 > 19 ){
					return param3;
				}else{
					return param4;
				}
			}else{
				// 최소 이용시간이 2시간인 경우
				if( param2 > 19 ){
					return eval(param3*2);
				}
				if( param2 == 19 ){
					return eval(param4 + param3);
				}
				return eval(param4*2);
			}
			return 0;
		}
		
		
		
		
		function radioSplit(){
			var arg1 = $("input:radio[name='reservationTime']:checked").val();
			var result = arg1.split(",");
			return result;
		}
		
		function stadiumInfoSplit(){
			var arg1 = $("#stadiumSelectBox option:selected").val();
			var result = arg1.split(",");
			return result;
		}
		function selectedDay(){
			var result = $("#datepicker").val();
			return result;
		}
