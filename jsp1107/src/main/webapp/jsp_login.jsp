<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login page</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
			$(function(){
				$("#fbtn").click(function(){
					l_frm.submit();
					
				});
				
			});//제이쿼리 구문 최신
		</script>
	</head>
	<body>
	<h1>login page</h1>
	<form name="l_frm" method="post" action="S01">
	<label> 아이디</label>
	<input type="text" name="id" id="id"><br>
	<label>패스워드</label>
	<input type="password" name="pw" id="pw"><br>
	<input type="button" value="로그인" id= "fbtn">
	<input type="button" onclick="javascript:history.back();" value="취소"><br>
	</form>
	</body>
</html>