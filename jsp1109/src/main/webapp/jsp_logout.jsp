<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>logout</title>
	</head>
	<body>
	<%
		session.invalidate();
	%>
	<script>
		alert("logout");
		location.href = "jsp_main.jsp";
	</script>
	</body>
</html>