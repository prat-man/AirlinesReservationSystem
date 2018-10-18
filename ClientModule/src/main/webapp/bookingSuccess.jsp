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
<title>Booking Success</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
<ul>
<li>Booking Id: ${confirmedBooking.bookingId}</li>
<li>Name: ${confirmedBooking.name}</li>
<li>Total Fare: ${confirmedBooking.totalFare}</li>
<li>Date: ${depDate}</li>
<li>From: ${confirmedBooking.srcCity}</li>
<li>To: ${confirmedBooking.destCity}</li>
</ul>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>