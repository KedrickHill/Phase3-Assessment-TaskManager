<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.thymeleaf.org ">
<head>
<title>Task Manager</title>
</head>
<body>
	<h1>
		Hello <span th:text="${authUser.name}">Name</span>!
	</h1>

	<h3>Current Tasks of the Day</h3>
	<form action="/user-main" method="post">
		<table>
			<thead>
				<tr>
					<th>Task Name</th>
					<th>Description</th>
					<th>Severity</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Completed</th>
				</tr>
			</thead>
			<tbody>
				<tr th:if="${ListOfTasks.empty}">
					<td>No Tasks are Set</td>
				</tr>
				<tr th:each="task : ${ListOfTasks}">
					<td><span th:text="${task.name}"> Name </span></td>
					<td><span th:text="${task.description}"> Description </span></td>
					<td><span th:text="${task.severity}"> Severity </span></td>
					<td><span th:text="${task.start}"> Start Date </span></td>
					<td><span th:text="${task.end}"> End Date </span></td>
					<td><input type="checkbox" id="status" name="status[]" /></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Save"/>
	</form>
	<br/>
	<form action="/logout" method="post">
		<input type="submit" value="Sign Out" />
	</form>
</body>
</html>