package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Do_bwrite")
public class Do_bwrite extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("doAction");
		// 파일첨부
		// String uPath = request.getRealPath("upload");
		String uPath = "c:/upload";
		int size = 10 * 1024 * 1024; // 10mb *1024kb*1024b //requests , 파일저장경로 , 파일크기 , 인코딩 , 같은이름 변경정책
		MultipartRequest multi = new MultipartRequest(request, uPath, size, "utf-8", new DefaultFileRenamePolicy());
		String btitle = multi.getParameter("btitle");
		String id = multi.getParameter("id");
		String bcontent = multi.getParameter("bcontent");
		Enumeration files = multi.getFileNames();

		// 파일이름 가져오기
		// Enumeration files = multi.getFileNames();
		// 원본이름 //1개 가져오기
		String file1 = (String) files.nextElement();
		String bfile = multi.getFilesystemName(file1);
		BoardDto bdto = new BoardDto(btitle, bcontent, id, bfile);
		BoardDao bdao = new BoardDao();
		int result = bdao.insertOne(bdto);
		
		//페이지 이동
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>게시글저장</title></head>");
		writer.println("<body>");
		writer.println("<script>");
		writer.println("alert('게시글 저장');");
		writer.println("location.href='blist.jsp';");
		writer.println("</script>");
		writer.println("</body>");
		writer.println("</html>");
		
		System.out.println(btitle);
		System.out.println(id);
		System.out.println(bcontent);
		
	}//doAction
		

//		String[] bfile = new String[3];
		// 실제파일업로드 이름
		// String[] file_arr = new String[3];

		// 파일 여러개 (현재는 3개 설정)
//		int  i=0;
//		while(files.hasMoreElements()) {
//		     file_arr[i] = (String) files.nextElement();	
//		     bfile[i] = multi.getFilesystemName(file_arr[i]);
//		     i++;
//		}
		// 3개일때
//		for(i=0;i<file_arr.length;i++) {
//			System.out.println("원본파일이름 : "+file_arr[i]);
//			System.out.println("변경된 파일이름 : "+bfile[i]);
//		}


		// 1개일때
		//System.out.println("원본파일이름 : " + file1);
		//System.out.println("변경된 파일이름 : " + bfile);
		// 파일이 2개 이상일때
		// while(files.hasMoreElements()) {
		// String file = (String) files nextFlement();
		 //}

	//}
//
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

}
