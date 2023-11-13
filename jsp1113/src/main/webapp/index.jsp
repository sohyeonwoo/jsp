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
		<li><a href="mlogin.jsp">login</a></li>
		<li><a href="mwriter">join membership</a></li>
		</ul>
		<% }else{%>
		<h1> <%=session.getAttribute("session_id") %>님 Welcome aboard.</h1>
		<ul>
		<li><a href="blist.jsp">게시판</a></li>
		<li><a href="loout.jsp">logout</a></li>
		<li><a href="mupdate.jsp">회원정보수정</a></li>
		</ul>
		<% }%>
	</body>
</html>