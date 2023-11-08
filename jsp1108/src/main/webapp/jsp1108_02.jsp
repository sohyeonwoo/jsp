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
		<title></title>
	</head>
	<body>
		<div>
			<h1>회원정보</h1>
			<style>
			*{margin: 0; padding: 0;}
			div{width: 1400px; margin: 30px auto;}
			h1{text-align: center; margin-bottom: 20px;}
			table{width: 1200px;}
			table,th,td{border: 1px solid black; border-collapse: collapse;
			font-size: 16px; text-align: center;}
			
			th,td{widows: 200px; height: 40px;}
			</style>
			<table>
		
				
			
			
			<tr>
				<th>number</th>
				<th>id</th>
				<th>password</th>
				<th>name</th>
				<th>phone number</th>
				<th>gender</th>
				<th>hobby</th>
			</tr>
				<%
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				String id,pw,name,phone,gender,hobby;
				int i =0;
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"ora_user","1111");
							stmt = conn.createStatement();
							String query ="select * from member";
							rs = stmt.executeQuery(query);
							
							while(rs.next()){
								i++;
								id= rs.getString("id");
								pw= rs.getString("pw");
								name= rs.getString("name");
								phone= rs.getString("phone");
								gender= rs.getString("gender");
								hobby= rs.getString("hobby");
								
							%>
			<tr>
				<td><%=i %></td>
				<td><%=id%></td>
				<td><%=pw%></td>
				<td><%=name%></td>
				<td><%=phone %></td>
				<%if(gender.equals("male")){%>
					<td>남자</td>
				<%}else{%>
					<td>여자</td>
					<%}%>
				<td><%=hobby%></td>
			</tr>
			<%}//while %>
			
			<%                                            
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try{
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
						if(conn!=null) conn.close();
					
						
					
					}catch(Exception e2){e2.printStackTrace();}
					
				}//finally
			%>
			</table>
			
		</div>
	
	</body>
</html>