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
<title>Book Ticket</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
<h3>Passenger Details</h3>
<div class="detailTable" align="center">
<form class="form-horizontal" action="/ars/payment" method="post">
   <div class="form-group">
      <label class="col-sm-2 control-label">Name:</label>
      <div class="col-sm-10">
        <input class="form-control" id="focusedInput" type="text" name="name" >
      </div>
      </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">Number of Passengers:</label>
      <div class="col-sm-10">
        <input class="form-control" id="focusedInput" type="text" name="noOfPassengers" >
      </div>
      </div>
    <input type="hidden" name="bookingId" value="${bookingId}">
    <input type="hidden" name="flightNo" value="${flight.flightNo}">
    <input type="hidden" name="fare" value="${fare}">
    <input type="hidden" name="classType" value="${classType}">
    <input type="hidden" name="depCity" value="${flight.depCity}">
    <input type="hidden" name="arrCity" value="${flight.arrCity}">
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Proceed to Payment</button>
      </div>
    </div>
  </form>
  </div>
  </div>
<jsp:include page="footer.jsp"/>
</body>
</html>
