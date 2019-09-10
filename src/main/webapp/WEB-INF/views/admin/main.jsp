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
                <jsp:include page="templates/subNavi.jsp" flush="true" />
            </aside><!-- subNavi -->

            <div id="container">
			   <article id="contents" style="padding-top:50px;">
		   
			   		<table class="table-style mainCnt">
			           <tr>
			               <th width="200">항목</th>
			               <th width="100">오늘</th>
			               <th width="100">이번달</th>
			               <th>누적</th>
			           </tr>
			           <tr>
			               <td>회원가입</td>
			               <td>${registDayCnt }</td>
			               <td>${registMonthCnt }</td>
			               <td class="total">${registTotalCnt }</td>
			           </tr>
			           <tr>
			               <td>구장 등록 수</td>
			               <td>${placeDayCnt }</td>
			               <td>${placeMonthCnt }</td>
			               <td class="total">${placeTotalCnt }</td>
			           </tr>
			           <tr>
			               <td>경기장 예약 수</td>
			               <td>${rentalDayCnt }</td>
			               <td>${rentalMonthCnt }</td>
			               <td class="total">${rentalTotalCnt }</td>
			           </tr>
			           <tr>
			               <td>매치 게시판 등록 수</td>
			               <td>${matchDayCnt }</td>
			               <td>${matchMonthCnt }</td>
			               <td class="total">${matchTotalCnt }</td>
			           </tr>
			           <tr>
			               <td>용병 게시판 등록 수</td>
			               <td>${supportDayCnt }</td>
			               <td>${supportMonthCnt }</td>
			               <td class="total">${supportTotalCnt }</td>
			           </tr>
			       </table>
			   </article><!-- contents -->
			</div><!-- container -->

        </div><!-- con_wrap -->
	
	</div>

</body>
</html>