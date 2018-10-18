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
<h3>Showing search Results for all flights from ${fromCity} To ${toCity} on ${depDate}</h3>
<c:forEach items="${flightList}" var="result">
    <div class="resultTable">
    	<table>
    		<tr>
    			<th>Flight Number</th>
    			<th>Airline</th>
    			<th>Dep Time</th>
    			<th>Arrival Time</th>
    			<th>Choose Class</th>
    			<th>Book Now</th>
    		</tr>
    		<tr>
    			<td>${result.flightNo}</td>
    			<td>${result.airline}</td>
    			<td>${result.depTime}</td>
    			<td>${result.arrTime}</td>
    			<td>
    			<form action="/ars/newBooking/${result.flightNo}" Method="get" id="bookform">
    				<input type="radio" name="class" value="First@${result.firstSeatsFare}" checked> FirstClass: ${result.firstSeatsFare}<br>
  					<input type="radio" name="class" value="Business@${result.firstSeatsFare}"> BusinessClass: ${result.bussSeatsFare}
  				</form>
  				</td>
  				<td><button type="submit" class="btn btn-danger" form="bookform" >Book</button></td>
    		</tr>
    	</table>
    </div>
</c:forEach>
</div>
<jsp:include page='footer.jsp'/>
</body>
</html>

