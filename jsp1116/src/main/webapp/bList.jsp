<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>

		<meta charset="UTF-8">
		<title>자유게시판</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			*{margin: 0; padding: 0;}
			a{ text-decoration: none;}
			div{width: 1000px; margin: 30px auto; text-align: center;}
			h1{margin-bottom:30px; }
			table,th,td{border: 1px solid black; border-collapse: collapse;
			font-size: 16px;}
			td,th{width: 200px; height: 40px;}
			button{width: 200px; height: 60px; margin-top: 10px;}
			#n{width: 700px; height: 30px;margin: 40px auto;}
			span{display:inline-block; line-height: 30px;
			width: 20px; height:30px; text-align: center; }
			span:hover {background: #ffa550; color: white; font-weight: 700;}
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
       				<c:forEach items="${list }" var="bdto">
					<tr>
					<td>${bdto.bno }</td>
					<td><a href="bView.do?bno=${bdto.bno }">${bdto.btitle } </a></td>
					<td><fmt:formatDate value="${bdto.bdate }" pattern="yyyy-MM-dd"/></td>
					<td>${bdto.bdate }</td>
					<td>${bdto.bhit }</td>
					</tr>
					</c:forEach>
				</table>
				<div id="n">
				<a href="#"><span>◀</span></a>
				<a href="#"><span>1</span></a>
				<a href="#"><span>2</span></a>
				<a href="#"><span>3</span></a>
				<a href="#"><span>4</span></a>
				<a href="#"><span>5</span></a>
				<a href="#"><span>6</span></a>
				<a href="#"><span>7</span></a>
				<a href="#"><span>8</span></a>
				<a href="#"><span>9</span></a>
				<a href="#"><span>▶</span></a>
				</div>
				<a href="bInsert.do"><button type="button">Writing</button></a>
				<a href="index.do"><button type="button">back stage</button></a>
				</div>
	
	
	</body>
</html>