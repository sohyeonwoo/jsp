<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>id/pw check</title>
	</head>
	<body>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("admin") && pw.equals("1111")){
		session.setAttribute("session_id", "admin");
		session.setAttribute("session_nicName", "어벤져스");
	
	%>
	<script>
	alert("login 됨");
	location.href="main.jsp";
	</script>
	<%}else{ %>
	<script>
	alert("login 됨");
	location.href="main.jsp";
	</script>
	<%} %>
	
	
	</body>
</html>