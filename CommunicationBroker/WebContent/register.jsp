<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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

.label{
color: black;
}

#abc{
background-color: #3276B1;
width:100px;
color:white;
}

</style>

<sd:head/>
</head>
<body>
<center>
	<h2>Communication Broker</h2>
	<br>
	<br>
	<s:form action="module3/register">
					<h3 class="featurette-heading" >Please register</h3>
	
	<table  cellpadding="2px" cellspacing="4px" >
	<tr >
		<td height="20px"><s:textfield  name="name" label="Name"  /></td></tr>
		<tr><td height="20px"><s:textfield name="email" label="Email"/></td></tr>
		<tr><td height="20px"><s:password name="password" label="Password"/></td></tr>
		<tr><td height="20px"><sd:datetimepicker label="Birthday" name="dob"/></td></tr>
		<tr><td height="20px"><sd:autocompleter list="countryList" name="country" label="Country"/></td></tr>
		<tr><td  height="20px" ><s:submit value="Register" align="center" id="abc"/></td></tr>
		</table>
	</s:form>
	</center>
</body>
</html>