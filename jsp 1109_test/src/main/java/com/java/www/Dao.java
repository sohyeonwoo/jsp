package com.java.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dao {
	Connection conn = null ;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Dto D=null;
	String query,id,pw,name,phone,gender,hobby;
	
	//회원가입 메소드
	public int inserMember(Dto D) {
		int result = 1;
		try {
			conn = getConnection();
			query = "insert into member values(?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,D.getId());
			pstmt.setString(2,D.getPw());
			pstmt.setString(1,D.getName());
			pstmt.setString(1,D.getPhone());
			pstmt.setString(1,D.getGender());
			pstmt.setString(1,D.getHobby());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	
		public Dto loginCheck(String uid,String upw) {
			try {conn=getConnection();// 메소드 호출
			query = "select * from member where id = ? and pw = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			rs=pstmt.executeQuery();
			if(rs.next()) 
			{
				id = rs.getString("id");
				pw = rs.getString("pw");
				name = rs.getString("name");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
				hobby = rs.getString("hobby");
				D = new Dto(id,pw,name,phone,gender,hobby);
			}
				
			} catch (Exception e) {
			}finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
			} 
			}
			return D;
		}
		public Connection getConnection() {
			Connection connection= null;
			try {
				Context context = new InitialContext();
				DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18");
				connection = ds.getConnection();
			} catch (Exception e) {
			}finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
			} 
			}
			return connection;
			}
		}
