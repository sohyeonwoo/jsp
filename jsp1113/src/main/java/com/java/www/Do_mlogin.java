package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.java.www.Dto.MemberDto;
import com.java.www.dao.MemberDao;

/**
 * Servlet implementation class Do_mlogin
 */
@WebServlet("/Do_mlogin")
public class Do_mlogin extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doAction");
	request.setCharacterEncoding("utf-8"); //한글처리
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	System.out.println("id : " +id);
	
	MemberDao mdao = new MemberDao();
	//id, pw 를 보내서 - 있으면 1개 정보 받음 , 없으면 null 받음
	MemberDto mdto = mdao.loginCheck(id,pw);
	String msg= "";
	String url= "";
	if(mdto==null) {
		msg = "아이디 또는 패스워드 불일치";
		url = "mlogin.jsp";
	}else {
		HttpSession session = request.getSession();
		session.setAttribute("session_id", id);
		msg = "로그인됨";
		url = "index.jsp";
		
	}//else
	response.setContentType("text/html; charset=utf-8");
	PrintWriter writer = response.getWriter();
	writer.println("<html>");
	writer.println("<head><title>로그인</title></head>");
	writer.println("<body>");
	writer.println("<script>");
	writer.println("alert('"+msg+"');");
	writer.println("location.href='"+url+"';");
	writer.println("</script>");
	writer.println("</body>");
	writer.println("</html>");
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
