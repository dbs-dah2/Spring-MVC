<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Logged in successfully ! ${user.name} with ${user.id }</h1>
	
	
	<form action="/users/${user.id}/addTweet" method="get">
        <button type="submit">Add Tweet</button>
    </form>
	
	
	<form action="/users/displayAllTweets" method="get">
        <button type="submit">Display All Tweets</button>
    </form>
	
	
	
</body>
</html>