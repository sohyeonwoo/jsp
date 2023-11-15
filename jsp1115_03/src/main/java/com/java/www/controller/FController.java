package com.java.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FController
 */
@WebServlet("*.do")
public class FController extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction method 호출 ");
		request.setCharacterEncoding("utf-8");
		String url = null;
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		System.out.println("호출한 fileName : " + fileName);
		
		if(fileName.equals("/index.do")) {
			System.out.println("index.jsp 페이지를 열어줍니다.");
			url = "index.jsp";
		}else if(fileName.equals("/login.do")) {
			System.out.println("login.jsp 페이지를 열어줍니다.");
			url="login.jsp";
		}else if(fileName.equals("/mwrite.do")) {
			System.out.println("mwrite.jsp 페이지로 이동합니다.");
			response.sendRedirect(mwrite.jsp);
		}else if(fileName.equals("/logout.do")) {
			System.out.println("logout.jsp 페이지를 열어줍니다.");
			response.sendRedirect("logout.jsp");
		}else if(fileName.equals("/list.do")) {
			System.out.println("logout.jsp 페이지를 열어줍니다.");
			//db 에 접근이 필요함 . ArrayList
			//RequestDispatcher forword
			
			
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
