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
<title>Flight Search Result</title>
</head>
<body>
<jsp:include page='header.jsp'/>
<div class="container">
<c:if test="${empty flightList}">
<h3>No flights found from ${fromCity} to ${toCity} on ${depDate}</h3>
</c:if>
<c:if test="${not empty flightList}">
<h3>Flights from ${fromCity} to ${toCity} on ${depDate}</h3>
<div class="resultTable">
	<table border="3" align="center">
		<tr align="center">
			<th>Flight Number</th>
			<th>Airline</th>
			<th>Departure Time</th>
			<th>Arrival Time</th>
			<th>Choose Class</th>
			<th>Book Now</th>
		</tr>
    	<c:forEach items="${flightList}" var="result">
    		<tr align="center">
    			<td>${result.flightNo}</td>
    			<td>${result.airline}</td>
    			<td>${result.depTime}</td>
    			<td>${result.arrTime}</td>
    			<form action="/ars/newBooking/${result.flightNo}" Method="get" id="bookform${result.flightNo}">
    			<td>
	    			<input type="radio" name="class" value="First@${result.firstSeatsFare}" checked> FirstClass: ${result.firstSeatsFare}<br/>
	  				<input type="radio" name="class" value="Business@${result.bussSeatsFare}"> BusinessClass: ${result.bussSeatsFare}
  				</td>
  				<td><button type="submit" class="btn btn-danger" form="bookform${result.flightNo}">Book</button></td>
  				</form>
    		</tr>
    	</c:forEach>
	</table>
</div>
</c:if>
</div>
<jsp:include page='footer.jsp'/>
</body>
</html>
