<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${result==1 }">
		<script>
		alert("로그인 되었습니다.");
		location.href="main.do"
		</script>
		</c:if>
		<c:if test="${result!=1 }">
		<script>
		alert("아이디 또는 패스워드 확인 필요.");
		location.href="login.do"
		</script>
		</c:if>
	
	</body>
</html>