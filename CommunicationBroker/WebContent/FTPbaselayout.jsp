<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html lang="en">
<head>


<title>Communication Broker</title>

<!-- Bootstrap core CSS -->
<link href="/CommunicationBroker/asset/CSS/bootstrap.min.css" rel="stylesheet"/>

<!-- Custom styles for this template -->
<link href="/CommunicationBroker/asset/CSS/style.css" rel="stylesheet"/>

</head>

<body>

	<div class="container">

		<!-- Static navbar -->
		<div class="navbar  navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><b>Communication Broker</b></a>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" size="70"
								placeholder="Search...">
						</div>
						<button type="submit" class="btn btn-default">Search</button>
					</form>
				</div>
				<div class="navbar-collapse collapse">

					<ul class="nav navbar-nav navbar-right">
						<li></li>

						<li><a href="/CommunicationBroker/module3/logout"><b>Logout</b></a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>

		<div id="menu">
		<tiles:insertAttribute name="menu" />
		</div>
		
		<div id="FTPoptions">
			<tiles:insertAttribute name="options" />

		</div>

		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>



	</div>
	<!-- /container -->

	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="/CommunicationBroker/asset/JavaScripts/jquery-2.1.0.js"></script>
	<script src="/CommunicationBroker/asset/JavaScripts/bootstrap.min.js"></script>
</body>
</html>
