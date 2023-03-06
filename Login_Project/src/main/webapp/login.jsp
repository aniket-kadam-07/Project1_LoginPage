<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<%
		boolean login = (boolean) request.getAttribute("status");
	
		if(login==true){
			out.print("Login Successful");
		}else {
			out.print("Login Error");
		}
	%>
	<h1> <%=login %></h1>
	
</body>
</html>