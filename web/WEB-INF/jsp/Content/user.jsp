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
    <link rel="stylesheet" href="/resources/userPage.css" type="text/css">
</head>
<body>
<h1>User page</h1>

<table>
    <tr>
        <td></td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Middle name</td>
        <td>Mobile phone</td>
        <td>Home phone</td>
        <td>Work phone</td>
        <td>Email</td>
        <td>Group</td>
    </tr>
    <c:forEach items="${contactList}" var="item">
        <span id="id" hidden><c:out value="${item.id}"/></span>
        <tr>
           <td><input id="editRadio" type="radio" name="contactGroup"  value="<c:out value="${item.asJson}"/>"/> </td>
           <td><c:out value="${item.firstName}"/></td>
           <td><c:out value="${item.lastName}" /></td>
           <td><c:out value="${item.middleName}"/></td>
           <td><c:out value="${item.mobilePhoneNumber}"/></td>
           <td><c:out value="${item.homePhoneNumber}"/></td>
           <td><c:out value="${item.workPhoneNumber}"/></td>
           <td><c:out value="${item.email}"/></td>
           <td><c:out value="${item.group}"/></td>
        </tr>
    </c:forEach>
    <td><button id="editBtn"> Edit</button></td>
    <td><button id ="createBtn"> Create new contact</button></td>
</table>

<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close">x</span><!--Кнопка закрытия окна-->
        <form>
        <table>
            <tr hidden>
                <td><input type="text" name="editId" id="editId" hiden> First name</td>
            </tr>
            <tr>
                <td><input type="text" name="editFirstName" id="editFirstName" > First name</td>
            </tr>
            <tr>
                <td><input type="text" name="editMiddleName" id="editMiddleName"> Middle name</td>
            </tr>
            <tr>
                <td><input type="text" name="editLastName" id="editLastName"> Last name</td>
            </tr>
            <tr>
                <td><input type="text" name="editMobilePhoneNumber" id="editMobilePhoneNumber"> Mobile phone</td>
            </tr>
            <tr>
                <td><input type="text" name="editWorkPhoneNumber" id="editWorkPhoneNumber"> Work phone</td>
            </tr>
            <tr>
                <td><input type="text" name="editHomePhoneNumber" id="editHomePhoneNumber"> Home phone</td>
            </tr>
            <tr>
                <td><input type="text" name="editEmail" id="editEmail" value=""> Email</td>
            </tr>
            <tr>
                <td><input type="text" name="editGroup" id="editGroup"> Group</td>
            </tr>
        </table>

        <button  type="submit" formaction="updateContact" formmethod="get" id="submitChange">Submit</button>
        <button value="" id="editCancel">Cancel</button>
        </form>
    </div>

</div>

<a href="j_spring_security_logout">Logout</a>


<script
        src="http://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>
<script src="/resources/scripts/EditUser.js"></script>
</body>

</html>
