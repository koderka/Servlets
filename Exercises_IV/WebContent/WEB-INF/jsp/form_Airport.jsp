<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<label>Wybierz lotnisko odlotu</label>
		<select name="departureAirport">
			<c:forEach var="depAirport" items="${airports}">
			<option value="${depAirport.code}">${depAirport.name}</option>
			</c:forEach>
		</select>
		<br>
		<label>Wybierz lotnisko przylotu</label>
		<select name="arrivalAirport">
			<c:forEach var="arrAirport" items="${airports}">
			<option value="${arrAirport.code}">${arrAirport.name}</option>
			</c:forEach>
		</select>
		<br>
		<label>Podaj czas wylotu</label>
		<input type="datetime-local" name="depTime">
		<br>
		<label>Podaj czas trwania lotu</label>
		<input type="number" name="duration" min="0" step="1">
		<br>
		<label>Podaj cene biletu</label>
		<input type="number" name="price" min="0" step="0.01">
		<br>
		<input type="submit" value="Podsumowanie">		
	</form>
</body>
</html>