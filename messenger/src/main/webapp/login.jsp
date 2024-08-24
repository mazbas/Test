<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="webapi/inject/login"method="post">
Enter The User Name <input type="text" name="username"><br>
Enter The Password <input type="password" name="password"><br>
<input type="submit" value="Login" >
</form>
</body>
</html>