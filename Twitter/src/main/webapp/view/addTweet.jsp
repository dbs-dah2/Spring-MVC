<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Tweet</h1>
	<hr><h1>${user.id }</h1><hr>
    <form action="/users/${user.id}/addTweet" method="post" modelAttribute="tweet">
        <!-- <textarea rows="5" cols="70" name="tweet"> </textarea> -->
        Tweet: <input type="text" name="user_tweet" placeholder="Enter your tweet"><br><br>
        Media URL: <input type="text" name="mediaUrl" placeholder="Enter your mediaUrl"><br><br>
        <!-- Password: <input type="password" name="password" placeholder="Enter your password"> -->

        <button type="submit">Tweet</button>
    </form>
</body>
</html>