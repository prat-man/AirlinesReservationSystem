<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="shortcut icon" type="image/png" href="/resources/fav.png" />
<title>Booking Success</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Booking Successful</h2>
	<div class="container">
		<table>
			<tr>
				<td>Booking Id</td>
				<td>${confirmedBooking.bookingId}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${confirmedBooking.name}</td>
			</tr>
			<tr>
				<td>Total Fare</td>
				<td>${confirmedBooking.totalFare}</td>
			</tr>
			<tr>
				<td>Date</td>
				<td>${depDate}</td>
			</tr>
			<tr>
				<td>From</td>
				<td>${confirmedBooking.srcCity}</td>
			</tr>
			<tr>
				<td>To</td>
				<td>${confirmedBooking.destCity}</td>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>