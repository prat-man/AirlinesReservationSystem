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
<title>Welcome to Airline Reservation System</title>
</head>
<body>
<jsp:include page='header.jsp'/>
	<div class="container">
		<div class="row">
			<h3 align="center">Search a flight</h3>
			<div class="flightSearchBox col-lg-6">
				<form action="/ars/searchFlight" method="GET">
					<input class="form-control" type="text"  name="fromCity" placeholder="From City" required>
					<div id="getCityList"></div>
					<input class="form-control" type="text"  name="toCity" placeholder="To City" required>
					<input class="form-control" type="date"  name="depDate" required><br/>
					<button type="submit" class="btn btn-primary">Search</button>
				</form>
			</div>
			<div class="body"></div>
		</div>
	</div>
	<jsp:include page='footer.jsp'/>
</body>
</html>
