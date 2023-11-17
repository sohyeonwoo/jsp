package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.www.dto.BoardDto;

public class BoardDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BoardDto bdto = null;
	ArrayList<BoardDto> list = new ArrayList<BoardDto>();
	int bno,bgroup,bstep,bindent,bhit;
	String btitle,bcontent,id,bfile,query="";
	Timestamp bdate;
	int result ;
	
	
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
		
		
		//게시글 전체 가져오기 = selectAll
		public ArrayList<BoardDto> bList() {
			try {
				conn=getConnection();
				query="select * from (select ROW_NUMBER() OVER (order by bgroup desc,bstep asc) rnum,a. * from board a) where rnum >=1 and rnum <=10";
				pstmt=conn.prepareStatement(query);
				//1,2번 넣기
				rs=pstmt.executeQuery();
				while(rs.next()) {
					bno = rs.getInt("bno");
					btitle=rs.getString("btitle");
					bcontent=rs.getString("bcontent");
					bdate=rs.getTimestamp("bdate");
					id=rs.getString("id");
					bgroup=rs.getInt("bgroup");
					bstep=rs.getInt("bstep");
					bindent=rs.getInt("bindent");
					bhit=rs.getInt("bhit");
					bfile=rs.getString("bfile");
					list.add(new BoardDto(bno, btitle, bcontent, bdate, id, bgroup, bstep, bindent, bhit, bfile));
				}
				//확인용
				System.out.println("BoardDao bList bno : " + list.get(0).getBno());
				
			} catch (Exception e) { e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e2) { e2.printStackTrace();
			    }
			}//finally
			return list;
		}

		//게시글 1개 가져오기
		public BoardDto selectOne(int bno2) {
			
		try {
			conn=getConnection();
			query="select * from board where bno = ?";
			pstmt=conn.prepareStatement(query);
			//1,2번 넣기
			pstmt.setInt(1, bno2);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bno = rs.getInt("bno");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getTimestamp("bdate");
				id = rs.getString("id");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bhit = rs.getInt("bhit");
				bfile = rs.getString("bfile");
				bdto = new BoardDto(bno, btitle, bcontent, bdate, id, bgroup, bstep, bindent, bhit, bfile);
				
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
			return bdto;
		}
		
		//게시글 1개 쓰기 = insert

		public int bInsert(BoardDto bdto2) {
			try {
				conn=getConnection();
				query="insert into board values(board_seq.nextval,?,?,sysdate,?,board_seq.currval,0,0,1,?)";
				pstmt=conn.prepareStatement(query);
				//1,2번 넣기
				pstmt.setString(1,bdto2.getBtitle());
				pstmt.setString(3,bdto2.getBcontent());
				pstmt.setString(2,bdto2.getId());
				pstmt.setString(4,bdto2.getBfile());
				
				
				result = pstmt.executeUpdate();
			} catch (Exception e) { e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e2) { e2.printStackTrace();
			    }
			}//finally
			
			return result;
		}

		//게시글 수정
		public int bUpdate(BoardDto bdto2)  {
			try {
				conn = getConnection();
				query="update board set btitle=?,bcontent=?,bdate=sysdate,bfile=? where bno=?";
				pstmt = conn.prepareStatement(query);
				//1,2
				pstmt.setString(1,bdto2.getBtitle());
				pstmt.setString(2,bdto2.getBcontent());
				pstmt.setString(3,bdto2.getBfile());
				pstmt.setInt(4,bdto2.getBno());
				result = pstmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e2) { e2.printStackTrace();
			    }
		}
			return result;
}//class

		//게시글 삭제 -delete
		public int bDelete(int bno2) {
			try {
				conn = getConnection();
				query = "delete board where bno=?";
				pstmt = conn.prepareStatement(query);
				//1
				pstmt.setInt(1, bno2);
				result=pstmt.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e2) { e2.printStackTrace();
			    }
		}
			
			return result;
		}
}
