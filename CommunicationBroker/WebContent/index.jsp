<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="/CommunicationBroker/asset/CSS/bootstrap.css"
	rel="stylesheet" />
<link href="/CommunicationBroker/asset/CSS/bootstrap-theme.css.map"
	rel="stylesheet">
<link href="/CommunicationBroker/asset/CSS/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="/CommunicationBroker/asset/CSS/bootstrap.css"
	rel="stylesheet">
<link href="/CommunicationBroker/asset/CSS/bootstrap.css.map"
	rel="stylesheet">
<link href="/CommunicationBroker/asset/CSS/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
body{
margin-top:2%;
background-image: url("/CommunicationBroker/asset/images/sativa.png");
}
#login {
margin-top:5%;
	width: 20%;
}

#register{
width:277px;
height:43px;
}
</style>
</head>
<body>
	<center>
	<h2>Communication Broker</h2>
	
		<div id="login">
					<form action="module3/login" class="form-signin">
				<h3 class="featurette-heading" >Please Sign In</h3>
					<input type="text" class="form-control" placeholder="Email" name="email"
						required="true" />
				
				
					<input type="password" class="form-control" placeholder="Password"
						name="password" required="true">
				<br>
					<select name="serviceType">
						<option value="Email">Email</option>
						<option value="FTP">FTP</option>
					</select>
					<br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
					in</button>
				<br>
			</form>
			<form action="module3/register_redirect">
				<button type="submit" class="btn btn-warning" id="register"><b>New User? Register</b></button>
			</form>
		</div>
	</center>
</body>
</html>