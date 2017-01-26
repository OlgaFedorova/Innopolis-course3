<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Редактирование студента</title>
</head>
<body>
<sf:form mmethod="POST" modelAttribute="student">
    <table>
        <tr>
            <td align="right" >Id : </td>
            <td align="right" >${student.getId()}</td>
        </tr>
        <tr>
            <td align="right" >Имя : </td>
            <td>
                <sf:input path="name" type="text" id="name" value="${student.getName()}"/>
            </td>
        </tr>
        <tr>
            <td align="right" >Группа : </td>
            <td>
                <sf:input path="group" type="text" id="group" value="${student.getGroup()}"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Отправить"/></td>
        </tr>
    </table>
</sf:form>
</body>
</html>