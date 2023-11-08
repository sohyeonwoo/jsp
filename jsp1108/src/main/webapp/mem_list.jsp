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
		<title>Insert title here</title>
		<style>
		*{margin: 0; padding: 0;}
		div{width: 1200px; margin: 30px auto; text-align: center;}
		table,th,td{border-collapse: collapse; border:1px solid black;
					font-size: 16px;}
		th,td{width: 200px; height: 40px;}
		button{width: 200px; height: 45px; margin-top: 20px; }
		</style>
	</head>
	<body>
	<div>
	<h1>information</h1>
	<table>
	<tr>
		<th>id</th>
		<th>password</th>
		<th>name</th>
		<th>phone</th>
		<th>gender</th>
		<th>hobby</th>
		<th>mdate</th>
	</tr>
	<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String id="",pw="",name="",phone="",gender="",hobby="",mdate="";
	
	//db연결
	
	
	request.setCharacterEncoding("utf-8");
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ora_user","1111");
	stmt=conn.createStatement();
	String query ="select * from mem";
	rs= stmt.executeQuery(query);

	while(rs.next()){
	
	
	id = rs.getString("id");
	pw = rs.getString("pw");
	name = rs.getString("name");
	phone = rs.getString("phone");
	gender = rs.getString("gender");
	hobby = rs.getString("hobby");
	mdate = rs.getString("mdate");
	%>
	<tr>
	<td><%=id %></td>
	<td><%=pw %></td>
	<td><%=name %></td>
	<td><%=phone %></td>
	<td><%=gender %></td>
	<td><%=hobby %></td>
	<td><%=mdate %></td>
	</tr>
	<%} %>
	
	<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
			if(conn !=null) conn.close();
			
		}catch(Exception e2){
			e2.printStackTrace();
		}//catch
	}//finally
	%>
	
	
	
	</table>
	</div>
	
	</body>
</html>