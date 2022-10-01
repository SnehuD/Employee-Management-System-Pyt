<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <link rel="icon" href="default.jpg">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Email Sending System</title>
  </head>
  <body>
	<jsp:include page="navbar.jsp">
		<jsp:param name="menuItems" value=""/>
	</jsp:include>
    <div class="container shadow">
	    <div class="text-center my-5 py-5">
	    	<h1 class="bg-light">Welcome to Email Sending System</h1>
	    	<a href="register.jsp"><button class="btn btn-primary mt-5">Register</button></a>
	    	<br><br><br><br><br>
	    	<a href="login.jsp"><button class="btn btn-primary">Login</button></a>
	    </div>
    </div>
  </body>
</html>