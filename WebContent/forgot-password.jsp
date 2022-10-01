<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <link rel="icon" href="default.jpg">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <title>Forgot Password</title>
  </head>
  <body>
	<jsp:include page="navbar.jsp">
		<jsp:param name="navbar" value=""/>
	</jsp:include>
    <div class="container-sm">
	   <div class="card shadow p-3 my-5">
	        <h2 class="text-center">Forgot Password</h2>
	        <form class="form" action="forgot_password" method="POST">	            
	            <div class="mb-3">
	                <label class="form-label">Email Address</label>
	                <input type="email" class="form-control" name="email" required>
	            </div>	            
	            <button type="submit" class="btn btn-primary">Send Password</button>
	        </form>
	   </div>
	</div>
  </body>
</html>