<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MManiagin
  Date: 21.07.2017
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>admin page</h1>
<table>

<c:forEach items="${usersList}" var="item">
    <tr>
        <td><label><c:out value="${item.username}"/> Edit user</label></td>
    </tr>
</c:forEach>

</table>
<a href="/j_spring_security_logout">Logout</a>
</body>
</html>
