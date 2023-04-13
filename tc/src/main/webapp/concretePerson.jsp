
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person.${conPersons.lastname}</title>
</head>
<body>
<h2>Person.${conPersons.lastname}</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Lastname</th>
        <th>Firstname</th>
        <th>Phone</th>
        <th>E-Mail</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${conPersons.personId}</td>
        <td>${conPersons.lastname}</td>
        <td>${conPersons.firstname}</td>
        <td>${conPersons.phone}</td>
        <td>${conPersons.email}</td>
        <td>${conPersons.role}</td>
    </tr>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/person">Back</a>
</body>
</html>

