package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.OracleNoticeDao;
import com.newlecture.web.entity.Notice;

@WebServlet("/notice/edit")
public class EditController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//request.setCharacterEncoding("UTF-8");//컨트롤러마다 지정해야 해서 불편하다-> 서블릿 필터 사용하자
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		NoticeDao noticeDao = new OracleNoticeDao();
		Notice n;
		int result =0;
		
		try {
			n = noticeDao.get(id);
			n.setTitle(title);
			n.setContent(content);
			result = noticeDao.update(n);
			request.setAttribute("notice", noticeDao.get(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("../WEB-INF/view/notice/detail.jsp").forward(request, response);
		if(result != 1)
			response.sendRedirect("error");
		else
			response.sendRedirect("detail?id="+id);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("../WEB-INF/view/notice/edit.jsp").forward(request, response);
	}
	
}
