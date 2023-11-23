<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>답글달기</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			*{margin: 0; padding: 0;}
			div{width: 800px; margin: 30px auto; text-align: center;}
			h1{margin-bottom:30px; }
			table,th,td{border: 1px solid black; border-collapse: collapse;
			font-size: 16px; }
			table(width: 800px;)
			th,td{height: 40px;}
			textarea{font-size: 17px;}
			input[type=text]{width:97%; height: 30px; font-sixe:16px; }
			button{width: 200px; height: 60px; margin-top: 30px;}
		</style>
		<script>
			$(function(){
				$("#fbtn").click(function(){
					alert("파일을 첨부");
					b_frm.submit();
				})
			})
		</script>
	</head>
	<body>
		<div>
			<h1>답글을 딸기</h1>
			<form name="b_frm" method="post" action="doBReply.do" enctype="multipart/form-data">
				<table>
						<input type="hidden" name="id" value="${session_id }">
						<input type="hidden" name="bgroup" value="${bdto.bgroup }">
						<input type="hidden" name="bstep" value="${bdto.bstep }">
						<input type="hidden" name="bindent" value="${bdto.bindent }">
				<colgroup>
				<col width="20%">
				<col width="80%">
				
					<tr>
						<th>title</th>
						<td><input type="text" name="btitle" id="btitle" value="[답글]${bdto.btitle }"></td>
					</tr>
					
					<tr>
						<th>id</th>
						<td>${session_id }</td>
					</tr>
					
					<tr>
						<th>content</th>
						<td>
						<textarea name="bcontent" rows="30" cols="65">
 
답글
-----------------------------------
${bdto.bcontent }
						</textarea>
						</td>
					</tr>
					
					<tr>
						<th>File Attachment 1</th>
						<td><input type="file" name="bfile" id="bfile"></td>
					</tr>
					
					
				</table>
				<button type="button" id="fbtn">join membership</button>
				<button type="button" onclick="javascript:history.back()">Cancel subscription</button>
			</form>
		</div>
	</body>
	
	
	
	
	
	
	
	
	</body>
</html>