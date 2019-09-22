<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="/resources/js/clientRefund.js"></script>
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
			<jsp:include page="../templates/header.jsp" flush="true" />
		</div>
		
		<div class="sub-v"></div>
		
		<article id="contents">
			
			<h2 class="articleTit">환불 현황</h2>
			
			<div class="selectArea">
				<form id="refundListForm">
					<input type="hidden" id="register" value="${register}" />
					<input type="hidden" id="p_ok" name="p_ok" value="${p_ok}" />
					
					<select name="year" id="year">
						<option selected>연도</option>
					</select>
					
					<select name="month" id="month">
						<option selected>월 선택</option>
					</select>
					
					<input type="submit" id="refundSearch" value="검색" />
				</form>
			</div>
			
			<!-- 환불 리스트 -->
			<table class="tbl-style">
				<tr>
					<th>회원  ID</th>
					<th>회원명</th>
					<th>구장명</th>
					<th>결제 금액</th>
					<th>환불 금액</th>
					<th>환불 신청일</th>
				</tr>
				<c:if test="${not empty refundList}">
					<c:forEach var="refund" items="${refundList}" varStatus="status">
						<tr class="goDetail">
							<td>${refund.m_id}</td>
							<td>${refund.m_name}</td>
							<td>${refund.p_name}</td>
							<td><fmt:formatNumber value="${refund.r_total_pay}" pattern="#,###"/> 원</td>
							<td><fmt:formatNumber value="${refund.refund}" pattern="#,###"/> 원</td>
							<td>${refund.r_recall_time}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty refundList}">
					<tr>
						<td>환불 신청이 없습니다</td>
					</tr>
				</c:if>
			</table>
			<!-- 환불 리스트 -->
			
			<!-- pagination -->
			<%-- <div class="pagination">
				<tag:paging page="${param.page}" total="${total}" list_size="${pageSize}" />
			</div> --%>
			<!-- pagination -->
			
		</article>
		
	</div>
		
</body>
</html>