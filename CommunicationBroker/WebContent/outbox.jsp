<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="iiitb.cb.models.User"%>
<%@page import="iiitb.cb.models.Email"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<style type="text/css">
tr:hover {
    cursor: pointer;
    
}
</style>
<script type="text/javascript" src="/CommunicationBroker/asset/JavaScripts/jquery-2.1.0.js"></script>
<script type="text/javascript" language="javascript" src="/CommunicationBroker/asset/JavaScripts/emails_outbox.js">

</script>

</head>
<body>
	<s:set scope="request" var="list" value="emailsList" />
	<div>
		<button type="button" id="previous" class="btn btn-primary">Previous</button>

		<button type="button"  id="next" class="btn btn-primary">Next</button>
		<div id="main_body">
			<table class="table table-striped table-hover">

				<tr>
					<td align="left"><h4>Reciever</h4></td>
					<td align="center"><h4>Subject</h4></td>
					<td align="right"><h4>Time</h4></td>
				</tr>
				<%
					List<Email> emailList = (List<Email>) request.getAttribute("list");
					for (int i = 0; i < emailList.size(); i++) {
						Email e = emailList.get(i);
						User reciever = e.getReciever();
						Date d = e.getTimestamp();
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy(HH:mm:ss)");
						out.println("<tr class='clickableRow clickable'>");
						out.println("<td align=\"left\">" + reciever.getName() +","+reciever.getEmail()+ "</td>");
						out.println("<td align=\"center\">" + e.getSubject() + "</td>");
						out.println("<td align=\"right\">" + formatter.format(d)
								+ "</td>");

						out.println("</tr>");
					}
				%>

			</table>
		</div>
			
	</div>

</body>
</html>