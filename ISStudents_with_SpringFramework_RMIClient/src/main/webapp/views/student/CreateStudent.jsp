<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Создание студента</title>
</head>
<body>
<sf:form method="POST" modelAttribute="student">
    <table>
        <tr>
            <td align="right" >Name : </td>
            <td>
                <sf:input path="name" type="text" id="name"/>
            </td>
        </tr>
        <tr>
            <td align="right" >Group : </td>
            <td>
                <sf:input path="group" type="text" id="group"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Создать"/></td>
        </tr>
    </table>
</sf:form>
</body>
</html>