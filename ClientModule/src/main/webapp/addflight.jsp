<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cg.ars.client.dto.Flight" %>
<!DOCTYPE html>
<html>
<head>
<style>
input {
    width: 50%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    resize: vertical;
}
</style>
<meta charset="ISO-8859-1">
<title>Add Flight</title>
</head>
<body>
	<div class="container">
		<div>
			<h3>Add Flight</h3>
			<div class="flightSearchBox">
			<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>
				<f:form action="addFlightAction" method="POST" modelAttribute="flight">
					Flight No. : 	<f:input type="text" path="flightNo" placeholder="Flight No"/><br>
					Airline Name: 	<f:input type="text" path="airline" placeholder="Airline"/><br>
					From:			<f:input type="text" path="depCity" placeholder="From City"/><br>
					To: 			<f:input type="text" path="arrCity" placeholder="To City"/><br>
					Departure Date: <f:input type="date" path="depDate" placeholder="Depature Date"/><br>
					Arrival Date: 	<f:input type="date" path="arrDate" placeholder="Arrival Date"/><br>
					Departure Time:	<f:input type="time" path="depTime" placeholder="Departure Time"/><br>
					Arrival Time:	<f:input type="time" path="arrTime" placeholder="Arrival Time"/><br>
					First Seats:	<f:input type="number" path="firstSeats" placeholder="First Seats"/><br>
					First Seats Fare:<f:input type="text" path="firstSeatsFare" placeholder="First Seat Fare"/><br>
					Business Seats:  <f:input type="number" path="bussSeats" placeholder="Business Seat"/><br>
					Business Seat Fare: <f:input type="text" path="bussSeatsFare" placeholder="Business Seat Fare"/><br>
					<input type="submit" value="Search">
				</f:form>
			</div>
			<div class="body">Rest of the body</div>
		</div>
	</div>
</body>
</html>