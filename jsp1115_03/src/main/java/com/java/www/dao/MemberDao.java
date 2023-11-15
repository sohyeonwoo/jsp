package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.java.www.dto.MemberDto;

public class MemberDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MemberDto mdto = null;
	ArrayList<MemberDto> list = new ArrayList<MemberDto>();
	String id,pw,name,phone,gender,hobby,query="";
	Timestamp mdate;
	
	//login check 하기
	public MemberDto 
}
