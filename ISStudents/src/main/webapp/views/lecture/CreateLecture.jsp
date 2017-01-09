<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Создание лекции</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/idLecture/create" method="POST">
    <table>
        <tr>
            <td align="right" >Тема : </td>
            <td>
                <input type="text" name="subject">
            </td>
        </tr>
        <tr>
            <td align="right" >Количество часов теории : </td>
            <td>
                <input type="text" name="hours_of_theory">
            </td>
        </tr>
        <tr>
            <td align="right" >Количество часов практики : </td>
            <td>
                <input type="text" name="hours_of_practice">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Создать"/></td>
        </tr>
    </table>
</form>
</body>
</html>