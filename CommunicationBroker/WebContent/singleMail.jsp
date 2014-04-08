<%@page import="java.text.SimpleDateFormat"%>
<%@page import="iiitb.cb.models.User"%>
<%@page import="iiitb.cb.models.Email"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
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
</head>
<body>
	<s:set scope="request" var="email" value="email" />
	<div>
		<%
			Email e = (Email) request.getAttribute("email");
			User u = e.getSender();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM (HH:mm)");
			String date = sdf.format(e.getTimestamp());
			out.println("<h2 class=\"featurette-heading\">" + e.getSubject()
					+ "</h2>");
			out.println("<hr class=\"featurette-divider\">");
			out.println("<h4 class=\"featurette-heading\">From : "+u.getName()+
					"<span class=\"text-muted\">("+u.getEmail()+")"+
					"</span>"+
					"<p class=\"pull-right\">"+date+"</p></h4>");
			out.println("<hr class=\"featurette-divider\">");
			out.println("<p style=\"font-size: 20px;\">"+e.getBody()+"</p>");
		%>
		<p style="{font-size: 20px;}">
	</div>
</body>
</html>