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
<script type="text/javascript" src="/resources/js/adminMember.js"></script>
</head>
<body>

	<div id="wrapper">
		
		<div id="header-wrap">
            <div id="header">
                <h1 id="logo"><a href="/admin/main.do">FLY SHOOTER 관리자</a></h1>
                	<a href="/admin/logout.do" class="logout">로그아웃</a>
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
				    	<p id="p_status" style="display:none">${status }</p>
					    <form id="such_status">			
					        <select name="status" id="status">
					            <option value="null">회원 전체</option>
					            <option value="1">일반</option>
					            <option value="0">사업자</option>
					        </select>
				        </form>
				    </div>
				    <!-- 셀렉트 박스 영역 -->
				    
				    <!-- 점포 리스트 -->
				    <table class="table-style">
				    	<tr>
				    		<th>번호</th>
				    		<th>회원 ID</th>
				    		<th>회원명</th>
				    		<th>회원 구분</th>
				    		<th>회원상태</th>
				    		<th>회원 가입일</th>
				    		<th>마지막 로그인</th>
				    	</tr>
				    	
				    	<c:if test="${ not empty memberList }">
				    	<c:forEach var="member" items="${ memberList }" varStatus="status">
				        <tr class="list-hover">
				        	<td>${	status.index+1 }</td>
				        	<td>${ member.m_id }</td>
				        	<td>${ member.m_name }</td>
				        	<td>
					        	<c:choose>
									<c:when test="${member.m_type == '1'}">일반회원</c:when>
									<c:when test="${member.m_type == '0'}">사업자</c:when>
									<c:otherwise> ... </c:otherwise>
								</c:choose>
							</td>
				        	<td>
					        	<c:choose>
									<c:when test="${member.m_status == '1'}">활성</c:when>
									<c:when test="${member.m_status == '0'}">비활성</c:when>
									<c:when test="${member.m_status == '-1'}">탈퇴</c:when>
									<c:otherwise> ... </c:otherwise>
								</c:choose>
							</td>
				        	<td>${ member.m_regdate }</td>
				        	<td>${ member.m_phone }</td>
				        </tr>
				        </c:forEach>
				        </c:if>
				        <c:if test="${empty memberList }">
					        <tr class="list-hover">
	                           <td class="empty" colspan="7">조회된 구장이 없습니다</td>
	                   		 </tr>
				        </c:if>
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