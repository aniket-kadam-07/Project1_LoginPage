<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account Page</title>
<link rel="stylesheet" href="createAccount.css">
</head>
<body>
	<%
		int count = (int)request.getAttribute("count");
		if(count!=0){
			out.print("Account Created Successful");
	%>
			<br>
			<br>
			<a class="green" href="index.html">Home Page</a>
	<% 		
		}else {
			out.print("Username or Mail is Already Exist");
	%>
			<br>
			<br>
			<a class="red" href="index.html">Home Page</a>
	<%
		}
		
		
	%>
</body>
</html>