package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.stax.StAXSource;

/**
 * Servlet implementation class DoM_login
 */
@WebServlet("/doLogin")
public class DoM_login extends HttpServlet {
       
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("DoM_login doAction");
	HttpSession session = request.getSession();
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String upw = request.getParameter("pw");
	String msg = "";
	String url = "";
	
	System.out.println("id : "+uid);
	System.out.println("pw : "+upw);
	
	MemberDao mdao = new MemberDao();
	MemberDto mdto = mdao.loginCheck(uid, upw);
	
	if(mdto==null) {
		msg = "아이디 또는 패스워드 불일치";
		url = "m_login.jsp";
	}else {
		msg = "로그인 됨";
	url = "m_main.jsp";
	session.setAttribute("session_id", uid);
	session.setAttribute("session_nicName", uid);
	
	}
	
	response.setContentType("text/html; charset=utf-8");
	PrintWriter writer = response.getWriter();
	writer.println("<html>");
	writer.println("<head>");
	writer.println("<title>login check</title>");
	writer.println("</head>");
	writer.println("<body>");
	writer.println("<script>");
	writer.println("alert('"+msg+"')");
	writer.println("location.href = '"+url+"';");
	writer.println("</script>");
	writer.println("</body>");
	writer.println("</html>");
	
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
