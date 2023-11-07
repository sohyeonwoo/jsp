<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ConnectionBuilder"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>data base Connection</title>
	</head>
	
	<body>
	<% 
	Connection conn =null;
	Statement stmt =null;
	ResultSet rs =null;
	int stuNum=0;
	String name="";
	int grade =0;
	String email="",phone="",gender="",address="";
	
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ora_user","1111");
		stmt = conn.createStatement();
		String query = "select * from stuinfo";
		rs = stmt.executeQuery(query);
		
		
		
	while(rs.next()){ //rs data가 있으면
			stuNum = rs.getInt("stuNum");
			name = rs.getString("name");
			grade = rs.getInt("grade");
			email = rs.getNString("email");
			phone = rs.getNString("phone");
			gender = rs.getNString("gender");
			address = rs.getNString("address");
			out.println("학번 : "+ stuNum+",이름 : "+name+",학년 : "+grade+",이메일 : "+email+
					",전화번호 : "+phone+",성별 : "+gender+",주소 : "+address+"<br>");
		
		}//while
		
	
	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(Exception e2){
			e2.printStackTrace();
		};
	};
	

	%>
	
	</body>
</html>