<%@page import="org.eclipse.jdt.internal.compiler.ast.PrefixExpression"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<%-- <%
List<Map<String,String>> members = new ArrayList<>();
 Map<String,String> member;

	member = new HashMap<>();
	member.put("id","dragon");
	member.put("name","손오공");
	members.add(member);
	
	member = new HashMap<>();
	member.put("id","moon");
	member.put("name","문재인");
	members.add(member);
%> --%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>회원 목록</h1>
    <table border="1">
    	<tr>
    		<td>아이디</td>
    		<td>이름</td>
    	</tr>
    	<%-- <%for(int i=0; i<2;i++){ %>
    	<tr>
	    	<td><%=members.get(i).get("id")%></td> 
	    	<td><%=members.get(i).get("name")%></td>
    	</tr>
    	<%} %> --%>
    	<div><%=((int [])request.getAttribute("y"))[2] %>,${y[1]}</div>
    	<div>${member.name}</div>
    	<div>${x}</div>
    	<div>${x}</div>
    	<% int count = 1;
    		pageContext.setAttribute("count", count);%>
    	<div>${count}</div>
    	
    	<c:forEach begin="1" end="5">
    	hello<br>
    	</c:forEach>
    	
    	<c:forEach var="m" items="${members}">
    	<tr>
    	<td> ${m.id}</td>
    	<td> ${m.name}</td>
    	</tr>
    	</c:forEach>
    	
    	<%for(Map<String,String> m : ((List<Map<String, String>>)request.getAttribute("members"))){ %>
    	<tr>
	    	<td><%=m.get("id")%></td> 
	    	<td><%=m.get("name")%></td>
    	</tr>
    	<%} %>
    </table>
</body>
</html>