<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin TaskManager</title>
</head>
<body>
	<h2>Welcome to Admin Privileges ${authUser.getName()}!</h2>
	<hr/>
	<h3>Create a New Task</h3>
	<div class="NewTask">
		<form action="admin-main" method="post">
			<label>Name:<input type="text" id="name" name="name" placeholder="Enter Name" required/></label><br/>
			<label>Task Name:<input type="text" id="taskName" name="taskName" placeholder="Enter Task Name" required/></label><br/>
			<label>Description:<input type="text" id="desc" name="desc" placeholder="Enter Task Description" required/></label><br/>
			Severity: <select id="sever" name="sever">
				<option value="low">Low</option>
				<option value="medium">Medium</option>
				<option value="high">High</option>
			</select>
			<label>Start Date:<input type="date" id="start" name="start" required/></label>
			<label>End Date:<input type="date" id="end" name="end" required/></label><br/>
			<input type="submit" value="Add Task"/> 
		</form>
	</div>
	
	<div class="manageUsers">
	<hr/>
	<h3>Manage Users</h3>
	Not integrated yet
	</div>
	<div class="ManageTasks">
	<hr/>
	<h3>Manage Tasks</h3>
	Not integrated yet
	</div>
	<hr/>
	<div class="logout">
		<form action="/logout" method="post">
			<input type="submit" value="Sign Out" />
		</form>
	</div>
	<br/>
</body>
</html>