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
<title>Admin Panel</title>
</head>
<body>
<jsp:include page='header.jsp'/>
<table border="2" align="center" >
<tr><th><h1>Admin Panel<br><img alt="admin" src="/resources/admin.png"></h1></th></tr>
<tr><td align="center"><h2><a href="/ars/addFlight">Add Flight</a></h2><img alt="admin" width="64" height="64" src="/resources/flight.png"></td></tr>
<tr><td align="center"><h2><a href="/ars/addAirport">Add Airport</a></h2><img alt="admin" width="64" height="64" src="/resources/airport.png"></td></tr>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>