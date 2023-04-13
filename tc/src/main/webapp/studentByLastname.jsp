
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>StudentByLastname</title>
</head>
<body>
<h2>StudentByLastname</h2>
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
<c:forEach var="student" items="${students}">
<tr>
        <td>${student.personId}</td>
        <td>${student.lastname}</td>
        <td>${student.firstname}</td>
        <td>${student.phone}</td>
        <td>${student.email}</td>
    </tr>
</c:forEach>

    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
