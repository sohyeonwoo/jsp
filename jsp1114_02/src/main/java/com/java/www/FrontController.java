package com.java.www;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
       
    public FrontController() {
    }

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		
		//링크로 연결된 filename 알아내기
		String uri = request.getRequestURI();
		String upath = request.getContextPath();
		String fileName = uri.substring(upath.length());
		System.out.println("clickFillName : " + fileName);
		String url= "";
		
		if(fileName.equals("/login")) {
			url = "login.jsp";
		}else if(fileName.equals("/write.do")){
			url = "write.jsp";
		}else if(fileName.equals("/mwrite.do")){
			url = "mwrites.jsp";
		}else if(fileName.equals("/doLogin.do")){
			url = "doLogin";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
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
