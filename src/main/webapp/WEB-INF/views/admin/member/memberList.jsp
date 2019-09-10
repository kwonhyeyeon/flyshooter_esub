<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FLY SHOOTER 관리자</title>
<link rel="stylesheet" type="text/css" href="/resources/css/reset.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/adminStyle.css" />
<script src="http://code.jquery.com/jquery.min.js"></script>
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
                <a href="/admin/member/memberList.do">회원관리</a>

                <a class="depth1">구장 관리</a>
                <a href="/" class="sub">구장 관리</a>
                <a href="/" class="sub">정산 관리</a>

                <a class="depth1">게시판 관리</a>
                <a href="/" class="sub">매치</a>
                <a href="/" class="sub">용병 모집</a>
                <a href="/" class="sub">용병 지원</a>

				<a class="depth1">정보 관리</a>
                <a href="/" class="sub">이용약관</a>
                <a href="/" class="sub">개인정보 취급방침</a>
                <a href="/" class="sub">환불 규정</a>
                
                <a class="depth1">통계</a>
                <a href="/" class="sub">구장 등록 현황</a>
                <a href="/" class="sub">월별 예약 현황</a>
            </aside><!-- subNavi -->
            
            <div id="container">
            	<article id="contents">
            		<h1>인섭아 여기에 코딩하면 돼유</h1>
            	</article><!-- contents -->
            </div><!-- container -->

        </div><!-- con_wrap -->
	
	</div>

</body>
</html>