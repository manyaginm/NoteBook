<%--
  Created by IntelliJ IDEA.
  User: MManiagin
  Date: 21.07.2017
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/main.css"/>

</head>
<body>
<%--Если объект ошибки не пуст, то ошибка выводиться на экран--%>


<%--Ссылка должна быть именно такая--%>
<div id="main_div">
    <form name="form_login" action="j_spring_security_check" method="post"  id="mainForm">
        <table id="table">
            <tr>
                <td>User: </td>
                <td><input type="text" name="user_login" value="" id ="userLogin"></td>
                <td id="userError"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password_login" id="userPassword"></td>
                <td id="passwordError"></td>
            </tr>
            <tr>
                <td><input type="checkbox" name="_spring_security_remember_me" class="checkAdmin"/>Remember user</td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="submit" id="submitBtn"></td>
            </tr>
        </table>
        <c:if test="${not empty error}">
            <p id="errorMsg">${error}</p>
        </c:if>
    </form>
</div>


<script src="../../resources/scripts/main.js"></script>
</body>
</html>
