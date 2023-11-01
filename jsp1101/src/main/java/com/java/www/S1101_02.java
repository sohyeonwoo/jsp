package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/S02")
public class S1101_02 extends HttpServlet {
       

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	System.out.println("doAction");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String address = request.getParameter("address");
	
	String[] hobbys = request.getParameterValues("hobby"); //배열로 넘어올떄는 .getParameterValues
	String hobby = "";
	for(int i=0;i<hobbys.length;i++) {
		if(i==0) hobby=hobbys[i];
		else hobby +="," + hobbys[i];
		System.out.println(hobby);
	}
		response.setContentType("text/thml; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<html"
				+ "<head>"
				+ "<title>form Date</title>"
				+ "</head>"
				+ "<body>"
				+ "<h3>id: "+ id +"</h3>"
				+ "<h3>name: "+ name +"</h3>"
				+ "<h3>pw: "+ pw +"</h3>"
				+ "<h3>gender: "+ gender +"</h3>"
				+ "<h3>hobby: "+ hobby +"</h3>"
				+ "<h3>address: "+ address +"</h3>"
				+ "</body>"
				+ "</html>"
				+ ">");
		writer.close();
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

}
