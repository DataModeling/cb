<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="iiitb.cb.models.User"%>
<%@page import="iiitb.cb.models.FTP"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FTP</title>
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
<!-- <script type="text/javascript" language="javascript" src="/CommunicationBroker/asset/JavaScripts/emails_inbox.js">  -->

</script>

</head>
<body>
	<s:set scope="request" var="list" value="fileList" />
	<div>
	<button class="btn btn-default btn-sm" data-toggle="modal" data-target="#addFileModal" aria-hidden="true"><b> + Upload file</b></button>
		<!--  <button type="button" id="previous" class="btn btn-primary">Previous</button>

		<button type="button"  id="next" class="btn btn-primary">Next</button>  -->
		<div id="main_body">
			<table class="table table-striped table-hover">

				<tr>
					<td align="left"><h4>Files</h4></td>
					<!--  <td align="center"><h4>Subject</h4></td> -->
					<td align="right"><h4>Time</h4></td>
				</tr>
				<%
					List<FTP> fileList = (List<FTP>) request.getAttribute("list");
					for (int i = 0; i < fileList.size(); i++) {
						FTP f = fileList.get(i);
						//User sender = e.getSender();
						Date d = f.getTimestamp();
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy(HH:mm:ss)");
						out.println("<tr class='clickableRow clickable'>");
						out.println("<td align=\"left\">" + f.getFileName() + "</td>");
					//	out.println("<td align=\"center\">" + e.getSubject() + "</td>");
						out.println("<td align=\"right\">" + formatter.format(d)
								+ "</td>");

						out.println("</tr>");
					}
				%>

			</table>
		</div>
			
	</div>

<div id="addFileModal" class="modal fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true"
				style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">Add File</h4>
						</div>
						<div class="modal-body" id="addFileModal">
									<s:form action="FTPFileAdd" method="post" enctype="multipart/form-data">
										<s:file name="userDoc" label="Add File"></s:file>
										<s:submit value="Upload"></s:submit>
									</s:form>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
</body>
</html>