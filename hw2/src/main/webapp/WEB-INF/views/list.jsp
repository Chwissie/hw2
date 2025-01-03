<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${data}">
        <tr>
            <td>${item}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>