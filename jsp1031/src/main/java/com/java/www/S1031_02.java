package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/S02")
public class S1031_02 extends HttpServlet {
       

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("doAction");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		System.out.println("no : " +request.getParameter("no"));
		System.out.println("subject : " + Arrays.toString(request.getParameterValues("subject")));
		//배열을 subject 변수에 입력
		String[]subjects = request.getParameterValues("subject");
		String subject= "";
		
		for(int i=0; i<subjects.length;i++) {
			if(i==0) subject = subjects[i];
			else subject +=","+subjects[i];
		}
		
		
		writer.print("<html>");
		writer.print("<head><title>form date</title></head>");
		writer.print("<body>");
		writer.print("CheckBox subjeck배열 : " + Arrays.toString(request.getParameterValues("subject")));
		writer.print("<br>");
		writer.print("redio major : " + request.getParameter("major"));
		writer.print("<br>");
		writer.print("select address : " + request.getParameter("address"));
		writer.print("<br>");
		writer.print("</body>");
		writer.print("</html>");
		
		writer.close();
		
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
