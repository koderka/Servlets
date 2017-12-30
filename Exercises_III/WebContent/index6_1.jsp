<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> Witaj na stronie 1 </p> <br>
	<a href="index6_2.jsp"> Link do strony 2 </a> <br>
	<a href="index6_3.jsp"> Link do strony 3 </a> <br>
	<a href="index6_4.jsp"> Link do strony 4 </a> <br>
	<a href="index6_5.jsp"> Link do strony 5 </a> <br>
	<%
	HttpSession sess = request.getSession();
	%>
</body>
</html>