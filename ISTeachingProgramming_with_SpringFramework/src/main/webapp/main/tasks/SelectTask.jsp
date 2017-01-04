<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>${name}</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/main/tasks/send-decision?id=${id}" method="POST">
    <table>
        <tr>
            <td align="right" >Id : </td>
            <td align="left">${id}</td>
        </tr>
        <tr>
            <td align="right" >Название : </td>
            <td align="left">${name}</td>
        </tr>
        <tr>
            <td align="right" >Содержание : </td>
            <td align="left">${content}</td>
        </tr>
        <tr>
            <td align="right" >Решение : </td>
            <td>
                <textarea rows="30" cols="100" name="decision"></textarea>>
            </td>
        </tr>
        <tr>
            <td><input type="reset" align="center" value="Очистить"/></td>
            <td><input type="submit" align="center" value="Отправить на проверку"/></td>
        </tr>
    </table>
</form>
<p><a href="${pageContext.servletContext.contextPath}/main/tasks/view">К СПИСКУ ЗАДАНИЙ</a></p>
<p><a href="${pageContext.servletContext.contextPath}/index">НА ГЛАВНУЮ</a></p>
</body>
</html>