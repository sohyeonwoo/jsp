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
		<title>db연결</title>
		</head>
		<body>
		<%
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs = null;
		String id = null, pw = null, name=null,phone=null,gender=null,hobby=null;
		
		try{ //db연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ora_user","1111");
			stmt = conn.createStatement();
			String query = "select * from member";
			rs = stmt.executeQuery(query);
			while(rs.next()){
				id = rs.getString("id");
				pw = rs.getString("pw");
				name = rs.getString("name");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
				hobby = rs.getString("hobby");
				out.print("<br>"+"아이디 : "+id+"<br>"+"패스워드 : "+pw+"<br>"+"이름 : "+name+"<br>"+"전화번호 : "+phone+"<br>"+
						"성별 : "+gender+"<br>"+"취미 : "+hobby+"<br>"+"---------");
			}
					
					
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				if(rs !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
				
			}catch(Exception e2){
			e2.printStackTrace();
				
			}
		}
		%>
	
	</body>
</html>