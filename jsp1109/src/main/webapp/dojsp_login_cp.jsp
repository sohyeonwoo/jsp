<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>login check</title>
		</head>
	<body>
	<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String upw = request.getParameter("pw");
		
	 	//커넥션
	 	Connection conn = null;
	 	PreparedStatement pstmt = null;
	 	ResultSet rs = null;
	try{
		
		//커넥션 풀에서 connection 을 가져옴
	 	Context context = new InitialContext();
	 	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18");
	 	conn = ds.getConnection();
	 	
	 	String query = "select * from member where id = ? and pw =?";
	 	pstmt = conn.prepareStatement(query);
	 	pstmt.setString(1,uid);
	 	pstmt.setString(2,upw);
	 	rs = pstmt.executeQuery();
	 	if(rs.next()){
	 		session.setAttribute("session_id", uid);
	 		session.setAttribute("session_nicName",uid );
	 	%>
	 	<script>
	 	alert("login");
	 	location.href="jsp_main.jsp";
	 	</script>
	 	<%}else{%>
	 	<script>
	 	alert("login nono!");
	 	location.href="jsp_login.jsp";
	 	</script>
	 	
	 		
	 	<%} %>
	 	
		<% 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		  try{
			  if(rs!=null) rs.close();
			  if(pstmt!=null) pstmt.close();
			  if(conn!=null) conn.close();
		}catch(Exception e2){
			e2.printStackTrace();
		}
		  }
		
	%>
	
	</body>
</html>