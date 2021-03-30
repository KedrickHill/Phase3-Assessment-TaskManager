<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.thymeleaf.org ">
   <head>
        <title>Task Manager Login</title>
    </head>
    <h2>User login</h2>
    <body>
        <form action="user-main" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
        </form><br/>
        <a href="/adminlogin">Admin Login</a>
     </body>
     <br/>
     <a href="/register">Register</a>
</html>