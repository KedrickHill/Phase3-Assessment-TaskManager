<!DOCTYPE html>
<html>
   <head>
        <title>Task Manager Admin Login</title>
    </head>
    <h2>Admin login</h2>
    <body>
        <form action="/adminlogin" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
        </form><br/>
     </body>
     <br/>
     <a href="/login">Return to User Login</a>
</html>