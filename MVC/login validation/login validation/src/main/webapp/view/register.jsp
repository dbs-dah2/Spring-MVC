<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
    <title>Registration Page</title>
</head>
<body>
	
    <h1>Registration page !!</h1>
    <hr>
    
    
		<c:choose>
	    <c:when test="${status == '1'}">
	        <h3>Registration Successful..!! <br><br></h3>
	        
				<button type = "submit" onclick="location.href='./listAll'">List All Employees</button>
			
	        <br />
	    </c:when>    
	    <c:otherwise>
	        
	        <br />
	    </c:otherwise>
</c:choose>
	
    <hr>
    
    <form action="/users/registerUser" method="post">
        Name: <input type="text" name="name" placeholder="Enter your name"><br><br>
        Date of birth: <input type="date" name="dob" placeholder="Enter your date of birth"><br><br>
        Department Name: <input type="text" name="dept_name" placeholder="Enter your department name"><br><br>

        <button type="submit">Register</button>
    </form>
    <hr>
    
</body>
</html>