<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h2>Registration Form</h2>
<hr/>
<br/>
<form action="/registered" method=post>
	Name:<abbr title="mandatory-field" aria-label="required">*</abbr> <br/>
	<input type="text" id="name" name="name" placeholder="Enter Name" required/><br/><br/>
	Email:<abbr title="mandatory-field1" aria-label="required">*</abbr> <br/>
	<input type="email" id="email" name="email" placeholder="Enter Email" required/><br/><br/>
	Password:<abbr title="mandatory-field2" aria-label="required">*</abbr> <br/>
	<input type="password" id="password" name="password" placeholder="Enter Password" required/><br/><br/>
	Retype Password:<abbr title="mandatory-field3" aria-label="required">*</abbr> <br/>
	<input type="password" id="pswd" name="pswd" placeholder="Retype Password" required/>	<br/><br/>
	<input type="submit" value="Register"/>
</form>
</body>
</html>