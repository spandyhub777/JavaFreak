<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting}</h1>
				<p>${tagline}</p>
			</div>
		</div>
	</section>
	<form action="/simpleFlightSearch/search" method="get">
	<div class="container">
    <label for="flightNum"><b>FlightNumber</b></label>
    <input type="text" placeholder="Enter Username" name="flightNum" required>
	
    <label for="orgn"><b>Origin</b></label>
    <input type="text" placeholder="Enter Origin" name="orn" required>

 	<label for="dest"><b>Destination</b></label>
    <input type="text" placeholder="Enter Destination" name="dest" required>

	<label for="date"><b>Date</b></label>
    <input type="date" placeholder="Enter Date" name="date" required>
	
	
    <button type="submit">Search</button>
    <!-- <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label> -->
  </div>
  </form>

<h1>Flight Information for the request</h1>
		<div class="jumbotron">
			<div id ="image-description" class="container">
				<p>${info}</p>
			</div>
		</div>
      </ul>
     
</body>
</html>