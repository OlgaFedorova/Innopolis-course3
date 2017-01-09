<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Создание лекции</title>
</head>
<body>
<sf:form method="POST" modelAttribute="lecture">
    <table>
        <tr>
            <td align="right" >Тема : </td>
            <td>
                <sf:input path="subject" type="text" id="subject"/>
            </td>
        </tr>
        <tr>
            <td align="right" >Количество часов теории : </td>
            <td>
                <sf:input path="hoursOfTheory" type="text" id="hours_of_theory"/>
            </td>
        </tr>
        <tr>
            <td align="right" >Количество часов практики : </td>
            <td>
                <sf:input path="hoursOfPractice" type="text" id="hours_of_practice"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Создать"/></td>
        </tr>
    </table>
</sf:form>
</body>
</html>