<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>main page</title>
	</head>
	<body>
	<c:if test="${session_id==null }">
		<h1>login please</h1>
		<ul>
		<li><a href="login.do">login</a></li>
		<li><a href="writer.do">join membership</a></li>
		</ul>
		</c:if>
		
		<c:if test="${session_id !=null}">
		<h1>Welcome aboard</h1>
		<ul>
		<li><a href="list.do">게시판</a></li>
		<li><a href="logout.do">logout</a></li>
		<li><a href="update.do">회원정보수정</a></li>
		</ul>
		</c:if>
	</body>
</html>