package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
/*
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //출력을 UTF-8방식으로로 보냄.
		response.setContentType("text/html; charset=UTF-8"); //해석기가 읽을때 어떻게 일어야 하는지 알려준다. utf로 인식해라.
		
		 int result = 0;	
		
		 String result_ = request.getParameter("result");
		 
		 if(result_!=null) 
			 result = Integer.parseInt(result_);
		 
		 
		 
		PrintWriter out = response.getWriter();
		
	//웹문서는 골격을 가져가야한다.	
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"add\" method=\"post\">");
		out.write("<div>");
		out.write("<label>x : </label>");
		out.write("<input type=\"text\" name=\"x\" />");
		out.write("</div>");
		out.write("<div>");
		out.write("<label>y : </label>");
		out.write("<input type=\"text\" name=\"y\" />");
		out.write("</div>");
		out.write("<div>");        
		out.write("<input type=\"submit\" value=\"덧셈\" />");
		out.write("</div>");
		out.write("<div>");        
		out.write("결과 : ");
		out.printf("%d",result);
		out.write("</div>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); //출력을 UTF-8방식으로로 보냄.
		response.setContentType("text/html; charset=UTF-8"); //해석기가 읽을때 어떻게 일어야 하는지 알려준다. utf로 인식해라.
	
		
			String x_ = request.getParameter("x");
			String y_ = request.getParameter("y");
			
			Integer x =0;
			Integer y =0;
			
			if(x_!=null)
				x=Integer.parseInt(x_);
			if(y_!=null)
				y=Integer.parseInt(y_);
			
			int result = x+y;
			
			//서버에서 다른 서블릿을 요청하는 방법
			//1. 리디랙트 redirect - 전에 과정을 버리고 새로 신청
			response.sendRedirect("add?result="+result);
			//2. 포워드 forward - 전에 과정을 가지고 이어가기
			//request.getRequestDispatcher("add").forward(request, response);
	}
*/
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 response.setCharacterEncoding("UTF-8"); //출력을 UTF-8방식으로로 보냄.
		 response.setContentType("text/html; charset=UTF-8"); //해석기가 읽을때 어떻게 일어야 하는지 알려준다. utf로 인식해라.
	
		int result = 0;	
		
		if(request.getMethod().equals("POST")) { //getmethod() get요청이면 반환값 GET post요청이면 반환값 POST
			String x_ = request.getParameter("x");
			String y_ = request.getParameter("y");
			
			Integer x =0;
			Integer y =0;
			
			if(x_!=null)
				x=Integer.parseInt(x_);
			if(y_!=null)
				y=Integer.parseInt(y_);
			
			result = x+y;
		}
		
		PrintWriter out = response.getWriter();
		
	//웹문서는 골격을 가져가야한다.	
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"add\" method=\"post\">");
		out.write("<div>");
		out.write("<label>x : </label>");
		out.write("<input type=\"text\" name=\"x\" />");
		out.write("</div>");
		out.write("<div>");
		out.write("<label>y : </label>");
		out.write("<input type=\"text\" name=\"y\" />");
		out.write("</div>");
		out.write("<div>");        
		out.write("<input type=\"submit\" value=\"덧셈\" />");
		out.write("</div>");
		out.write("<div>");        
		out.write("결과 : ");
		out.printf("%d",result);
		out.write("</div>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
	}
	
}
