<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jsp Page</title>
</head>
<body>
	<%
		String username = (String)session.getAttribute("username");
		if (username == null || username.trim().equals(""))
		{
			response.sendRedirect("login.html");
		}
	%>
	<h1>Hello <%= username %> ..!</h1>
	<h2>Login Successful ..!</h2>
	<a href = "logout.jsp">Sign out</a>
</body>
</html>	
