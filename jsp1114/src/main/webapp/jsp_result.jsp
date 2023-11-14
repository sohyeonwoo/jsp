<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		span{font-size: 40px;color: red;padding: 5;}
		</style>
	</head>
	<body>
	<h2>session : <%= session.getAttribute("session_nicName") %></h2>
	<h2>hobbys : <%= Arrays.toString(request.getParameterValues("hobby")) %></h2>
	
	<h2>id : <%= request.getParameter("id") %></h2>
	<h2>name : <%= request.getParameter("name") %></h2>
	<h2>num1 : <%= request.getParameter("num1") %></h2>
	<h2>num2 : <%= request.getParameter("num2") %></h2>
	<h2>result : <%=Integer.parseInt(request.getParameter("num1"))+Integer.parseInt(request.getParameter("num2"))  %></h2>
	
	
	<h1>--forEach--</h1>
	<h2>session1 : ${sessionScope.session_nicName}</h2>
	<h2>session2 : ${session_nicName}</h2>
	<c:forEach var="hobby" items="${paramValues.hobby}">
	<span>${hobby}</span>
	</c:forEach>
	
	<h2>id : ${param.id}</h2>
	<h2>name : ${param.name}</h2>
	<h2>result : ${param.num1 + param.num2}</h2>
	</body>
</html> 