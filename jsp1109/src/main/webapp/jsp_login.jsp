<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<style>
		*{margin: 0;padding: 0;}
		div{width:400px; margin:30px auto; text-align: center;}
		h1{margin-bottom: 30px;}
		table,th,td{border: 1px solid black ; border-collapse: collapse;
		font-size: 16px;}
		th,td{width: 200px; height: 40px;}
		button{width: 200px; height: 60px; margin-top: 30px;}
	</style>
	<script>
	$(function(){
		$("#fbtn").click(function(){
		l_frm.submit();
		});
		
	});
	</script>
	</head>
	<body>
	<div>
	<h1>login</h1>
	<form name="l_frm" method="post" action="dojsp_login_cp.jsp">
	<table>
	<tr>
	<th>id</th>
	<td><input type="text" name="id" id="id"></td>
	</tr>
	<tr>
	<th>password</th>
	<td><input type="text" name="pw" id="pw"></td>
	</tr>
	</table>
	<button type = "button" id="fbtn">login</button>
	</form>
	
	</div>
	
	</body>
</html>