<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
           <%--  <c:if test="${empty m_id}">
                <li><a href="/member/join.do">회원가입</a></li>
                <li><a href="/">로그인</a></li>
            </c:if>
            <c:if test="${not empty m_id}">
                <li><a href="/">로그아웃</a></li>
            </c:if> --%>
        </ul>
    </nav>
</header>

<div class="menu-wrap">
    <div class="menu">
        <c:choose>
            <c:when test="${m_type==1}">
                <ul>
                    <li><a href="/user/rental/location.do">경기장 예약</a></li>
                    <li><a href="/user/rental/myRentalList.do">나의 예약 현황</a></li>
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
                    <li><a href="/client/rental/rentalList.do">예약 현황</a></li>
                    <li><a href="/client/rental/refundList.do">환불 현황</a></li>
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