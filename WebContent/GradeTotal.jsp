<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
int total = 0;

if(request.getMethod().equals("POST")){
	String x_ = request.getParameter("kor");
	String y_ = request.getParameter("eng");
	String z_ = request.getParameter("math");
	
	Integer x = 0;
	Integer y = 0;
	Integer z = 0;

	if(x_!=null&&y_!=null&&z_!=null)
		x=Integer.parseInt(x_);
	if(x_!=null&&y_!=null&&z_!=null)
		y=Integer.parseInt(y_);
	if(x_!=null&&y_!=null&&z_!=null)	
		z=Integer.parseInt(z_);

	
	total = x+y+z;
}


%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>복습</title>
</head>
<body>
	<form action="GradeTotal.jsp"method="post">
	<div>
	<label>국어 : </label>
	<input type="text"name="kor">
	</div>
	<div>
	<label>영어 : </label>
	<input type="text"name="eng">
	</div>
	<div>
	<label>수학 : </label>
	<input type="text"name="math">
	</div>
	<div>
	<input type="submit"value="합계">
	결과 : <%=total %>
	</div>
	
	</form>

</body>
</html>