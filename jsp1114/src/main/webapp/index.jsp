<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>main page</title>
	</head>
	<body>
		<% if (session.getAttribute("session_id")==null){%>
		<h1>login please</h1>
		<ul>
		<li><a href="login.jsp">login</a></li>
		<li><a href="writer">join membership</a></li>
		</ul>
		<% }else{%>
		<h1> <%=session.getAttribute("session_id") %>님 Welcome aboard.</h1>
		<ul>
		<li><a href="list.jsp">게시판</a></li>
		<li><a href="logout.jsp">logout</a></li>
		<li><a href="update.jsp">회원정보수정</a></li>
		</ul>
		<% }%>
	</body>
</html>