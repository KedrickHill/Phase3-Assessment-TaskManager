<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.thymeleaf.org ">
<head>
<meta charset="ISO-8859-1">
<title>Registered</title>
</head>
<body>
<h2>Congratulations <span th:text="${newUser.name}">Name</span>, You Have Been Registered!</h2>
Can sign in <a href="/login">here</a>.
</body>
</html>