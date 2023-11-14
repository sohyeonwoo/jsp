<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>el태그</title>
	</head>
	<body>
	<%
	 session.setAttribute("session_nicName","널쭉이");
	%>
		<h1>form</h1>
		<form name="frm" method="get" action="jsp_result.jsp">
			<label>id</label>
			<input type="text" name="id" id="id">
			<br>
			<label>name</label>
			<input type="text" name="name" id="name">
			<br>
			<label>number1</label>
			<input type="text" name="num1">
			<br>
			<label>number2</label>
			<input type="text" name="num2" >
			<br>
			<label>hobby</label>
			<input type="checkbox" name="hobby" id="game" value="game" >
			<label for="game">game</label>
			<input type="checkbox" name="hobby" id="golf" value="golf" >
			<label for="golf">golf</label>
			<input type="checkbox" name="hobby" id="run" value="run" >
			<label for="run">run</label>
			<br>
			<input type="submit" value="전송">
		</form>
	
		
	</body>
</html>