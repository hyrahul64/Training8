<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
<h2> Enter your details below.</h2>

<form  action="updateUserDetail" method="post" commandName= "userDetail">

<table>

<tr>
	<td align="right"> Username:</td>
	<td align="left"> ${userName}<input type="hidden" name="userName" value="${userName}"></td>
	  
</tr>
<tr>
	<td align="right"> First Name:</td>
	<td align="left"> <input type="text" name="userFirstName" value="${userDetail.userFirstName}"/></td>
	<td><form:errors path="userDetail.userFirstName"/></td>
</tr>
<tr>
	<td align="right"> Last Name:</td>
	<td align="left"> <input type="text" name="userLastName" value="${userDetail.userLastName}"/></td>
</tr>
<tr>
	<td align="right"> Email:</td>
	<td align="left"> <input type="text" name="userEmail" value="${userDetail.userEmail}"/></td>
	<td><form:errors path="userDetail.userEmail"/></td>
</tr>
<tr>
	<td align="right"> Mobile:</td>
	<td align="left"> <input type="text" name="userMobile" value="${userDetail.userMobile}" /></td>
</tr>
<tr>
	<td align="right"> Address:</td>
	<td align="left"> <input type="text" name="userAddress"  value="${userDetail.userAddress}" style="width:200px; height:50px;" /></td>
</tr>
<tr>
	<td align="right"> Gender:</td>
	<td align="left"> <input type="radio" name="userGender" value = "male" />Male
					  <input type="radio" name="userGender" value = "female" />Female
	</td>
</tr>
<tr>
	<td align="right"> Birthdate:</td>
	<td align="left"> <input type="text" name="userBirthdate" value="${userDetail.userBirthdate}"/></td>
</tr>
<tr>
	 <th colspan="2" align = "center" > <input type="submit" value="Submit"></th>
 </tr>
</table>

</form>
</body>
</html>