<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.thymeleaf.org ">
   <head>
        <title>Task Manager Admin Login</title>
    </head>
    <h2>Admin login</h2>
    <body>
        <form action="admin-main" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
        </form><br/>
     </body>
     <br/> 
     <a href="/login">Return to User Login</a>
</html>