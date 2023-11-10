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
		<li><a href ="mlogin.jsp">login</a></li>
		<li><a href = "mwrite.jsp">회원가입</a></li>
	</ul>
	
	<%}else{ %>
	<h1><%=session.getAttribute("session_name")  %>님 환영합니다.</h1>
	<ul>
		<li><a href = "mlogout.jsp">logout</a></li>
		<li><a href = "mupdate.jsp">회원정보수정</a></li>
		<li><a href = "mlist.jsp">회원전체리스트</a></li>
	</ul>
		
	<%}      %>
	
	
	
	
	</body>
</html>