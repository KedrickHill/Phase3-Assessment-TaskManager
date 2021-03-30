<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.thymeleaf.org ">
<head>
<title>Admin TaskManager</title>
</head>
<body>
<section>
	<h2>Welcome to Admin Privileges <span th:text="${authUser.name}"></span>!</h2>
	<hr/>
	<h3>Create a New Task</h3>
	<div class="NewTask">
		<form action="/admin-main/addTask" method="post">
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
	</section>
	
	
	<div class="manageUsers">
	<section>
	<hr/>
	<h3>Manage Users</h3>
		<table id="UsersTable">
			<thead>
				<tr>
					<th>Name of User</th>
					<th>Email</th>
					<th>Role</th>
				</tr>
			</thead>
			<tbody>
				<tr th:if="${allUsers.empty}">
					<td>No Tasks are Set</td>
				</tr>
				<tr th:each="user : ${allUsers}">
					<td><span th:name="name" th:text="${user.name}"> Name </span></td>
					<td><span th:name="email" th:text="${user.email}"> Email </span></td>
					<td><span th:name="role" th:text="${user.role}"> Role </span></td>
				</tr>
			</tbody>
		</table>
<!-- 		<input type="submit" value="Save"/> -->
	</section>
	</div>
	
	<div class="manageUser-update-and-delete">
		<aside>
			<form action="/admin/manageUsers" method="post">
				<select name="userName" id="userName">
					<option th:each="user : ${allUsers}" th:value="${user.name}" th:text="${user.name}"></option>
				</select>
				<input type="submit" value="Delete"/>
			</form>
		</aside>
	</div>
	
	<div class="ManageTasks">
	<hr/>
	<section>
	<h3>Manage Tasks</h3>
		<table id="TasksTable">
			<thead>
				<tr>
					<th>Assigned To</th>
					<th>Contact Email</th>
					<th>Task Name</th>
					<th>Description</th>
					<th>Severity</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Completed</th>
				</tr>
			</thead>
			<tbody>
				<tr th:if="${allTasks.empty}">
					<td>No Tasks are Set</td>
				</tr>
				<tr th:each="task : ${allTasks}">
					<td><span th:text="${task.user.name}">Assignment</span></td>
					<td><span th:text="${task.user.email}">Contact</span></td>
					<td><span th:text="${task.name}"> Name </span></td>
					<td><span th:text="${task.description}"> Description </span></td>
					<td><span th:text="${task.severity}"> Severity </span></td>
					<td><span th:text="${task.start}"> Start Date </span></td>
					<td><span th:text="${task.end}"> End Date </span></td>
					<td><span th:text="${task.isComplete}"> Completed</span></td>
				</tr>
			</tbody>
		</table>
<!-- 		<input type="submit" value="Save"/> -->
	</section>
	</div>
	<hr/>
	
	<div class="logout">
		<form action="/logout" method="post">
			<input type="submit" value="Sign Out"/>
		</form>
	</div>
	<br/>
	<br/>
	
</body>
</html>