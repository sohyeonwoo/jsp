<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문  = response</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("#fbtn").click(function(){
		
		$("#jumin").val();
	
	 frm.submit();
	});
});
</script>
</head>
<body>
<form name='frm' method='get' action="J1103_02_send.jsp">
<label>주민번호를 입력하세요.</label>
<br>
<input type = "text" name="jumin" id="jumin">
<br>
<label>이름을 입력하세요</label>
<br>
<input type = "text" name="name" id="name">
<br>
<input type="button" value="확인" id="fbtn">
</form>

</body>
</html>