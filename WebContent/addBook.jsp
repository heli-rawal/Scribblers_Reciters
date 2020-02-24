<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact us</title>
</head>
<body>
	<div class="container text-center-xs">
			<!-- Nested Row Starts -->
				<div class="row">
					<div class="col-sm-4 col-xs-12">
					<!-- Logo Starts -->
						<img src="images/logo.png" alt="ScribblersAndReciters" class="logo img-responsive img-center-xs">
					<!-- Logo Ends -->
					</div>
					<div class="col-sm-8 col-xs-12">
					<!-- Top Links Starts -->
						
					<!-- Starts -->
						<ul class="list-unstyled list-inline text-right-lg text-right-md text-right-sm order-info">
							<li class="lead"><i class="fa fa-phone"></i> Call : 001 9876 543 210</li>
							<li class="hidden-xs">&nbsp;</li>
							<li><a href="#" class="btn btn-light animation">Reach us!</a></li>
						</ul>
					<!-- Ends -->
					</div>
				</div>
			<!-- Nested Row Ends -->
			</div>
		<!-- Nested Container Ends -->
		</header>
		<!-- Main Container Starts -->
		<div class="container main-container">
			<section class="contact-form-section">
				<h3 class="text-bold text-center">To Add New Book...</h3>
				<form action="#">
					<div class="row">
						<div class="col-md-4 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="sr-only" for="contact-fname">Author's Name</label>
								<input type="text" class="form-control flat" id="contact-fname" placeholder="Author's Name">
							</div>
						</div>
						<div class="col-md-4 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="sr-only" for="contact-lname">Occupation</label>
								<input type="text" class="form-control flat" id="contact-lname" placeholder="Occupation">
							</div>
						</div>
						<div class="col-md-4 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="sr-only" for="contact-email">E-mail</label>
								<input type="email" class="form-control flat" id="contact-email" placeholder="E-mail">
							</div>
						</div>
						<div class="col-md-4 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="sr-only" for="contact-phoneno">Phone No</label>
								<input type="text" class="form-control flat" id="contact-phoneno" placeholder="Phone No">
							</div>
						</div>
						<div class="col-md-4 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="sr-only" for="contact-city">Nationality</label>
								<input type="text" class="form-control flat" id="contact-city" placeholder="Nationality">
							</div>
						</div>
						<div class="col-md-4 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="sr-only" for="contact-address">Genre</label>
								<input type="text" class="form-control flat" id="contact-address" placeholder="Genre">
							</div>
						</div>
						<div class="col-xs-12">
							<div class="form-group">
								<label class="sr-only" for="contact-restaurant-name">Name of the Book</label>
								<input type="text" class="form-control flat" id="contact-restaurant-name" placeholder="Name of the Book">
							</div>
						</div>
						<div class="col-xs-12">
							<div class="form-group">
								<label class="sr-only" for="contact-info">Describe About Your Book</label>
								<textarea class="form-control flat" id="contact-info" placeholder="Describe About Your Book" rows="5"></textarea>
							</div>
						</div>
						<div class="col-xs-12 text-center">
							<button type="submit" class="btn btn-secondary text-uppercase animation">Submit Your Details</button>
						</div>
					</div>
				</form>
			</section>
		</div>
	
	

</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>