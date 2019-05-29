package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Nana extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		response.setCharacterEncoding("UTF-8"); //출력을 UTF-8방식으로로 보냄.
		response.setContentType("text/html; charset=UTF-8"); //해석기가 읽을때 어떻게 일어야 하는지 알려준다. utf로 인식해라.

		// /hello?cnt=3 <-실행
		// /hello? <-null cnt가 null
		// /hello <-null
		String cnt_ = request.getParameter("cnt");
		Integer cnt = 0;
		
		if(cnt_!=null)
			cnt=new Integer(cnt_);
		PrintWriter out = response.getWriter();
		for(int i=0; i<cnt; i++)
			out.println("홈홈홈홈홈 wellcome<br>");
	}

}
