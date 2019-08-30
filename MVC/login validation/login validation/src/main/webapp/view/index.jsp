<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Welcome</title>
</head>
<body>
<h1>Welcome to DBS..!!</h1>
<hr>
	<div class = "container">
		<form action="users/register">
			<button type = "submit">Register</button>
		</form>
		<br>
		<form action="users/login">
			<button type = "submit">Login</button>
		</form>
		<br>
		<form action="users/listAll">
			<button type = "submit">List All Employees</button>
		</form>
	</div>
</body>
</html>