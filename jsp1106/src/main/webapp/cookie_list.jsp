<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>쿠키 검색</title>
	</head>
	<body>
	   <h1>쿠키 검색</h1>
	   <% // 쿠키설정 : ck1, ck2가 들어가 있음
	      Cookie[] cks = request.getCookies(); //쿠키 배열로 받음
	      if(cks != null){
	    	  for(int i=0;i<cks.length;i++){
	    		  out.println("쿠키 "+(i+1)+" : "+cks[i].getName()+"<br>");
	    		  out.println("쿠키 "+(i+1)+" : "+cks[i].getValue()+"<br>");
	    		  out.println("======<br>");
	    	  }
	      }
	   %>
	   <a href="jsp1106_02.jsp">쿠키생성</a>
	   <a href="cookie_doDelete.jsp">쿠키 삭제</a>
	</body>
</html>