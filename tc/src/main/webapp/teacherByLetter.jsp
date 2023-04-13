
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Teacher before N</title>
</head>
<body>
<h2>Teachers before letter N</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Lastname</th>
        <th>Firstname</th>
        <th>Phone</th>
        <th>E-Mail</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="teacher" items="${teacher}">
        <tr>
            <td>${teacher.personId}</td>
            <td>${teacher.lastname}</td>
            <td>${teacher.firstname}</td>
            <td>${teacher.phone}</td>
            <td>${teacher.email}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
