<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="Date" value="<%=new java.util.Date()%>" />  
	<fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${Date}" /> <br>
	 
	<c:set var="Amount" value="99.14115"/>
	<fmt:formatNumber type="NUMBER" maxFractionDigits="3" value="${Amount}"/> <br>
	<fmt:formatNumber type="NUMBER" maxFractionDigits="5" value="${Amount}"/> <br>
	<fmt:formatNumber type="PERCENT" value="${Amount}"/> <br>
	<fmt:formatNumber type="CURRENCY" value="${Amount}" currencyCode="PLN"/>
</body>
</html>