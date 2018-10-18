<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cg.ars.client.dto.Flight"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="shortcut icon" type="image/png" href="/resources/fav.png"/>
<title>Add Flight</title>
</head>
<body>
<jsp:include page='header.jsp'/>
	<div class="container">
		<div>
			<h1 align="center">Add Flight</h1>
			<div class="flightSearchBox">
			<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>
				<f:form action="addFlightAction" method="POST" modelAttribute="flight">
				<table border="3" align="center">
					<tr><td align="right">Flight No.:</td><td><f:input type="text" path="flightNo" placeholder="Flight No"/></td></tr>
					<tr><td align="right">Airline Name: </td><td>	<f:input type="text" path="airline" placeholder="Airline"/></td></tr>
					<tr><td align="right">From:		</td><td>	<f:input type="text" path="depCity" placeholder="From City"/></td></tr>
					<tr><td align="right">To: 		</td><td>	<f:input type="text" path="arrCity" placeholder="To City"/></td></tr>
					<tr><td align="right">Departure Date:</td><td> <f:input type="date" path="depDate" placeholder="Depature Date"/></td></tr>
					<tr><td align="right">Arrival Date:</td><td> 	<f:input type="date" path="arrDate" placeholder="Arrival Date"/></td></tr>
					<tr><td align="right">Departure Time:</td><td>	<f:input type="time" path="depTime" placeholder="Departure Time"/></td></tr>
					<tr><td align="right">Arrival Time:</td><td>	<f:input type="time" path="arrTime" placeholder="Arrival Time"/></td></tr>
					<tr><td align="right">First Seats:</td><td>	<f:input type="number" path="firstSeats" placeholder="First Seats"/></td></tr>
					<tr><td align="right">First Seats Fare:</td><td><f:input type="text" path="firstSeatsFare" placeholder="First Seat Fare"/></td></tr>
					<tr><td align="right">Business Seats:</td><td>  <f:input type="number" path="bussSeats" placeholder="Business Seat"/></td></tr>
					<tr><td align="right">Business Seat Fare:</td><td> <f:input type="text" path="bussSeatsFare" placeholder="Business Seat Fare"/></td></tr>
					<tr><td colspan="2" align="right"><input type="submit" value="Add Flight"></td></tr>
					
				</table>
				</f:form>
			</div>
			<div class="body"></div>
		</div>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
