<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<sd:head/>
</head>
<body>
	<s:form action="module3/register">
		<s:textfield  name="name" label="Name"/>
		<s:textfield name="email" label="Email"/>
		<s:password name="password" label="Password"/>
		<sd:datetimepicker label="Birthday" name="dob"/>
		<sd:autocompleter list="countryList" name="country" label="Country"/>
		<s:submit value="Register"/>
	</s:form>
</body>
</html>