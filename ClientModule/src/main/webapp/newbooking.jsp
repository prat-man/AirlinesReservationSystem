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
<table border="1" align="center">
<tr align="center"><th colspan="2"><h3>Passenger Details</h3></th></tr>
<div class="detailTable" align="center">
<form class="form-horizontal" action="/ars/payment" method="post">
   <div class="form-group">
      <tr>
      <th><label class="col-sm-2 control-label">Name:</label></th>
      <td><div class="col-sm-12">
        <input class="form-control" id="focusedInput" type="text" name="name" required></td>
      </tr>
      </div>
      </div>
    <div class="form-group">
   	  <tr>
      <th><label class="col-sm-10 control-label">Number of Passengers:</label></th>
      <td><div class="col-sm-12">
        <input class="form-control" id="focusedInput" type="text" name="noOfPassengers" required></td>
      </tr>
      </div>
      </div>
    <input type="hidden" name="bookingId" value="${bookingId}">
    <input type="hidden" name="flightNo" value="${flight.flightNo}">
    <input type="hidden" name="fare" value="${fare}">
    <input type="hidden" name="classType" value="${classType}">
    <input type="hidden" name="depCity" value="${flight.depCity}">
    <input type="hidden" name="arrCity" value="${flight.arrCity}">
    
    <div class="form-group">        
      <tr><td colspan="2" align="right">
      <div class="col-sm-offset-6 col-sm-10">
        <button type="submit" class="btn btn-success">Proceed to Payment</button>
      </div>
      </td>
      </tr>
    </div>
  </form>
  </table>
  </div>
  </div>
<jsp:include page="footer.jsp"/>
</body>
</html>
