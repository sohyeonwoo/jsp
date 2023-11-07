package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.stax.StAXSource;

/**
 * Servlet implementation class S11071_01
 */
@WebServlet("/S01")
public class S1107_01 extends HttpServlet {
       

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		
		//servlet 에서 html 페이지 오픈할때
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				
				System.out.println("id : "+id);
				System.out.println("pw : "+pw);
				HttpSession session = request.getSession();
				PrintWriter writer = response.getWriter();
				
				
				if(id.equals("admin") && pw.equals("1111")) {
					session.setAttribute("session_id", id);
					session.setAttribute("session_nicName", "뉴진스");
					
					response.sendRedirect("jsp1107_01.jsp");
				}else {
					writer.println("<script>");
					writer.println("alert('아이디 또는 패스워드 불일치')");
					writer.println("location.href='jsp_login.jsp';");
					writer.println("</script>");
					
				}
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
