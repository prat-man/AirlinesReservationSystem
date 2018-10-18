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
<script>
function showResult(str) {
	  if (str.length==0) { 
	    document.getElementById("getCityList").innerHTML="";
	    document.getElementById("getCityList").style.border="0px";
	    return;
	  }
	  if (window.XMLHttpRequest) {
	    // code for IE7+, Firefox, Chrome, Opera, Safari
	    xmlhttp=new XMLHttpRequest();
	  } else {  // code for IE6, IE5
	    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  xmlhttp.onreadystatechange=function() {
	    if (this.readyState==4 && this.status==200) {
	      document.getElementById("getCityList").innerHTML=this.responseText;
	      console.log(this.responseText);
	      document.getElementById("getCityList").style.border="1px solid #A5ACB2";
	    }
	  }
	  xmlhttp.open("GET","/ars/autocomplete/"+str,true);
	  xmlhttp.send();
	}
</script>
</head>
<body>
<jsp:include page='header.jsp'/>

	<div class="container">
		<div class="row">
			<h3>Search a flight</h3>
			<div class="flightSearchBox col-lg-12">
				<form action="/ars/searchFlight" method="GET">
					<input class="form-control" type="text"  name="fromCity" placeholder="From City" onkeyup="showResult(this.value)">
					<div id="getCityList"></div>
					<input class="form-control" type="text"  name="toCity" placeholder="To City">
					<input class="form-control" type="date"  name="depDate">
					<input type="submit" value="Search">
				</form>
			</div>
			<div class="body">Rest of the body</div>
		</div>
	</div>
	<jsp:include page='footer.jsp'/>
</body>
</html>
