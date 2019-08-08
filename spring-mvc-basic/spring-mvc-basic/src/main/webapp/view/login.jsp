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
    <title>Login Page</title>
</head>
<body>
    <h1>Login page !!</h1>
    <form action="/users/loginUser" method="post">
        UserName: <input type="text" name="username" placeholder="Enter your username">
        Password: <input type="password" name="password" placeholder="Enter your password">

        <button type="submit">Login</button>
    </form>
</body>
</html>