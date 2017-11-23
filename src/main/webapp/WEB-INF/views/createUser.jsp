<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
  <%-- <form:errors path="user.*"/> --%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User.</title>

</head>
<body>

<form action="submitUser" method="post">
<h2>Enter your detail below</h2>
<table>
<tr>
	<td align="right"> Name: </td>
	<td align="left"> <input type="text" name = "userName"/>
	<td><form:errors path="user.username"/></td>
</tr>

<tr>
	<td align="right"> Password: </td>
	<td align="left"> <input type="password" name ="password"/>
	<td><form:errors path="user.password"/></td>
</tr>
<tr>
	<td align="right"> Confirm Password: </td>
	<td align="left"> <input type="password" name="confirmPassword"/>
	<td><form:errors path="user.confirmPassword"/></td>
</tr>
<tr>
	 <th colspan="2" align = "center" > <input type="submit" value="Submit"></th>
 </tr>
</table>

</form>

</body>
</html>