package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.BoardService;
import com.java.www.service.DoLoginMemberService;
import com.java.www.service.MemberService;
import com.java.www.service.listBoardService;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		String url = null;
		String uri = request.getRequestURI();
		System.out.println("uri : "+uri);
		String conPath = request.getContextPath();
		System.out.println("context path : " + conPath);
		
		String fileName = uri.substring(conPath.length());
		System.out.println("fileName : " + fileName);
		
		
		if(fileName.equals("/login.do")) {
			System.out.println("mainpage 이동");
			response.sendRedirect("login.jsp");
			
		}else if(fileName.equals("/dologin.do")){
			System.out.println("login 여부 확인 page 이동");
			//객체선언후 호출
			MemberService memberService = new DoLoginMemberService();
			memberService.execute(request, response);
			url = "doLogin.jsp";
			System.out.println("test frontcontroll dologin");
			
			
		}else if(fileName.equals("/write.do")) {
			System.out.println("회원가입 page 이동");
			response.sendRedirect("mwrite.jsp");
			
		}else if(fileName.equals("/list.do")) {
			System.out.println("게시판 이동");
			//service연결
			BoardService boardService = new listBoardService();
			boardService.execute(request, response);
			
			url="list.jsp";
			//db정보 필요 dispatcher 필요
		}else if(fileName.equals("/logout.do")) {
			System.out.println("logout page 이동");
			response.sendRedirect("logout.jsp");
		
		}else if(fileName.equals("update.do")) {
			System.out.println("update page 이동");
			//db정보 필요 dispatcher 필요 
			
		}
		
		//url 이동
		if(url!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
		System.out.println("doPost");
	}

}
