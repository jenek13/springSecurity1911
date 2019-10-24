<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.servletContext.contextPath}/admin/users/edit" method="POST">
        <input type="hidden" name="id" value="${user.id}">
        <ul>
            <li>
                <label>Username: <input type="text" name="name" value="${user.name}"></label>
            </li>
            <li>
                <label>Age: <input type="text" name="age" value="${user.age}"></label>
            </li>
            <li><input type="submit" align="center" value="Submit"/></li>
        </ul>

    </form>
</div>

</body>
</html>