package com.java.www;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/S01")
public class S1101_01 extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8"); //post 한글처리
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender"); //남과여
		String address = request.getParameter("address"); //서울
		
		String[] hobbys = request.getParameterValues("hobby"); //게임,골프,요리
		String hobby = "";
		for(int i=0;i<hobbys.length;i++){
			if(i==0) hobby =hobbys[i];
			else hobby+=","+ hobbys[i];
			System.out.println(hobby);
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>"
				+ "<head>"
				+ "<title>form데이터 결과</title>"
				+ "</head>"
				+ "<body>"
				+ "<h3>id : "
				+ id
				+ "</h3>" 
				+ "<h3> name : "
				+ name
				+ " </h3>" 
				+ "<h3> pw : "
				+ pw
				+ " </h3>"
				+ "<h3> gender : "
				+ gender
				+ " </h3>"
				+ "<h3> hobby : "
				+ hobby
				+ " </h3>"
				+ "<h3> hobby 배열 : "
				+ Arrays.toString(hobbys)
				+ " </h3>"
				+ "<h3> address : "
				+ address
				+ " </h3>"
				+ "</body>"
				+ "</html>");
		writer.close();
		
	
		
		
		
		
	
	
	
	}//doAction
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}//doPost
}//CLASS