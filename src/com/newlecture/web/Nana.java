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
				
		response.setCharacterEncoding("UTF-8"); //����� UTF-8������η� ����.
		response.setContentType("text/html; charset=UTF-8"); //�ؼ��Ⱑ ������ ��� �Ͼ�� �ϴ��� �˷��ش�. utf�� �ν��ض�.

		// /hello?cnt=3 <-����
		// /hello? <-null cnt�� null
		// /hello <-null
		String cnt_ = request.getParameter("cnt");
		Integer cnt = 0;
		
		if(cnt_!=null)
			cnt=new Integer(cnt_);
		PrintWriter out = response.getWriter();
		for(int i=0; i<cnt; i++)
			out.println("ȨȨȨȨȨ wellcome<br>");
	}

}
