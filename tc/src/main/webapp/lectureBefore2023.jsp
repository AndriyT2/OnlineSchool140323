
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>LectureBefore2023</title>
</head>
<body>
<h2>Lecture before 2023</h2>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>AM count</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="lecture" items="${lectures}">
        <tr>
            <td>${lecture.name}</td>
            <td>${lecture.amCount}</td>
          </tr>
    </c:forEach>

    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
