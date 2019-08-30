<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>Twitter</h1>
	<hr>
	<form action="/users/login" method="get">
        <button type = "submit" onclick="location.href='users/login'">Login</button><br><br>
        
    </form>
	<form action="/users/register" method="get">
        <button type = "submit" onclick="location.href='users/register'">Register</button>
        
    </form>
	
</body>
</html>