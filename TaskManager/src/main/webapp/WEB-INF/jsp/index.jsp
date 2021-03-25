<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="ISO-8859-1">
<title>TaskManager Main</title>
</head>
<body>
	<h1>Welcome to Task Manager!</h1>

	<p>
		Click <a th:href="@{/welcome}">here</a> to continue to login page for task management.
	</p>
</body>
</html>