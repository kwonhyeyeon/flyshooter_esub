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
                <jsp:include page="../templates/subNavi.jsp" flush="true" />
            </aside><!-- subNavi -->
            
            <div id="container">
            	<article id="contents">
            	
            		<h2 class="con-subject">구장 관리</h2>
            		
            		<!-- 셀렉트 박스 영역 -->
				    <div class="select-area">				
				        <select name="status">
				            <option value="">구장 상태 전체</option>
				            <option value="01">운영중</option>
				            <option value="02">운영전</option>
				            <option value="03">임시휴업</option>
				            <option value="04">폐업</option>
				        </select>
				    </div>
				    <!-- 셀렉트 박스 영역 -->
				    
				    <!-- 점포 리스트 -->
				    <table class="table-style">
				    	<tr>
				    		<th>번호</th>
				    		<th>회원 ID</th>
				    		<th>대표자명</th>
				    		<th>구장명</th>
				    		<th>승인 상태</th>
				    		<th>미승인 경기장 수</th>
				    		<th>등록일</th>
				    	</tr>
				        <tr class="list-hover">
				        	<td></td>
				        	<td></td>
				        	<td></td>
				        	<td></td>
				        	<td></td>
				        	<td></td>
				        	<td></td>
				        </tr>
				    </table>
				    <!-- 점포 리스트 -->
				    
				    <!-- 검색 -->
				    <div class="search">
				        <input type="search" name="search" class="search-field" placeholder="구장명" />
				        <button type="submit" class="search-btn">찾기</button>
				    </div>
				    <!-- 검색 -->
				    
            	</article><!-- contents -->
            </div><!-- container -->

        </div><!-- con_wrap -->
	
	</div>

</body>
</html>