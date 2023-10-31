package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Mc")
public class Mcontroller extends HttpServlet {
       
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("testAction");
		System.out.println("doAction");
		
		
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		String logg = request.getParameter("logg");
		String pww = request.getParameter("pww");
		response.setContentType("text/html; charser=utf-8");
		
		String str_script = "";
		if(logg.equals("aaa") && pww.equals("1111"));
		{
			str_script = "alert('login 되었습니다.');";
			str_script += "history.back();";
			
		}
		PrintWriter writer = response.getWriter();
		writer.println("<html><head>"
				+ "<script>"
				+ "str_script"
				+ "</script>"
				+ "</head><body>"
				+ "ID : "
				+ logg
				+ "<br>"
				+ "PASSWORD : "
				+ pww
				+ "</body></head>");
		writer.close();
;		
		
		
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request,response);
	}

}
