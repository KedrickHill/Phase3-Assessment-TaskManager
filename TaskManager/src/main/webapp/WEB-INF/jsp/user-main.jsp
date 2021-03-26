<!DOCTYPE html>
<html>
 <head>
        <title>Task Manager</title>
    </head>
    <body>
        <h1>Hello ${authUser.getName()}!</h1>
        <form action="/logout" method="post">
            <input type="submit" value="Sign Out"/>
        </form>
    </body>
</html>