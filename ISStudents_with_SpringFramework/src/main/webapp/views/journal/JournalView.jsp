<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список записей в журнале</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/journal/create">Добавить запись</a>
<table border="1">
    <tr>
        <td>Дата</td>
        <td>Тема</td>
        <td>Имя студента</td>
        <td>Группа</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${records}" var="record" varStatus="status">
        <tr valign="top">
            <td>${record.getDateOfRecord()}</td>
            <td>${record.getLecture().getSubject()}</td>
            <td>${record.getStudent().getName()}</td>
            <td>${record.getStudent().getGroup()}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/journal/delete?id=${record.getId()}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<br>
<p><a href="/views/index.jsp">НА ГЛАВНУЮ</a></p>
</body>
</html>