<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/resources/css/reset.css" />
<link rel="stylesheet"  href="/resources/css/style.css" />
<!-- datepicker를 사용하기 위한 css, js -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" />
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script> <!-- end datepicker -->
<script type="text/javascript" src="/resources/js/rentalStadium.js"></script>
<script>
	$(function() {
		$("#gnb").hover(function() {
			$(".menu-wrap").slideDown(500);
		});
		$(".menu-wrap").mouseleave(function() {
			$(".menu-wrap").slideUp(500);
		});
	})
</script>
</head>
<body>
	<div id="wrapper">

		<div id="header-wrap">
			<header id="header">
				<h1><a href="/">FLY SHOOTER</a></h1>
				
				<nav id="gnb">
					<ul>
						<li><a href="/">대관</a></li>
						<li><a href="/">매치</a></li>
						<li><a href="/">용병</a></li>
						<li><a href="/">마이페이지</a></li>
					</ul>
				</nav>
				
				<nav id="lnb">
					<ul>
						<c:if test="${empty m_id}">
							<li><a href="/member/join.do">회원가입</a></li>
							<li><a href="/">로그인</a></li>
						</c:if>
						<c:if test="${not empty m_id}">
							<li><a href="/">로그아웃</a></li>
						</c:if>
					</ul>
				</nav>
			</header>
			
			<div class="menu-wrap">
				<div class="menu">
					<c:choose>
						<c:when test="${m_type==1}">
						<ul>
							<li><a href="/user/rental/location.do">대관 예약</a></li>
							<li><a href="/">대관 확인</a></li>
						</ul>
						<ul>
							<li><a href="/">매치 신청</a></li>
						</ul>
						<ul>
							<li><a href="/">용병 지원</a></li>
							<li><a href="/">용병 모집</a></li>
						</ul>
						<ul>
							<li><a href="/">회원 정보 수정</a></li>
						</ul>
						</c:when>
					
						<c:when test="${m_type==0}">
						<ul class="member-menu">
							<li><a href="/user/rental/rentalList.do">대관 예약 현황</a></li>
							<li><a href="/">대관 환불 현황</a></li>
							<li><a href="/">오프라인 대관 관리</a></li>
						</ul>
						<ul>
							<li><a href="/">매치 신청</a></li>
						</ul>
						<ul>
							<li><a href="/">용병 지원</a></li>
							<li><a href="/">용병 모집</a></li>
						</ul>
						<ul>
							<li><a href="/">회원 정보 수정</a></li>
							<li><a href="/">구장</a></li>
							<li><a href="/">경기장/용품</a></li>
							<li><a href="/">정산 관리</a></li>
							<li><a href="/">통계</a></li>
						</ul>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
		
		<div class="sub-v"></div>
		
		<!-- 경기장 예약 -->
		<div class="stadiumRental">
			<div class="stadiumInfo">
				
				<div>
					<!-- 사이트 로고이미지 출력 -->
					<article id="stadiumImg">
							<img src="/resources/img/default_img.jpg" />
					</article>
					<br />
					<br />
					<!-- 구장정보 -->
					<article id="placeInfo">
						[구장정보]
						 <br />
						 ${ pvo.p_name }
						 <br />
						 ${ pvo.p_address }
						 
						 <br />
						 ${ pvo.p_phone }
						 <br />
						 [영업시간]
						 <br />
						 ${ pvo.p_open } ~ ${ pvo.p_close }(시)
					</article>
					
					<br />
					<br />
					<!-- 이용약관 -->
					<article id="termsOfService">
						[환불규정및 이용약관 include예정]						
					</article>
				</div>				

			</div>
		
			<div class="stadiumCal">
			
				<form id="hidden_form">
					<input type="hidden" value="${ pvo.p_holiday_start }" id="holiday_start"/>
					<input type="hidden" value="${ pvo.p_holiday_end }" id="holiday_end"/>
					<input type="hidden" value="${ pvo.p_holiday }" id="holiday"/>
				</form>
				
				<form id="rentalStadiumInfo">
					<input type="text" id="selectS_info" name="selectS_info" />
					<input type="text" id="selectDay" name="selectDay" />
					<input type="text" id="p_open" value="${ pvo.p_open }" />
					<input type="text" id="p_close" value="${ pvo.p_close }" />
				</form>
					<input type="text" value="${ pvo.p_open }"/>
					<table>
						<tr>
							<td><input type="text" id="datepicker" name="datepicker"/></td>
						</tr>
						<tr>
							<td>
								<select id="stadiumSelectBox" name="selectStadium" >
								<option>경기장선택</option>
									<c:forEach var="stadium" items="${ stadiumList }">
										<option value="${ stadium.s_no },${ stadium.s_hours},${stadium.s_n_fee },${stadium.s_d_fee },${stadium.s_n_fee_w },${stadium.s_d_fee_w }">${ stadium.s_name }</option>
									</c:forEach>	
								</select>			
							</td>
						</tr>		
						<tr>
							<td>예약가능시간</td>
						</tr>			
					</table>
				
				
				<div id="selectTime">
					
				</div>
			</div>
		</div>
		<!-- 경기장 예약 -->
		
	</div>
</body>
</html>