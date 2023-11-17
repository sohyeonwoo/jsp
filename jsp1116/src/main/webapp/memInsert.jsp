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
				if($("#id").val().length<2){
					alert("아이디 입력 요망.");
					$("#id").focus();
					return false;
				}
				alert("저장한다");
				m_frm.submit();
				
			})
		})
		</script>
	</head>
	<body>
		<div>
			<h1>join membership</h1>
			<form name="m_frm" method="post" action="DoMemInsert">
				<table>
					<tr>
						<th>id</th>
						<td><input type="text" name="id" id="id"></td>
					</tr>
					<tr>
						<th>password</th>
						<td><input type="password" name="pw" id="pw"></td>
					</tr>
					<tr>
						<th>name</th>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<th>phone</th>
						<td><input type="text" name="phone" id="phone"></td>
					</tr>
					<tr>
						<th>gender</th>
						<td>
						<input type="radio" name="gender" id="Male" value="Female">
						<label for="Male">남자</label>
						<input type="radio" name="gender" id="Feale" value="Female">
						<label for="Female">여자</label>
						</td>
					</tr>
					<tr>
						<tr>
						<th>hobby</th>
						<td>
						<input type="checkbox" name="hobby" id="game" value="game">
						<label for="game">game</label>
						<input type="checkbox" name="hobby" id="golf" value="golf">
						<label for="golf">golf</label>
						<input type="checkbox" name="hobby" id="run" value="run">
						<label for="run">run</label>
						<input type="checkbox" name="hobby" id="cook" value="cook">
						<label for="cook">cook</label>
						<input type="checkbox" name="hobby" id="book" value="book">
						<label for="book">book</label>
						</td>
					</tr>
				
				</table>
				<button type="button" id="fbtn">join membership</button>
				<button type="button" onclick="javascript:history.back()">Cancel subscription</button>
			</form>
		</div>
	</body>
	
	
	
	
	
	
	
	
	</body>
</html>