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
<title>Insert title here</title>

<link rel="stylesheet"  href="/resources/css/reset.css" />
<link rel="stylesheet"  href="/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		
		<header id="header">
			<h1>FLY SHOOTER</h1>
			
			<nav id="gnb">
				<ul>
					<li><a href="/">대관</a></li>
					<li><a href="/">매치</a></li>
					<li><a href="/">용병</a></li>
					<li><a href="/">마이페이지</a></li>
				</ul>
			</nav>
		</header>
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
			</header>
		</div>
		
	</div>
		
		<div>
			<form action="/rental/placeList.do" method="get">
				<table border="1">
					<tr>
						<td>지역검색</td>
					</tr>
					
					<tr>
						<td><input type="text" name="area" /></td>
					</tr>
					
					<c:if test="${not empty message }">
						<tr>
							<td><span style="color: red">${message }</span></td>
						</tr>
					</c:if>
					
					<tr>
						<td><input type="submit" /></td>
					</tr>
				</table>
			</form>
		</div>
		
</body>
</html>