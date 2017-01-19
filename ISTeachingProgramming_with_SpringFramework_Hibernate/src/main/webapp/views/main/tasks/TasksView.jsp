<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список заданий</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Название</td>
        <td>Оценка</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${tasks}" var="task" varStatus="status">
        <tr valign="top">
            <td>${task[0].getName()}</td>
            <td>${task[1].getMark()}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/main/tasks/select?id=${task[0].getId()}">Выбрать</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p><a href="${pageContext.servletContext.contextPath}/index">НА ГЛАВНУЮ</a></p>
</body>
</html>