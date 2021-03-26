<!DOCTYPE html>
<html>
 <head>
        <title>Task Manager</title>
    </head>
    <body>
        <h1>Hello ${authUser.getName()}!</h1>
        
        <h3>Current Tasks of the Day</h3>
        <form action="/logout" method="post">
            <input type="submit" value="Sign Out"/>
        </form>
    </body>
</html>