<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${name}</title>
</head>
<body>
    <table>
        <tr>
            <td align="right" >Id : </td>
            <td align="left" >${id}</td>
        </tr>
        <tr>
            <td align="right" >Название : </td>
            <td align="left" >${name}</td>
        </tr>
        <tr>
            <td align="right" >Содержание : </td>
            <td align="left" >${content}</td>
        </tr>
        <tr>
            <td align="right" >Решение : </td>
            <td align="left" >${decision}</td>
        </tr>
        <tr>
            <td align="right" >Оценка : </td>
            <td align="left" >${mark}</td>
        </tr>
    </table>
<p><a href="${pageContext.servletContext.contextPath}/main/tasks/view">К СПИСКУ ЗАДАНИЙ</a></p>
<p><a href="${pageContext.servletContext.contextPath}/index">НА ГЛАВНУЮ</a></p>
</body>
</html>