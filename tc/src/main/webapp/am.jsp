
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Additional Materials</title>
</head>
<body>
<h2>Additional Materials</h2>
<table border="1">
    <thead>
    <tr>
        <th>Type</th>
        <th>Count</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="am" items="${am}">
        <tr>
            <td>${am.resourceType}</td>
            <td>${am.typeTotal}</td>

        </tr>
    </c:forEach>

    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
