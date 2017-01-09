<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Создание студента</title>
</head>
<body>
<sf:form method="POST" enctype="multipart/form-data">
    <table>
        <tr>
            <td align="right" >Image : </td>
            <td><input name="image" type="file"/>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Создать"/></td>
        </tr>
    </table>
</sf:form>
</body>
</html>