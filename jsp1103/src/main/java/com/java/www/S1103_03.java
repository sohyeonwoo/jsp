package com.java.www;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S1103_03
 */
@WebServlet("/S03")
public class S1103_03 extends HttpServlet {
       
    public S1103_03() {
    }

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doAction");
	
	int page = Integer.parseInt(request.getParameter("page"));
	String searchword = request.getParameter("searchword");
	int startrow = (10*(page-1)) +1;
	int endrow = page*10;
	
	
	System.out.println("호출된 페이지 : " + page);
	System.out.println("가져올 번호 : " + startrow);
	System.out.println("가져올 last번호 : " +endrow);
	System.out.println("넘어온 검색어 : " +searchword);
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
