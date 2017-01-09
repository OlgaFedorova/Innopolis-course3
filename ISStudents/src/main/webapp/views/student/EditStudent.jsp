<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Редактирование студента</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/idStudent/edit" method="POST">
    <input type="hidden" name="id" value="${id}">
    <table>
        <tr>
            <td align="right" >Id : </td>
            <td align="right" >${id}</td>
        </tr>
        <tr>
            <td align="right" >Имя : </td>
            <td>
                <input type="text" name="name" value="${name}">
            </td>
        </tr>
        <tr>
            <td align="right" >Группа : </td>
            <td>
                <input type="text" name="group" value="${group}">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Отправить"/></td>
        </tr>
    </table>
</form>
</body>
</html>