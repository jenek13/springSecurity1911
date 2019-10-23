<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Add user</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/admin/users" method="POST">
	<ul>
		<li>
			<label>Username: <input type="text" name="name"></label>
		</li>
		<li>
			<label>Age: <input type="text" name="age"></label>
		</li>
		<li><input type="submit" align="center" value="Submit"/></li>
	</ul>

</form>
</body>
</html>