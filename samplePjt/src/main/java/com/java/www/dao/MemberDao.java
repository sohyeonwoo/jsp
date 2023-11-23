package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.www.dto.MemberDto;

public class MemberDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MemberDto mdto;
	ArrayList<MemberDto> list = new ArrayList<MemberDto>();
	String id,pw,name,phone,gender,hobby,query;
	Timestamp mdate;
	int result;
	
	//db접근
		//커넥션풀에서 Connection 가져오기
		public Connection getConnection() {
			Connection connection = null;
			try {
				Context context = new InitialContext();
				DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18");
				connection = ds.getConnection();
				
				
			} catch (Exception e) {e.printStackTrace();}
			return connection;
		}//getConnection
		
		//로그인 체크 = select
		public MemberDto DoLoginSelect(String id2, String pw2) {
	try {
		conn=getConnection();
		query="select * from member where id=? and pw=?";
		pstmt=conn.prepareStatement(query);
		//1,2
		pstmt.setString(1, id2);
		pstmt.setString(2, pw2);
		rs = pstmt.executeQuery();
	
		if(rs.next()) {
			id = rs.getString("id");
			pw = rs.getString("pw");
			name = rs.getString("name");
			phone = rs.getString("phone");
			gender = rs.getString("gender");
			hobby = rs.getString("hobby");
			mdate = rs.getTimestamp("mdate");
			mdto = new MemberDto(id, pw, name, phone, gender, hobby, mdate);
			
		}
		
	} catch (Exception e) { e.printStackTrace();
	} finally {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e2) { e2.printStackTrace();
	    }
	}//finally
			
			return mdto;
		}
		
		//회원 1명 가져오기
		public MemberDto selectOne(String id2) {
			try {
				conn = getConnection();
				query="select * from member where id=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, id2);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					id = rs.getString("id");
					pw = rs.getString("pw");
					name = rs.getString("name");
					phone = rs.getString("phone");
					gender = rs.getString("gender");
					hobby = rs.getString("hobby");
					mdate = rs.getTimestamp("mdate");
					mdto = new MemberDto(id,pw,name,phone,gender,hobby,mdate);
				}
			} catch (Exception e) { e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e2) { e2.printStackTrace();
			    }
		}
			return mdto; //결과값은 mdto 나 null 로 id가 들어온다.
			//mdto 는 id 가 존재한다 .
			//null일때는 id가 존재하지 않는다 . 회원가입 같은 경우 null값이 나와야 회원가입 가능
}
}
