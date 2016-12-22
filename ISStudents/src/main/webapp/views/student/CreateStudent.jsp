<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/student/create" method="POST">
    <table>
        <tr>
            <td align="right" >Name : </td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td align="right" >Group : </td>
            <td>
                <input type="text" name="class">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Создать"/></td>
        </tr>
    </table>
</form>
</body>
</html>