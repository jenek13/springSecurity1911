<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Application</title>
</head>
<body>
<center>
    <h1>Users management</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/admin/users">Add New User</a>

        <a href="${pageContext.request.contextPath}/admin">List of User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${admin}" var="user" varStatus="status">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/edit?id=${user.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.servletContext.contextPath}/admin/users/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>