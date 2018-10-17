<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<title>Welcome-Airline Reservation System</title>
</head>
<body>
	<header>
		<h1>Airline Reservation System</h1>
		<ul>
			<li>Dropdown</li>
		</ul>
	</header>
	<div class="container">
		<div>
			<h3>Search a flight</h3>
			<div class="flightSearchBox">
				<form action="searchFlight" method="POST">
					<input type="text" name="fromCity" placeholder="From City">
					<input type="text" name="toCity" placeholder="To City">
					<input type="date" name="depDate">
					<input type="submit" value="Search">
				</form>
			</div>
			<div class="body">Rest of the body</div>
		</div>
	</div>
	<footer>
		<p>This is the footer</p>
	</footer>
</body>
</html>