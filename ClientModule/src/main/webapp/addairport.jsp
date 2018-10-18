<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="shortcut icon" type="image/png" href="/resources/fav.png"/>
<title>Add Airport</title>
</head>
<body>
<jsp:include page='header.jsp'/>
	<h1 align="center">Add Airport</h1>
	<table border="3" align="center">
	<f:form action="addAirportAction" method="POST" modelAttribute="airport">
	<tr><th colspan="2" align="center">Airport Details <img alt="location" src="/resources/airport.png"  width="64" height="64"></th></tr>
	<tr><td align="right"> Abbreviation :</td><td>	<f:input path="abbreviation" placeholder="Abbreviation" /> </td></tr>
	<tr><td align="right"> Airport Name :</td><td>	<f:input path="airportName" placeholder="Airport Name" />  </td></tr>
	<tr><td align="right"> Airport Location :</td><td>	<f:input path="location" placeholder="Location" />         </td></tr>
	<tr><td colspan="2" align="right">	<input type="submit" value="Add Airport" />                </td></tr>
	</f:form>
	</table>
<jsp:include page="footer.jsp"/>
</body>
</html>