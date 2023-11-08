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
		<title>id , pw  check</title>
	</head>
	<body>
	
	<%
	
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String upw = request.getParameter("pw");
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String id,pw;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ora_user","1111");
	stmt = conn.createStatement();
	String query = "select * from member where id = '"+uid+"' and pw = '"+upw+"'";
	rs = stmt.executeQuery(query);
	System.out.println(query);
	     if(rs.next()){
	    	 String dbname = rs.getString("name");
	    	 String dbphone = rs.getString("phone");
	    	 String dbgender = rs.getString("gender");
	    	 session.setAttribute("name",uid);
	    	 session.setAttribute("nicname",dbname);
	    	 session.setAttribute("phone",dbphone);
	    	 session.setAttribute("gender",dbgender);
	%>
		
			<script>
				alert("login");
				location.href="jsp1108_03.jsp";
			</script>
		<%}else{ %>
		<script>
		alert("id or pw nono");
		location.href="jsp_login.jsp";
		</script>
	
     	<%}      %>
		
	
	
		
	
	</body>
</html>