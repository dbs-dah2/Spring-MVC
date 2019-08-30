<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <title>Sign up</title>
    <style>
    .error{
        color:red;
        font-size: 15px;
        padding:10px;
    }
    </style>
</head>
<body>
<h1>Twitter Sign up</h1>
<hr>
<form action="/users/register" method="POST" modelAttribute="user">

		UserName: <input type="text" name="name" placeholder="Enter your username"><br><br>
        Password: <input type="password" name="password" placeholder="Enter your password"><br><br>
        Email: <input type="email" name="email" placeholder="Enter your email"><br><br>
        Phone: <input type="number" name="phone" placeholder="Enter your mobile number"><br><br>
        City: <input type="text" name="city" placeholder="Enter your city"><br><br>
        State: <input type="text" name="state" placeholder="Enter your state"><br><br>
        Pincode: <input type="number" name="pincode" placeholder="Enter your pincode"><br><br>
    
    
        <button type="submit" >Sign up</button>
    
</form>

</body>
</html>