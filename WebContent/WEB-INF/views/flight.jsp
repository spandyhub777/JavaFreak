<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>

 <script>
      info = ${info};
if (info != null) {
    document.getElementById('image-description').style.display = 'block';
} else {
    document.getElementById('image-description').style.display = 'none';
}
</script>
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

<h1>Flight Information for the request</h1>
<div class="jumbotron">
	<div id ="image-description" class="container">
				<p>${info}</p>
			</div>
			</div>
     
</body>
</html>