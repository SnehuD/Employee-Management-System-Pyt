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
    <title>Login User</title>
  </head>
  <body>
	<jsp:include page="navbar.jsp">
		<jsp:param name="navbar" value=""/>
	</jsp:include>
    <div class="container-sm">
	   <div class="card shadow p-3 my-5">
	        <h2 class="text-center">Login here</h2>
	        <%
	        
	        if(session.getAttribute("email_verified") != null){
	        	%>
	        	<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong>Email ID Verified Successfully..!!</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				<%
				session.setAttribute("email_verified", null);
	        }
	        
	        if(session.getAttribute("not_email_verified") != null){
	        	%>
	        	<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>Something went Wrong while verifying email ID..!!</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>				
				<%
				session.setAttribute("not_email_verified", null);
	        }
	        
	        if(session.getAttribute("evs_fail") != null){
	        	%>
	        	<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>Email ID Not Verified, Please Verify Email First..!!</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				<form class="form text-center" action="resend_email" method="POST">
				  	<input name="email" value='${evs_fail }' hidden="true">
				  	<button class="btn btn-primary my-5">Resend Email Verification</button>
				</form>
				<%
				session.setAttribute("evs_fail", null);
	        }
	        
	        if(session.getAttribute("invalid_credentials") != null){
	        	%>
	        	<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>Invalid Credentials..!!</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				<%
				session.setAttribute("invalid_credentials", null);
	        }
	        
	        if(session.getAttribute("ev_sent") != null){
	        	%>
	        	<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong>Email Verficatin Sent to Your Entered Email..!!</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				<%
				session.setAttribute("ev_sent", null);
	        }
	        
	        if(session.getAttribute("pass_sent") != null){
	        	%>
	        	<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong>Password Sent to Your Entered Email Successfully..!!</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				<%
				session.setAttribute("pass_sent", null);
	        }
	        
	        if(session.getAttribute("logout") != null){
	        	%>
	        	<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong>Logged Out Successfully..!!</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				<%
				session.invalidate();
	        }
	        %>
	        <form class="form" action="user_login" method="POST">	            
	            <div class="mb-3">
	                <label class="form-label">Email Address</label>
	                <input type="email" class="form-control" name="email" required>
	            </div>
	            <div class="mb-3">
	                <label class="form-label">Password</label>
	                <input type="password" class="form-control" name="password" required>
	            </div>
	            <div class="text-end"><a class="text-primary text-decoration-none" href="forgot-password.jsp">Forgot Password ?</a> </div>	            
	            <button type="submit" class="btn btn-primary">Login</button>	            
	        </form>
	        <p class="my-5">Not have an account? <a class="text-decoration-none" href="register.jsp">Register here</a></p>
	   </div>
	</div>
  </body>
</html>