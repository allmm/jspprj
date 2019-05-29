
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%
   
	FileInputStream fis = new FileInputStream("D:\\java\\workspace\\JSPprj\\WebContent\\WEB-INF\\data\\notice-file.df");
	Scanner fscan = new Scanner(fis,"UTF-8");
	   
   String line = "";
   
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
    <%if(fscan.hasNextLine()){ 
           line = fscan.nextLine();
         Notice n = new Notice(line.split(","));
         %>
    	<tr>
	    	<td>제목 </td>
	    	<td></td>
	    	<td>작성자</td>
	    	<td></td>
	    	<td>작성일</td>
	    	<td></td>
    	</tr>
    	 <%} %>
    </table>
</body>
</html>
<%
   fscan.close();
   fis.close();
%>