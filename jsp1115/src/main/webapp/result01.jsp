<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<h1>id : ${param.id}</h1>
	<h1>number1 : ${param.num1}</h1>
	<h1>number2 : ${param.num2}</h1>
	<h1>number1 + number2 : ${param.num1 + param.num2}</h1>
	<c:if test="${param.num3%2==0 }">
	<h1>짝수입니다.</h1>
	</c:if>
	<c:if test="${param.num3%2!=0 }">
	<h1>홀수입니다.</h1>
	
	</c:if>
	</body>
</html>