<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MManiagin
  Date: 21.07.2017
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User page</h1>

<table>

    <c:forEach items="${contactList}" var="item">
        <tr>
           <td><c:out value="${item.firstName}"/></td>
           <td><c:out value="${item.lastName}"/></td>
           <td><c:out value="${item.middleName}"/></td>
           <td><c:out value="${item.mobilePhoneNumber}"/></td>
           <td><c:out value="${item.homePhoneNumber}"/></td>
           <td><c:out value="${item.workPhoneNumber}"/></td>
           <td><c:out value="${item.email}"/></td>
           <td><c:out value="${item.group}"/></td>
        </tr>
    </c:forEach>

</table>

<a href="j_spring_security_logout">Logout</a>
</body>
</html>
