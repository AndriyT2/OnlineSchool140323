<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Schema: Online school.</title>
</head>
<body>
<h2>Schema: Online school.Person.</h2>
<table border="2">
    <thead>
    <tr>
        <th>ID</th>
        <th>Lastname</th>
        <th>Role</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.personId}</td>
            <td>
                <a href="${pageContext.request.contextPath}/concretePerson?personIdSQL=${person.personId}">${person.lastname}</a>
            </td>
            <td>${person.role}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
