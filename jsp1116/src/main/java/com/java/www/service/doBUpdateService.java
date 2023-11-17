package com.java.www.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class doBUpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//bno id btitle bcontent bfile,oldbfile
		String upload="c:/upload";
		int size = 10*1024*1024;
		int bno = 0;
		String id ="";
		String btitle ="";
		String bcontent ="";
		String bfile ="";
		String oldBfile ="";
		
		
		try {
			MultipartRequest multi = new MultipartRequest(request, upload, size, "utf-8", new DefaultFileRenamePolicy());
			 bno = Integer.parseInt(multi.getParameter("bno"));
			 id = multi.getParameter("id");
			 btitle = multi.getParameter("btitle");
			 bcontent = multi.getParameter("bcontent");
			 oldBfile = multi.getParameter("oldBfile");
			 System.out.println("두비업데이트서비스 올드비파일: "+oldBfile);
			
			//파일이름
			Enumeration files = multi.getFileNames();
			//
			if(files.hasMoreElements()) {
					
					String f = 	(String)files.nextElement();
					bfile = multi.getFilesystemName(f); //신규로 파일이 등록될때 
				}
		
			if(files==null) {
				
				System.out.println("파일없음 두비업데이트서비스");
				bfile = oldBfile; //새로운 파일수정이 없으면 기존파일로 저장
			}
		
			
			
			BoardDto bdto = new BoardDto(bno, btitle, bcontent, id, bfile);
			//dao접근
			BoardDao bdao = new BoardDao();
			int result = bdao.doBUpdate(bdto);
			
			//request 객체 추가
			request.setAttribute("result",result);
			request.setAttribute("bno",bno);
			
		} catch (IOException e) {e.printStackTrace();
	}
	
     }
	   }
	

