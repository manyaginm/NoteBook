<%--
  Created by IntelliJ IDEA.
  User: MManiagin
  Date: 26.07.2017
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id = "main_div_regpage">

<form action ="regConfirmPage" method="post" id ="regForm">
    <table>
        <tr>
            <td>
            <label>Login: <input type="text" id="userLoginRegPage" name="userLoginRegPage"></label><span id="loginErr"></span>
            </td>
        </tr>
        <tr>
            <td>
            <label>Password: <input type="password" id="userPasswordRegPage" name="userPasswordRegPage"></label><span id="passErr"></span>
            </td>
        </tr>
        <tr>
            <td>
                <label>Submit password: <input type="password" id="userPasswordSubmitRegPage"></label><span id="submintPassErr"></span>
            </td>
        </tr>
        <tr>
            <td>
                <span id="errSpan"></span>
                <br>
                <input type="submit" value="submit" id="regSubmitBtn" name="regSubmitBtn">
            </td>
        </tr>
    </table>
</form>
</div>
<script src="../../resources/scripts/regCheck.js"></script>
</body>
</html>
