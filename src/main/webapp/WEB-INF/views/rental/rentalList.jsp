<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>FLY SHOOTER</title>

<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/style.css" />
<script src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/rentalList.js"></script>
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
							<li><a href="/rental/location.do">대관 예약</a></li>
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
							<li><a href="/rental/rentalList.do">대관 예약 현황</a></li>
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
		
		<article id="contents">
			<!-- 구장명, 날짜 선택 -->
			<div class="placeList">
				<c:choose>
					<c:when test="${not empty placeList}">
						<select name="placeName" class="placeName">
							<c:forEach var="place" items="${placeList}" varStatus="status">
								<option class="placeName-op" value="${place.p_num}">${place.p_name}</option>
							</c:forEach>
						</select>
					</c:when>
					
					<c:otherwise>
						<select name="placeName" class="placeName">
							<option class="placeName-op" selected>구장 없음</option>
						</select>
					</c:otherwise>
				</c:choose>
				
				<input type="date" class="rentalDate" />
			</div>
			<!-- 구장명, 날짜 선택 -->
			
			<!-- 경기장 별 대관 예약 리스트 -->
			<div class="stadiumList">
				<c:forEach var="stadium" items="${stadiumList}" varStatus="status">
					<input type="hidden" class="s_no" value="${stadium.s_no}" />

					<h2 class="stadiumName">${stadium.s_name}</h2>
					
					<c:if test="${stadiumList}">
						<p class="noStadium">경기장이 없습니다. 경기장을 등록해주세요</p>
					</c:if>
					
					<!-- 대관 예약 리스트 -->
					<div class="rentalListArea">
						<c:if test="${empty rentalList}">
							<p class="noStadium">예약 현황이 없습니다</p>
						</c:if>
						<c:if test="${not empty rentalList}">
							<table class="rentalListTbl">
								<tr>
									<th>예약자명</th>
									<th>전화번호</th>
									<th>예약 시간</th>
									<th>용품 대여</th>
								</tr>
								<tr class="rentalList">
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</table>
						</c:if>
					</div>
					<!-- 대관 예약 리스트 -->
				</c:forEach>
			</div>
			<!-- 경기장 별 대관 예약 리스트 -->
		</article>
		
	</div>
		
</body>
</html>