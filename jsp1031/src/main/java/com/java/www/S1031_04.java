package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/S04")
public class S1031_04 extends HttpServlet {
       

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doAction");
	String id = getInitParameter("init_id");
	String pw = getInitParameter("init_pw");
	String path = getInitParameter("path");
	System.out.println("init_id : "+id);
	System.out.println("init_pw : "+pw);
	System.out.println("init_id : "+id);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doPost");
			doAction(request, response);
	}

}
