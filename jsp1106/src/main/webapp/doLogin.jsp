<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");

if( id.equals("admin")&& pw.equals("1111")){
	session.setAttribute("session_id","admin");
	session.setAttribute("session_nicName","길동스");
	%>
	<script>
	alert("login 되었습니다.");
	location.href="session.jsp";
	</script>
	<%}else{ %>
	<script>
	alert("login 실패.");
	location.href="login.jsp";
	</script>
 <% }%>


</body>
</html>