<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>main page</title>
	</head>
	<body>
		<%if(session.getAttribute("nicname")==null){ %>
		<h1>login</h1>
		<ul>
			<li><a href="jsp_login.jsp">login</a></li>
			<li>회원가입</li>
		</ul>
		
		<%}else{ %>
		
		<h1><%=session.getValue("name").toString() %>님 환영</h1>
		<h2><%=session.getValue("nicname").toString() %> </h2>
		<h2><%=session.getValue("phone").toString() %> </h2>
		<ul>
			<li><a href="jsp_logout.jsp">login out</a></li>
			<li>회원정보</li>
		</ul>
	<%} %>
	</body>
</html>