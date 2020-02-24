<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Author home</title>
</head>
<body>
<h3><label class="label col-sm-2 col-xs-12" for="Emailmsg"><p style="font-size: 1.5em;color: #000000" >Welcome Author</p></label></h3>
 	<section class="welcome section">
		
			<div class="container">
			
				<div class="row">
					<div class="col-sm-12">
					  <div class="form-group">
							<h3><label class="label col-sm-2 col-xs-12" for="Emailmsg"><p style="font-size: 1.5em;color: #000000" >Question:</p></label></h3>	

					</div>
				      
				      <b><textarea class="form-control" rows="5">Can you guide me to start writing a new book?</textarea></b>
				        <div class="form-group">
							<h3><label class="label col-sm-2 col-xs-12" for="Emailmsg"><p style="font-size: 1.5em;color: #000000" >Write answer</p></label></h3>	

					</div>
				      
				      <textarea class="form-control" rows="5"></textarea>
				      
				      <div class="form-group"> </div>
				      <div class="row">
					<div class="col-sm-12">
					  <div class="form-group">
							<h3><label class="label col-sm-2 col-xs-12" for="Emailmsg"><p style="font-size: 1.5em;color: #000000" >Write new post for books</p></label></h3>	

					</div>
				      
				      <textarea class="form-control" rows="5"></textarea>
				      <div class="form-group"> </div>
				      
					<div class="col-sm-12 apply-padding">
						<div class="form-group">
							<div class="col-sm-offset-2 col-xs-12 col-sm-2 col-md-offset-0">
								<a href="LogoutServlet"><button class="btn btn-primary btn-block form-group">Logout</button></a>
							</div>
							<div class="col-sm-2 col-xs-12">
							<a href="submitted.jsp">	<button class="btn btn-primary btn-block form-group">Submit</button></a>
							</div>
						</div>
					</div>
					<div class="col-sm-12">&nbsp;</div>
					
		          </div>
		 	
			</div>



</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>