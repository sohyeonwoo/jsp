package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.MDoLoginService;
import com.java.www.service.Service;
import com.java.www.service.bDeleteService;
import com.java.www.service.BInsertService;
import com.java.www.service.BListService;
import com.java.www.service.BSelectOneService;



@WebServlet("*.do")
public class FController extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8"); //한글처리
		//파일이름 찾기
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		System.out.println("fileName : " + fileName);
		Service service = null;
		String url = null;
		
		switch (fileName) {
		case "/index.do":
			response.sendRedirect("index.jsp");
			break;
			
		case "/Login.do":
			response.sendRedirect("login.jsp");
			break;
		
		case "/memInsert.do":
			response.sendRedirect("memInsert.jsp");
			break;
			
		case "/doLogin.do":
			service = new MDoLoginService();
			service.execute(request, response);
			url = "doLogin.jsp";
			break;
		
		case "/logout.do":
			response.sendRedirect("logout.jsp");
			break;
			
		case "/bList.do": //게시글 전체 가져오기
			service = new BListService();
			service.execute(request, response);
			url = "bList.jsp";
			break;
		
		case "/bView.do": //게시글 1개 가져오기
			service = new BSelectOneService();
			service.execute(request, response);
			url = "bView.jsp";
			break;
		
		case "/bInsert.do": //게시글 쓰기 화면만 출력
			response.sendRedirect("bInsert.jsp");
			break;
	
		case "/doBInsert.do": //게시글 쓰기
			service = new BInsertService();
			service.execute(request, response);
			url = "doBInsert.jsp";
			break;
			
		case "/bUpdate.do": //게시글 수정화면만 출력
			service = new BSelectOneService();
			service.execute(request, response);
			url = "bUpdate.jsp";
			break;
		
		case "/doBUpdate.do": //게시글 수정 - update
			service = new com.java.www.service.BUpdateService();
			service.execute(request, response);
			url = "doBUpdate.jsp";
			break;
		
		case "/bDelete.do": //게시글 삭제 - update
			service = new bDeleteService();
			service.execute(request, response);
			url = "bDelete.jsp";
			break;
		
	   
		}
		
		//url이 있을때만 , dispatcher 사용
		if(url !=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

}
