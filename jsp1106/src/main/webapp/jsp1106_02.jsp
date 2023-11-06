<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키todtjd</title>
</head>
<body>
<%
//쿠키생성
Cookie ck1 = new Cookie("popup1","open");
Cookie ck2 = new Cookie("nickName","hong1");
//쿠키 시간설정
ck1.setMaxAge(60*10);// 60 Second * 10 = 10min
ck2.setMaxAge(60*60*24); // 60 Second * 60 min * 24 =day
response.addCookie(ck1);
response.addCookie(ck2);
%>
<h1>쿠키 생성</h1>
<a href="cookie_list.jsp">쿠키생성</a>

</body>
</html>