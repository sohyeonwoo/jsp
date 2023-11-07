<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			table,td{border: 1px solid black; border-collapse: collapse; font-size: 16px;
			text-align: center;}
			
			td{width: 150px; height: 40px;}
		</style>
		
	</head>
	<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="score1" class="com.java.www.StuScore" />
	<jsp:setProperty name="score1" property="*" />
	
	
	<h1>학생성적프로그램</h1>
	<table>
	
	
	<tr>
	<td>number</td>
	<td><%= score1.getStuNum() %></td>
	</tr>
	<tr>
	<td>name</td>
	<td><%= score1.getName() %></td>
	</tr>
	<tr>
	<td>kor</td>
	<td><%= score1.getKor() %></td>
	</tr>
	<tr>
	<td>eng</td>
	<td><%= score1.getEng() %></td>
	</tr>
	<tr>
	<td>math</td>
	<td><%= score1.getMath()  %></td>
	</tr>
	<tr>
	<td>total</td>
	<% score1.setTotal(score1.getKor()+score1.getEng()+score1.getMath()); %>
	<td><%=score1.getTotal()  %></td>
	</tr>
	<tr>
	<td>avg</td>
	<% score1.setAvg(score1.getTotal()/3.0); %>
	<td><%= score1.getAvg() %></td>
	</tr>
	
	</table>
	
	
	</body>
</html>