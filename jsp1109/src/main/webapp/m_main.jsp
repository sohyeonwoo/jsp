<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>main page</title>
		
	</head>
	<body>
	
	<% if(session.getAttribute("session_id")==null){%>
	<h1>login gogo</h1>
	<ul>
		<li><a href ="m_login.jsp">login</a></li>
		<li><a href = "m_Write.jsp">회원가입</a></li>
	</ul>
	
	<%}else{ %>
	<h1><%=session.getAttribute("session_nicName")  %>님 환영합니다.</h1>
	<ul>
		<li><a href = "mlogout.jsp">logout</a></li>
		<li><a href = "m_memModify.jsp">회원정보수정</a></li>
	</ul>
		
	<%}      %>
	
	
	
	
	</body>
</html>