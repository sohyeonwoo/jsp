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
				div{width: 1400px; margin: 30px auto;}
				h1{text-align: center; margin-bottom: 20px;}
				table{width: 1200px;}
				table,th,td{border: 1px solid black; border-collapse: collapse;
				font-size: 16px; text-align: center;}
				th,td{widows: 200px; height: 40px;}
			</style>
	</head>
	<div>
		<table>
		<h1>직원정보</h1>
		<tr> 
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		</tr>
		<% 
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int rnum = 0;
		int bno = 0;
		String btitle ,bcontent ,id ,bdate;
		
		
		try{
			Class.forName("Oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:@localhost:1521:xe","ora_user","1111");
			stmt = conn.createStatement();
			String query = "select * from(select row_number() over(order by bgroup desc, bstep asc) rnum, a.* from board awhere btitle like '%ia%')where rnum >=11 and rnum <=20";
			rs = stmt.executeQuery(query);
			while(rs.next()){
				rnum = rs.getInt("rnum");
				bno = rs.getInt("bno");
				bcontent = rs.getString("bcontent");
				id = rs.getString("id");
				bdate = rs.getString("bdate");
				out.print("<br>"+",직원정보 : "+ rnum+",번호 : "+bno+",게시글 : "+bcontent+",작성자 : "+id+
						",작성일 : "+bdate);
		%> 
		<tr>
		<td><%=rnum %></td>
		<td><%=bno %></td>
		<td><%=bcontent %></td>
		<td><%=bcontent %></td>
		<td><%=bdate %></td>
		</tr>
		<%}%>	
			
			
			<% 
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
		}
		
			%>	
		
	</table>
	</div>
<body>

</body>
</html>