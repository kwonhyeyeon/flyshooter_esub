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
            		
            		<h2 class="con-subject">회원 관리</h2>
            		
            		<!-- 셀렉트 박스 영역 -->
				    <div class="select-area">				
				        <select name="status">
				            <option value="">회원 전체</option>
				            <option value="01">일반</option>
				            <option value="02">사업자</option>
				        </select>
				    </div>
				    <!-- 셀렉트 박스 영역 -->
				    
				    <!-- 점포 리스트 -->
				    <table class="table-style">
				    	<tr>
				    		<th>번호</th>
				    		<th>회원 ID</th>
				    		<th>회원명</th>
				    		<th>회원 구분</th>
				    		<th>회원 가입일</th>
				    		<th>마지막 로그인</th>
				    	</tr>
				        <tr class="list-hover">
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
				        <input type="search" name="search" class="search-field" placeholder="회원명" />
				        <button type="submit" class="search-btn">찾기</button>
				    </div>
				    <!-- 검색 -->
            		
            	</article><!-- contents -->
            </div><!-- container -->

        </div><!-- con_wrap -->
	
	</div>

</body>
</html>