<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Airport</title>
</head>
<body>
<h3>Add Airport</h3>
			<div class="addairport">
				<form action="addAirportAction" method="POST">
					<input type="text" name="abbreviation" placeholder="Abbreviation">
					<input type="text" name="airportName" placeholder="Airport Name">
					<input type="text" name="location" placeholder="Location">
					<input type="submit" value="Add">
				</form>
			</div>
</body>
</html>