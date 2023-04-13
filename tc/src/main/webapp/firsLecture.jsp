
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Firs lecture</title>
</head>
<body>
<h2>${lecture.name}</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Creation date</th>
        <th>Lecture date</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${lecture.lectureId}</td>
        <td>${lecture.name}</td>
        <td>${lecture.description}</td>
        <td>${lecture.creationDate}</td>
        <td>${lecture.lectureDate}</td>
    </tr>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/person">Back</a>
</body>
</html>

