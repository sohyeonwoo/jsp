<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>login check</title>
	</head>
	<body>
	<c:if test="${result==1 }">
	<script>
		alert("로그인이 되었습니다.");
		location.href="index.do";
	</script>
	</c:if>
	
	<c:if test="${result!=1 }">
	<script>
	 alert("아이디 , 패스워드 불일치");
	 location.href="login.do";
	</script>
	</c:if>
	</body>
</html>