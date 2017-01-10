<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Редактирование лекции</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/lecture/edit" method="POST">
    <input type="hidden" name="id" value="${id}">
    <table>
        <tr>
            <td align="right" >Id : </td>
            <td align="right" >${id}</td>
        </tr>
        <tr>
            <td align="right" >Тема : </td>
            <td>
                <input type="text" name="subject" value="${subject}">
            </td>
        </tr>
        <tr>
            <td align="right" >Количество часов теории : </td>
            <td>
                <input type="text" name="hours_of_theory" value="${hours_of_theory}">
            </td>
        </tr>
        <tr>
            <td align="right" >Количество часов практики : </td>
            <td>
                <input type="text" name="hours_of_practice" value="${hours_of_practice}">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Отправить"/></td>
        </tr>
    </table>
</form>
</body>
</html>