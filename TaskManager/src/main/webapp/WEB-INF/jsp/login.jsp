<!DOCTYPE html>
<html>
   <head>
        <title>Task Manager Login</title>
    </head>
    <h2>User login</h2>
    <body>
        <form action="/login" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
        </form><br/>
        <a href="/adminlogin">Admin Login</a>
     </body>
     <br/>
     <a href="/register">Register</a>
</html>