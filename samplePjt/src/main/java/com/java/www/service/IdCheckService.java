package com.java.www.service;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;

public class IdCheckService {
	
	
	//dao 접근
	public String idCheck(String id) {
		String result = null;
		//dao 접근
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.selectOne(id);
		if(mdto==null) 
			result ="사용가능"; else result="사용불가능";
		return result;
	}
}
