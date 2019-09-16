<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>FLY SHOOTER 관리자</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/adminStyle.css" />
    <script src="http://code.jquery.com/jquery.min.js"></script>
    <script src="/resources/js/adminPlace.js"></script>
</head>

<body>

    <div id="wrapper">

        <div id="header-wrap">
            <div id="header">
                <h1 id="logo"><a href="/admin/main.do">FLY SHOOTER 관리자</a></h1>
                <c:if test="${not empty adminId}">
                    <a href="/admin/logout.do" class="logout">로그아웃</a>
                </c:if>
            </div><!-- header -->
        </div><!-- header-wrap -->

        <div id="content-wrap">
            <aside id="subNavi">
                <jsp:include page="../templates/subNavi.jsp" flush="true" />
            </aside><!-- subNavi -->

            <div id="container">
                <article id="contents">
                    <h2 class="con-subject">구장 상세 정보</h2>
                    <a class="pre-page">이전</a>

                    <h3 class="sub-tit">구장 정보</h3>

                    <!-- 구장 정보 -->
                    <table class="table-style2">
                        <tr>
                            <td class="subject">회원 ID</td>
                            <td>${pvo.m_id}</td>
                        </tr>
                        <tr>
                            <td class="subject">대표자명</td>
                            <td>${pvo.p_ceo}</td>
                        </tr>
                        <tr>
                            <td class="subject">사업자번호</td>
                            <td>${pvo.p_num}</td>
                        </tr>
                        <tr>
                            <td class="subject">구장명</td>
                            <td>${pvo.p_name}</td>
                        </tr>
                        <tr>
                            <td class="subject">구장 전화번호</td>
                            <td>${pvo.p_phone}</td>
                        </tr>
                        <tr>
                            <td class="subject">구장 주소</td>
                            <td>${pvo.p_address}</td>
                        </tr>

                        <tr>
                            <td class="subject">은행명</td>
                            <td>${pvo.p_bank}</td>
                        </tr>
                        <tr>
                            <td class="subject">예금주명</td>
                            <td>${pvo.p_account}</td>
                        </tr>
                        <tr>
                            <td class="subject">입금 계좌번호</td>
                            <td>${pvo.p_account_num}</td>
                        </tr>
						<!-- 파일첨부 1, 팩스 2, 등기 3, 메일 4 -->
						<!-- 파일 클릭 시 다운로드 될 수 있도록 구현 -->
						<c:if test="${pvo.p_file == '1'}">
	                        <tr>
	                            <td class="subject">서류 첨부 유형</td>
	                            <td>${pvo.p_file}</td>
	                        </tr>
	                        <tr>
	                            <td class="subject">사업자 등록증</td>
	                            <td>${pvo.p_register}</td>
	                        </tr>
	                        <tr>
	                            <td class="subject">통장 사본</td>
	                            <td>${pvo.p_account_copy}</td>
	                        </tr>
	                        <tr>
	                            <td class="subject">부동산 종합 공부</td>
	                            <td>${pvo.p_property}</td>
	                        </tr>
                        </c:if>

                        <tr>
                            <td class="subject">구장 운영 시간</td>
                            <td>${pvo.p_open}시 - ${pvo.p_close}시</td>
                        </tr>
                        <tr>
                            <td class="subject">구장 정기 휴일</td>
                            <td>
                            	<c:choose>
                            		<c:when test="${pvo.p_holiday == 0}">일요일</c:when>
                            		<c:when test="${pvo.p_holiday == 1}">월요일</c:when>
                            		<c:when test="${pvo.p_holiday == 2}">화요일</c:when>
                            		<c:when test="${pvo.p_holiday == 3}">수요일</c:when>
                            		<c:when test="${pvo.p_holiday == 4}">목요일</c:when>
                            		<c:when test="${pvo.p_holiday == 5}">금요일</c:when>
                            		<c:when test="${pvo.p_holiday == 6}">토요일</c:when>
                            		<c:when test="${pvo.p_holiday == 7}">연중무휴</c:when>
                            	</c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td class="subject">구장 상태</td>
                            <td>
                            	<c:choose>
                            		<c:when test="${pvo.p_status == 1}">운영중</c:when>
                            		<c:when test="${pvo.p_status == 0}">운영전</c:when>
                            		<c:when test="${pvo.p_status == -1}">임시휴업</c:when>
                            		<c:when test="${pvo.p_status == -2}">폐업</c:when>
                            	</c:choose>
                            </td>
                        </tr>
                        <c:if test="${pvo.p_status == -1}">
                        	<tr>
	                            <td class="subject">임시 휴업 시작일</td>
	                            <td>${pvo.p_holiday_start}</td>
	                        </tr>
	                        <tr>
	                            <td class="subject">영업 재개일</td>
	                            <td>${pvo.p_holiday_end}</td>
	                        </tr>
                        </c:if>
                        <c:if test="${pvo.p_status == -2}">
                        	<tr>
	                            <td class="subject">폐업 등록일</td>
	                            <td>${closeDate}</td>
	                        </tr>
                        </c:if>
                        <tr>
                            <td class="subject">구장 승인 상태</td>
                            <td>
                            	<select name="p_ok" id="acceptSelect">
                            		<option value="1">승인</option>
                            		<option value="0">미승인</option>
                            	</select>
                            </td>
                        </tr>
                        <c:if test="${pvo.p_ok == 1}">
	                        <tr>
	                            <td class="subject">구장 승인일</td>
	                            <td>${pvo.p_ok_date}</td>
	                        </tr>
                        </c:if>

                        <tr>
                            <td class="subject">소개글</td>
                            <td>${pvo.p_intro}</td>
                        </tr>
                        
                        <!-- 구장 승인 상태 변경을 위한 폼 -->
                        <form name="saveForm" id="saveForm">
                        	<input type="hidden" name="p_num" id="p_num" value="${pvo.p_num}" />
                        	<input type="hidden" name="p_ok" id="ok" value="${pvo.p_ok}" />
                        </form>
					    	
                        <tr class="btn-area">
		                    <td><a class="cancle" href="javascript:history.back();">취소</a></td>
		                    <td class="positive">
		                    	<input type="text" id="dddd" value="${pvo.p_ok}" />
		                    	<button class="delete">폐업 등록</button>
		                        <button class="save" disabled>저장</button>
		                    </td>
		                </tr>
                    </table>
                    <!-- 구장 상세 정보 -->

                    <h3 class="sub-tit">용품</h3>

                    <!-- 용품 정보 -->
                    <table class="table-style">
                        <tr>
                            <th width="100">번호</th>
                            <th width="350">용품명</th>
                            <th width="150">대여료</th>
                            <th width="400">용품 상태</th>
                            <th width="100">대여 횟수</th>
                            <th>용품 등록일</th>
                        </tr>
                        <c:if test="${not empty adminPlaceList}">
                            <c:forEach var="place" items="${adminPlaceList}" varStatus="status">
                                <tr class="list-hover">
                                    <td>${fn:length(adminPlaceList)-status.count+1}</td>
                                    <td>${pvo.m_id}</td>
                                    <td>${pvo.p_ceo}</td>
                                    <c:if test="${pvo.p_ok == 1}">
                                        <td>Y</td>
                                    </c:if>
                                    <c:if test="${pvo.p_ok == 0}">
                                        <td>N</td>
                                    </c:if>
                                    <td>${pvo.p_name}</td>
                                    <td>${pvo.p_holiday}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty adminPlaceList}">
                            <tr>
                                <td class="empty" colspan="7">조회된 구장이 없습니다</td>
                            </tr>
                        </c:if>
                    </table>
                    <!-- 용품 정보 -->

                    <h3 class="sub-tit">경기장</h3>
                    <a href="">경기장명</a>
                </article><!-- contents -->
            </div><!-- container -->

        </div><!-- con_wrap -->

    </div>

</body>
<script>
    $("#p_ok").val("${pvo.p_ok}");
    $("${pvo.p_ok}").text();
</script>

</html>