<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
		$(function(){
			$("#sbtn").click(function(){
			frm.submit();
			});
		});
		</script>
	</head>
	<body>
	<h1>login</h1>
	<form name="frm" method="post" action="dojsp_login.jsp">
	<label>id</label> 
	<input type="text" name="id" id="id" class="id">
	<br>
	<label>password</label>
	<input type="password" name="pw" id="pw">
	<br>
	<input type="button" value="login" id="sbtn">
	<input type="button" onclick="javascript:history.back()" value="cancle">
	<br>
	</form>
	
	</body>
</html>