<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html><%
String id = request.getParameter("id");
MemberDao mdao = new MemberDao();
MemberDto mdto =   mdao.memberOne(id);

MemberDao aa = new MemberDao();
int kk = aa.func1(8.6);
%>