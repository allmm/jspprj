package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class monami extends HttpServlet {
@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; chaset=UTF-8");
	
	String x_ = request.getParameter("x");
	String y_ = request.getParameter("y");
	
	Integer x = 0;
	Integer y = 0;
	
	if(x_!=null)
		x=Integer.parseInt(x_);
	if(y_!=null)
		y=Integer.parseInt(y_);
	
	PrintWriter out = response.getWriter();
	
	
		out.println(x+y);
	}
}
