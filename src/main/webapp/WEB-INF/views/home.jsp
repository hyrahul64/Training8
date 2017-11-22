<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	User login.  
</h1>

<form action="loginUser" method="post">

Username: <input type="text" name="userName">
<br>
Password: <input type="password" name="password">
<br>
<br>
<input type="submit" value ="Submit">
</form>

<a href="createUser" >Not a user? Register.</a>

</body>
</html>
