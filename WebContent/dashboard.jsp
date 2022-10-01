<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
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
    <title>User Dashboard</title>
  </head>
<body>
<%
	
	User u = (User)session.getAttribute("User");	
	if(u != null){
		%>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#"><c:out value="${User.fname} ${User.lname}"></c:out></a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href=""  data-bs-toggle="modal" data-bs-target="#sendmailmodal">Send Email</a>
		        </li>
		      </ul>
		      <div>
		      	<a href="logout.jsp"><button class="btn btn-primary">Logout</button></a>
		      </div>
		    </div>
		  </div>
		</nav>
		<div class="container shadow 2">
			<div class="d-flex justify-content-center my-5">
				<div class="alert alert-success alert-dismissible fade show w-75 my-4" role="alert">
				  <strong>Logged Successfully...!!!</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>			
				</div>
				<%if(session.getAttribute("email_sent") != null){ %>
					<div class="alert alert-success alert-dismissible fade show w-75 my-4" role="alert">
					  <strong>Email Sent Successfully..!!!</strong>
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>			
					</div>
				<%session.setAttribute("email_sent", null);} %>
				<%if(session.getAttribute("email_not_sent") != null){ %>
					<div class="alert alert-danger alert-dismissible fade show w-75 my-4" role="alert">
					  <strong>Something went Wrong while sending Email.!!!</strong>
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>			
					</div>
				<%session.setAttribute("email_not_sent", null);} %>
			</div>
			<h1 class="text-center">Welcome <c:out value="${User.fname } ${User.lname }"></c:out></h1>
			<div class="shadow 2 my-5 py-5">
				<table class="table table-responsive d-flex justify-content-center">
				    <tr>
				      <th>Full Name</th>
				      <td><c:out value="${User.fname } ${User.lname }"></c:out></td>
				    </tr>
				    <tr>
				      <th>Email</th>
				      <td><c:out value="${User.email }"></c:out></td>
				    </tr>
				    <tr>
				      <th>Password</th>
				      <td><c:out value="${User.passwd }"></c:out></td>
				    </tr>
				</table>
			</div>			

			<!-- Send Email Modal -->
			<div class="modal fade" id="sendmailmodal" tabindex="-1" aria-labelledby="sendmailmodal" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Send Email</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <form class="form" action="send_email" method="post">
			      	<div class="modal-body">
						<div class="mb-3">
			                <label class="form-label">From</label>
			                <input class="form-control" value="${User.email }" name="from" required readonly>
			            </div>
						<div class="mb-3">
			                <label class="form-label">To</label>
			                <input type="email" class="form-control" name="to" required>
			            </div>
			            <div class="mb-3">
			                <label class="form-label">Subject</label>
			                <input type="text" class="form-control" name="subject" required>
			            </div>
			            <div class="mb-3">
			                <label class="form-label">Body</label>
			                <textarea class="form-control" rows="4" cols="" name="body"></textarea>
			            </div>
					</div>
					<div class="modal-footer">
					  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
					  <button type="submit" class="btn btn-primary">Send Email</button>
					</div>
			    </form>
			  </div>
			</div>
		</div>	
	</div>	
		<%
	}else{
		response.sendRedirect("login.jsp");
	}
%>

</body>
</html>