package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.www.Dto.MemberDto;

public class MemberDao {
	
	//인스턴스 변수
	//참조변수명 . 메소드 명
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String id,pw,name,phone,gender,hobby,query;
	MemberDto mdto = null;
	Timestamp mdate = null;
	
	public MemberDto loginCheck(String uid, String upw) {
		 mdto = null;
		//db접근해서 id,pw를 가지고 검색 select 있으면 1개 회원정보 가져옴, 없으면 null
		try {
			conn=getConnection();
			query = "select * from member where id = ? and pw = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("id"); // id는 sql 컬럼명을 넣는거임
				pw = rs.getString("pw"); // id는 sql 컬럼명을 넣는거임
				name = rs.getString("name"); // id는 sql 컬럼명을 넣는거임
				phone = rs.getString("phone"); // id는 sql 컬럼명을 넣는거임
				gender = rs.getString("gender"); // id는 sql 컬럼명을 넣는거임
				hobby = rs.getString("hobby"); // id는 sql 컬럼명을 넣는거임
				mdate = rs.getTimestamp("mdate"); // id는 sql 컬럼명을 넣는거임
				mdto = new MemberDto(id, pw, name, phone, gender, hobby , mdate);
			
			}
		
		} catch (Exception e) {e.printStackTrace();}
		finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {e2.printStackTrace();}
		}
		
		return mdto;
	}
	
	//커넥션 풀에서 conenction 객체 가져옴
	public Connection getConnection() {
		
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle18");
			connection = ds.getConnection();
		} catch (Exception e) {e.printStackTrace();}
		return connection;
	}//Connection


}
