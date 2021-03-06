<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="shortcut icon" type="image/png" href="/resources/fav.png"/>
<title>Success</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<c:if test="${not empty newAirport}">
	<div align="center">
		<h3>New Airport Added!</h3>
   		<h2>${newAirport.airportName}</h2>   
   	</div>
	</c:if>
	
	<c:if test="${not empty newFlight}">
	<div align="center">
		<h3>New Flight Added!</h3>
   		<h2>${newFlight.flightNo}</h2>
   		<h2>${newFlight.airline}</h2>  
   	</div>
	</c:if>
	
	<c:if test="${empty newAirport and empty newFlight}">
	<div align="center">
		<h3>Operation Unsuccessful!</h3> 
   	</div>
	</c:if>
<jsp:include page="footer.jsp"/>
</body>
</html>
