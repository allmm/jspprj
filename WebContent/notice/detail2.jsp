
<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

NoticeDao noticeDao = new FileNoticeDao();
Notice n = noticeDao.get(3);
//notice getNotice(int id)
/*
	List<Notice> notices = new ArrayList<>();
   FileInputStream fis = new FileInputStream("D:\\java\\workspace\\JSPprj\\WebContent\\WEB-INF\\data\\notice-file.df");
   Scanner fscan = new Scanner(fis);
   
   String line = "";
   
   Notice n = new Notice();
   
   int id_ = Integer.parseInt(request.getParameter("id"));
   
   
   while(fscan.hasNextLine()){ 
       line = fscan.nextLine();
       n = new Notice(line.split(","));
       notices.add(n);
   }
   
   fscan.close();
   fis.close();
   
   n = notices.get(id_);
 */
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>공지사항 페이지</h1>
    <table>
    	<tr>
	    	<td>제목 </td>
	    	<td><%=n.getTitle() %></td>
	    	<td>작성자</td>
	    	<td><%=n.getWriterId() %></td>
	    	<td>작성일</td>
	    	<td><%=n.getRegDate() %></td>
    	</tr>
    </table>
</body>
</html>