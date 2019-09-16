<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld" %>
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
<script type="text/javascript" src="/resources/js/myRentalList.js"></script>
<script>
	$(function() {
		$("#gnb").hover(function() {
			$(".menu-wrap").slideDown(500);
		});
		$(".menu-wrap").mouseleave(function() {
			$(".menu-wrap").slideUp(500);
		});
	})
	
	function goPage(page){
		$("#page").val(page);
		$("#f_search").attr({
			"method":"get",
			"action":"/user/rental/myRentalList.do"
		});
		
		$("#f_search").submit();
	}
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
			<h2>나의 예약정보</h2>
			<hr />
			<form id="goDetail" style="display: none">
				<input type="hidden" name="page" value="${data.page }" />
				<input type="hidden" name="r_no" id="r_no"/>
			</form>
			<table>			
				<c:if test="${ not empty myList }">
					<tr>
						<td>글번호</td>
						<td>구장명[경기장명]</td>
						<td>예약일</td>
						<td>결제금액</td>
						<td>신청일</td>
						<td>진행상태</td>
					</tr>
					<c:forEach var="rental" items="${ myList }" varStatus="status">
						<tr class="list-hover" data-num="${rental.r_no }">
							<td>${ count - status.index }</td>
							<td>${ rental.r_account }[${ rental.r_bank }]</td>
							<td>${ rental.r_reserve_date }(${ rental.r_start }시~${ rental.r_pay_type + rental.r_start}시)</td>
							<td>${ rental.r_total_pay } 원</td>
							<td>${ rental.r_regdate }</td>
							<td>
								<c:choose>
									<c:when test="${rental.r_pay_status == '1'}">대관완료</c:when>
									<c:when test="${rental.r_pay_status == '2'}">환불대기중</c:when>
									<c:when test="${rental.r_pay_status == '-1'}">환불완료</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:if>	
				
				<c:if test="${ empty myList }">
					<tr>
						<th>대관된 내역이 없습니다.</th>
					</tr>
				</c:if>
			</table>
		</article>
		
		 <!--  paging view (start) -->    
		<div id="boardSearch">
        	<form id="f_search" name="f_search">
        			<input type="hidden" id="page" name="page" value="${data.page }"/>
        	</form>
		</div>
        			
        <div id="boardPage">
        	<tag:paging page="${param.page }" total="${total }" list_size="${data.pageSize }" />
        </div> 
         <!--  paging view (end) -->  
	</div>
		
</body>
</html>