<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="shortcut icon" type="image/png" href="/resources/fav.png"/>
<title>Payments</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
<div class="hero"> 
<table border="3" align="center">
<tr align="center">
<th colspan="2" >Passenger Details</th>
</tr>
<tr align="center">
<th>Name:</th><th>${name}</th>
</tr>
<tr align="center">
<th>Number of Passengers:</th><th>${noOfPassengers}</th>
</tr>
<tr align="center">
<th colspan="2">Enter payment details</th>
</tr>
</table>
<table align="center" border="2">
<form class="form-horizontal" action="/ars/confirmBooking" method="post">
<div class="form-group">
<tr align="center"><th><label class="control-label">Enter 16-digit Credit Card Number:</label></th>
     <div class="col-sm-10">
<th><input class="form-control" id="focusedInput" type="text" name="creditCardInfo" pattern=".{16}" required></th></tr>
     </div>
</div>
<input type="hidden" name="bookingId" value="${bookingId}">
<input type="hidden" name="flightNo" value="${flight.flightNo}">
<input type="hidden" name="srcCity" value="${flight.depCity}">
<input type="hidden" name="destCity" value="${flight.arrCity}">
<input type="hidden" name="name" value="${name}">
<input type="hidden" name="noOfPassengers" value="${noOfPassengers}">
<input type="hidden" name="classType" value="${classType}">
<input type="hidden" name="totalFare" value="${totalfare}">
<div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
<tr align="right"><th colspan="2">       <button type="submit" class="btn btn-warning">Confirm Booking</button></th></tr>
      </div>
 </div>
</form>
</table>
</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
