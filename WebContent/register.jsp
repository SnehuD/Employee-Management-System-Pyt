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
    <title>Register User</title>
  </head>
  <body>
  	<jsp:include page="navbar.jsp">
		<jsp:param name="menuItems" value=""/>
	</jsp:include>
    <div class="container-sm">
	   <div class="card shadow p-3 my-5">
	        <h2 class="text-center">Register here</h2>
	        <%
	        if(session.getAttribute("email_exist") != null){
	        	%>
	        	<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>Email ID Already Exist</strong> 
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				<%
				session.setAttribute("email_exist", null);
	        }
	        if(session.getAttribute("reg_status") != null){
	        	%>
	        	<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong>Registered Successfully..!!<br>Verification Link Sent to Your Email.</strong> 
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				<%
				session.setAttribute("reg_status", null);
	        }
	        %>
	        <form class="form" action="user_reg_con" method="POST">
	            <div class="mb-3">
	                <label class="form-label">First Name</label>
	                <input type="text" class="form-control" name="fname" required>
	            </div>
	            <div class="mb-3">
	                <label class="form-label">Last Name</label>
	                <input type="text" class="form-control" name="lname" required>
	            </div>
	            <div class="mb-3">
	                <label class="form-label">Email Address</label>
	                <input type="email" class="form-control" name="email" required>
	                <div id="emailHelp" class="form-text">We'll Send Verification Email</div>
	            </div>
	            <div class="mb-3">
	                <label class="form-label">Password</label>
	                <input type="password" class="form-control" name="password" required>
	            </div>	            
	            <button type="submit" class="btn btn-primary">Register</button>
	        </form>
	        <p class="my-5">Already have an account? <a href="login.jsp">Login here</a></p>
	   </div>
	</div>
  </body>
</html>