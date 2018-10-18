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
<ul>
<li>Booking Id: ${confirmedBooking.bookingId}</li>
<li>Name : ${confirmedBooking.name}</li>
<li>Total Fare: ${confirmedBooking.totalFare}</li>
<li>Departure Date: ${confirmedBooking.depDate}</li>
<li>Source City: ${confirmedBooking.srcCity}</li>
</ul>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>