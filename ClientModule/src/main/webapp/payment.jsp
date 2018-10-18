<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
<div class="hero"> 
<p>Passenger Details:</p><br>
<h6>Name:</h6><p>${name}</p>
<h6>Number of Passengers:</h6><p>${noOfPassengers}</p>
<h3>Enter payment details</h3>

<form class="form-horizontal" action="/ars/confirmBooking" method="post">
<div class="form-group">
<label class="col-sm-2 control-label">Enter 16-digit Credit Card Number:</label>
     <div class="col-sm-10">
        <input class="form-control" id="focusedInput" type="text" name="creditCardInfo" >
     </div>
</div>
<input type="hidden" name="bookingId" value="${bookingId}">
<input type="hidden" name="flightNo" value="${flight.flightNo}">
<input type="hidden" name="name" value="${name}">
<input type="hidden" name="noOfPassengers" value="${noOfPassengers}">
<input type="hidden" name="classType" value="${classType}">
<input type="hidden" name="totalFare" value="${totalfare}">
<input type="hidden" name="srcCity" value="${flight.depCity}">
<input type="hidden" name="destCity" value="${flight.arrCity}">
<div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Confirm Booking</button>
      </div>
 </div>
</form>
</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
