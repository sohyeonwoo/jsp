<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>결과값</title>
	</head>
	<body>
	<% String user_pw="1111"; %>
	<h1>for문 사용</h1>
	<%
	for(int i=1;i<=10;i++){
		out.println("<h2>"+i+"<h2>");
		
		
	}
	%>
	<h1> 사용 2</h1>
	<c:forEach var="i" begin="1" end="10" step="1">
		<h2>${i}</h2>
	</c:forEach>
	
	<h1>값 지정 - set</h1>
	<c:set var="user_id" value="abc" />
	<h2>id 지정 : ${user_id}</h2>	
	<h2>password 지정 : ${user_pw}</h2>	
	<h2>표현식 지정 : <%=user_pw %></h2>	
	
	
	<h1>param으로 값 가져오기</h1>
	<h2> result : ${param.id }</h2>
	<hr>
	<h1>jstl if문 사용</h1>
	<c:if test="${param.id == 'aaa'}">
		<h2>aaa 환영</h2>
	</c:if>
	<c:if test="${param.id != 'aaa'}">
		<h2>${param.id}</h2>
	</c:if>
	<hr>
	<h1>switch: choose</h1>
	<c:choose>
	<c:when test="${param.id=='aaa'}">
		<h2>aaa님 환영합니다</h2>
	</c:when>
	<c:otherwise>
	<h2>${param.id }님 환영합니다.</h2>
	</c:otherwise>
	</c:choose>
	
	
	
	</body>
</html>