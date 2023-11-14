package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;

/**
 * Servlet implementation class doLogin
 */
@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
       
    public doLogin() {
    }

	protected void doAtion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAtion");
		request.setCharacterEncoding("utf-8");
		//아이디 패스워드 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//MemberDao 로 send
		//1. 객체선언
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.loginCheck(id,pw);
		
		//mdto 1개 or 0개 (0개는 null)
		String msg = "";
		String url = "";
		
		if(mdto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("session_id",mdto.getId());
			session.setAttribute("session_name",mdto.getName());
			
			msg = "login 됨";
		    url = "main.jsp";
		    }else {
		    	msg = "login 안 됨";
		    	url = "login.jsp";
		    }
		//html page 호출
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = request.getWriter();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAtion(request, response);
		System.out.println("doGet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAtion(request, response);
		System.out.println("doPost");
	}

}
