<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

	<h1>Welcome Page</h1>
	
	<%
		String msg = (String) request.getAttribute("MESSAGE");
		String user = (String) session.getAttribute("USERID");
	%>

	<p>  <%= msg %>   </p>
	<p>  <%= user %>   </p>
	
	<a href="SecondServlet">Second Servlet</a>
	

</body>
</html>