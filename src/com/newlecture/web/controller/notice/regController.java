package com.newlecture.web.controller.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.jws.WebService;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.OracleNoticeDao;
import com.newlecture.web.entity.Notice;
 @WebServlet("/notice/reg")
 @MultipartConfig(
		 location="d:\\temp",   
		 fileSizeThreshold = 1024*1024,
		 maxFileSize = 1024*1024*5, //5�ް�
		 maxRequestSize = 1024*1024*5*5 // 5�ް� 5������
		)
public class regController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//request.setCharacterEncoding("UTF-8");//��Ʈ�ѷ����� �����ؾ� �ؼ� �����ϴ�-> ���� ���� �������
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Part filePart = request.getPart("file");
		
		//1. ���ε� ��� ���
		String urlPath = "/upload";
		String path = request.getServletContext().getRealPath(urlPath);
		
		System.out.println(path); //
		
		//2. ���ε�� ���ϸ� ���
		String fileName = filePart.getSubmittedFileName();
		
		//3.��� ������
		
		String filePath = path + File.separator + fileName; // "\\" �ü������ ��� ǥ������ �ٸ�.
		
		System.out.println(filePath);
		
		//4. ��ΰ� ���ٴ� ��������
		File pathFile = new File(path);
		if(!pathFile.exists())
			pathFile.mkdirs();
		
		//5. ������ ���ϸ� ��ο� �̹� �����ϴ� ���� : �̸� ��å
		//aa.jpg->aa1.jpg->aa(1).jpg
		
		File newPathFile = new File(filePath);
		if(newPathFile.exists()) {
			String headFileName = fileName.substring(0,fileName.indexOf("."));
			if(headFileName.contains(")"))
				path = "D:\\tools\\"+fileName+".jpg";;
			
		}
		
		
		File sameFile = new File(filePath);
         
        if(sameFile.exists()) {            
           
        	int n = fileName.lastIndexOf(".");         
        	String name = fileName.substring(0, n);
        	String suffix = fileName.substring(n);         
        	
        	int parenS = name.lastIndexOf("(");
        	int parenE = name.lastIndexOf(")");
        	
        	String indexC = name.substring(parenS+1, parenE);
        	
        	int indexN = Integer.parseInt(indexC);         
        	
        	if (parenS == -1)
               fileName = name +"("+ 1 +")"+ suffix;
            else {
              indexN++;
               fileName = fileName.substring(0, parenS+1)+ indexN +")"+ suffix;
            }         
        }
		
		
		
		
		InputStream fis = filePart.getInputStream();
		FileOutputStream fos = new FileOutputStream("D:\\tools\\pic.png");
		
		byte[] buf = new byte[1024];
		int size =0;
		
		while((size=fis.read(buf))!=-1)
			fos.write(buf, 0, size);
			
		fis.close();
		fos.close();
		
		System.out.println(title);
		
		NoticeDao noticeDao = new OracleNoticeDao();
		Notice n = new Notice();
		int result =0;
		
		try {
			
			n.setTitle(title);
			n.setContent(content);
			result = noticeDao.insert(n);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("../WEB-INF/view/notice/detail.jsp").forward(request, response);
//		if(result != 1)
//			response.sendRedirect("error");
//		else
//			response.sendRedirect("list");

 
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		request.getRequestDispatcher("/WEB-INF/view/notice/reg.jsp").forward(request, response);
	}
}
