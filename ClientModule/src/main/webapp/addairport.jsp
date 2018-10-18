<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Airport</title>
</head>
<body>
	<h3>Add Airport</h3>
	<f:form action="addAirportAction" method="POST" modelAttribute="airport">
		<f:input path="abbreviation" placeholder="Abbreviation" />
		<f:input path="airportName" placeholder="Airport Name" />
		<f:input path="location" placeholder="Location" />
		<input type="submit" value="Add Airport" />
	</f:form>
</body>
</html>