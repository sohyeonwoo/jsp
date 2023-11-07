<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인확인</title>
	</head>
	<body>
	  
		<% 
	   String id = request.getParameter("id");
	   String pw = request.getParameter("pw");
		if(id.equals("admin") && pw.equals("1111")){ //성공할 경우
		
			session.setAttribute("session_id", id);
		session.setAttribute("session_necName", "뉴진스");
		%>
			<script>alert("로그인 함"); 
			location.href="../layout/main.jsp"</script>
		<% }else{ //실패할 경우%>
		<script>alert("아이디 또는 패스워드 불일치");
			location.href="login.jsp"</script>
		</script>
	<%}%>
	
	
	
	</body>
</html>