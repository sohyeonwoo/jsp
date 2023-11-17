<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<c:if test="${session_id==null }">
		<script>
		alert("로그인을 하셔야 글쓰기 가능");
		location.href="login.do";
		</script>
		</c:if>
		<meta charset="UTF-8">
		<title>글쓰기</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			*{margin: 0; padding: 0;}
			div{width: 800px; margin: 30px auto; text-align: center;}
			h1{margin-bottom:30px; }
			table,th,td{border: 1px solid black; border-collapse: collapse;
			font-size: 16px; }
			table(width: 800px;)
			th,td{height: 40px; }
			td *{vertical-align: middle;}
			textarea{font-size: 17px;}
			input[type=text]{width:97%; height: 30px; font-sixe:16px; }
			button{width: 200px; height: 60px; margin-top: 30px;}
			img{width:15%;}
		</style>
		<script>
			$(function(){
				$("#fbtn").click(function(){
					alert("글을 수정한다 !");
					b_frm.submit();
				})
			})
		</script>
	</head>
	<body>
		<div>
			<h1>글 수정</h1>
			<form name="b_frm" method="post" action="doBUpdate.do" enctype="multipart/form-data">
						<input type="hidden" name="id" value="${session_id }">
						<input type="hidden" name="bno" value="${bdto.bno }">
						<input type="hidden" name="oldBfile" value="${bdto.bno }">
				<table>
				<colgroup>
				<col width="20%">
				<col width="80%">
					<tr>
						<th>title</th>
						<td><input type="text" name="btitle" id="btitle" value=${bdto.btitle }></td>
					</tr>
					<tr>
						<th>id</th>
						<td>${session_id }</td>
					
					</tr>
					<tr>
						<th>content</th>
						<td><textarea name="bcontent" rows="30" cols="65">${bdto.bcontent }</textarea></td>
					</tr>
					<tr>
						<th>Modify_File</th>
						<td><input type="file" name="bfile" id="bfile"></td>
					</tr>
					<tr>
						<th>FileName</th>
						<td>${bdto.bfile }</td>
					</tr>
					<tr>
						<th>image</th>
						<td><img src="upload/${bdto.bfile }"></td>
					</tr>
					
					
				</table>
				<button type="button" id="fbtn">Correcting the text</button>
				<button type="button" onclick="javascript:history.back()">Cancel subscription</button>
			</form>
		</div>
	</body>
	
	
	
	
	
	
	
	
	</body>
</html>