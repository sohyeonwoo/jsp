<%@page import="com.java.www.dto.MemberDto"%>
<%@page import="com.java.www.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			*{margin: 0; padding: 0;}
			div{width: 600px; margin: 30px auto; text-align: center;}
			h1{margin-bottom:30px; }
			table,th,td{border: 1px solid black; border-collapse: collapse;
			font-size: 16px;}
			th{width: 200px; height: 40px;}
			td{width: 400px;}
			button{width: 200px; height: 60px; margin-top: 30px;}
		</style>
		<script>
		$(function(){
			$("#fbtn").click(function(){
				alert("저장한다");
				m_frm.submit();
				
			})
		})
		</script>
	</head>
	<body>
	<%
	String id = request.getParameter("id");
	MemberDao mdao = new MemberDao();
	MemberDto mdto = mdao.memberOne(id);
	
	%>
	
		<div>
			<h1>회원정보수정</h1>
			<form name="m_frm" method="post" action="Do_mupdate">
				<table>
					<tr>
						<th>id</th>
						<td><%=mdto.getId()%></td>
						<input type ="hidden" name ="id" value="<%=mdto.getId() %>">
					</tr>
					<tr>
						<th>password</th>
						<td><input type="password" name="pw" id="pw"></td>
					</tr>
					<tr>
						<th>name</th>
						<td><input type="text" name="name" id="name"value="<%=mdto.getName() %>"></td>
					</tr>
					<tr>
						<th>phone</th>
						<td><input type="text" name="phone" id="phone"value="<%=mdto.getPhone() %>"></td>
					</tr>
					<tr>
						<th>gender</th>
						<td>
						<input type="radio" name="gender" id="Male" value="Male" <% if(mdto.getGender().equalsIgnoreCase("Male")) out.println("checked"); %>>
						<label for="Male">남자</label>
						<input type="radio" name="gender" id="Feale" value="Female" <% if(mdto.getGender().equalsIgnoreCase("Female")) out.println("checked"); %>>
						<label for="Female">여자</label>
						</td>
					</tr>
					<tr>
						<tr>
						<th>hobby</th>
						<td>
						<input type="checkbox" name="hobby" id="game" value="game" <% if(mdto.getHobby().contains("game")) out.println("checked"); %>>
						<label for="game">game</label>
						<input type="checkbox" name="hobby" id="golf" value="golf"<% if(mdto.getHobby().contains("golf")) out.println("checked"); %>>
						<label for="golf">golf</label>
						<input type="checkbox" name="hobby" id="run" value="run"<% if(mdto.getHobby().contains("run")) out.println("checked"); %>>
						<label for="run">run</label>
						<input type="checkbox" name="hobby" id="cook" value="cook"<% if(mdto.getHobby().contains("cook")) out.println("checked"); %>>
						<label for="cook">cook</label>
						<input type="checkbox" name="hobby" id="book" value="book"<% if(mdto.getHobby().contains("book")) out.println("checked"); %>>
						<label for="book">book</label>
						</td>
					</tr>
					</tr>
				</table>
				<button type="button" id="fbtn">수정</button>
				<button type="button" onclick="javascript:history.back()">Cancel subscription</button>
			</form>
		</div>
	</body>
	
	
	
	
	
	
	
	
	</body>
</html>