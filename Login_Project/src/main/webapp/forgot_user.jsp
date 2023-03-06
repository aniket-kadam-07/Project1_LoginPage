<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verify Page</title>
</head>
<body>
	<%
		int count = (int) request.getAttribute("count");
		
		if(count!=0){
			out.print("Username Reset Successful");
		}else{
			out.print("First Create Account");
		}
	%>
</body>
</html>