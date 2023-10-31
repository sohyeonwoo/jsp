package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/S03")
public class S1031_03 extends HttpServlet {
       

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doAction");
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int math = Integer.parseInt(request.getParameter("math"));
	int total = kor+eng+math;
	double avg = total/3.0;
	String str_avg = String.format("%.2f", avg);
	double d_avg = Double.parseDouble(str_avg);
	//oracle->round(avg,2);
	System.out.println("합계 : "+(kor+eng+math));
	String major = request.getParameter("major");
			String address = request.getParameter("address");
			String[] subjects = request.getParameterValues("subject");
			String subject = "";
			for(int i=0;i<subjects.length;i++) {
				if(i==0) subject = subjects[i];
				else subject += subjects[i];
			}
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.print("<head><title>form date</title></head>");
			writer.print("<body>"
					+ "	<section>\r\n"
					+ "			<form name=\"frm\" method=\"get\" action=\"S03\">\r\n"
					+ "			<table>\r\n"
					+ "				<tr>\r\n"
					+ "					<th>학번</th>\r\n"
					+ "					<td>\r\n"
					+ no
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "				<tr>\r\n"
					+ "					<th>이름</th>\r\n"
					+ "					<td>\r\n"
					+ name
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "				<tr>\r\n"
					+ "					<th>국어</th>\r\n"
					+ "					<td>\r\n"
					+ kor
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "				<tr>\r\n"
					+ "					<th>영어</th>\r\n"
					+ "					<td>\r\n"
					+eng
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "				<tr>\r\n"
					+ "					<th>수학</th>\r\n"
					+ "					<td>\r\n"
					+ math
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "				<tr>\r\n"
					+ "					<th>계열선택</th>\r\n"
					+ "					<td id=\"major01\">\r\n"
					+ major
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "				<tr>\r\n"
					+ "					<th>좋아하는 과목</th>\r\n"
					+ "					<td id=\"subject01\">\r\n"
					+ subject
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "				<tr>\r\n"
					+ "					<th>주소</th>\r\n"
					+ "					<td id=\"address01\">\r\n"
					+ address
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "			</table>\r\n"
					+ "				\r\n"
					+ "			</form>\r\n"
					+ "		</section>");
			writer.print("</body>");
			writer.println("</html>");
			
	
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
