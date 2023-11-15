<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="UTF-8">
		<title>자유게시판</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			*{margin: 0; padding: 0;}
			div{width: 1000px; margin: 30px auto; text-align: center;}
			h1{margin-bottom:30px; }
			table,th,td{border: 1px solid black; border-collapse: collapse;
			font-size: 16px;}
			td,th{width: 200px; height: 40px;}
			button{width: 200px; height: 60px; margin-top: 30px;}
		</style>
	</head>
	<body>
		<div>
			<h1>자유게시판</h1>
				<table>
				<colgroup>
				<col width="12%">
				<col width="40%">
				<col width="18%">
				<col width="18%">
				<col width="12%">
				</colgroup>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
       				</tr>
       				
					<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					</tr>
					
				</table>
				<a href="write.jsp"><button type="button">Writing</button></a>
				<a href="index.jsp"><button type="button">back stage</button></a>
		</div>
	
	</body>
</html>