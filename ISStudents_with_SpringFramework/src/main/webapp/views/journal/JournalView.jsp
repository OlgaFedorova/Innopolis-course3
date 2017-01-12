<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Список записей в журнале</title>
</head>
<body>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="${pageContext.servletContext.contextPath}/journal/create">Добавить запись</a>
</sec:authorize>
<table border="1">
    <tr>
        <td>Дата</td>
        <td>Тема</td>
        <td>Имя студента</td>
        <td>Группа</td>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <td>Действия</td>
        </sec:authorize>
    </tr>
    <c:forEach items="${records}" var="record" varStatus="status">
        <tr valign="top">
            <td>${record.getDateOfRecord()}</td>
            <td>${record.getLecture().getSubject()}</td>
            <td>${record.getStudent().getName()}</td>
            <td>${record.getStudent().getGroup()}</td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td>
                    <a href="${pageContext.servletContext.contextPath}/journal/delete?id=${record.getId()}">Удалить</a>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<br>
<p><a href="/index">НА ГЛАВНУЮ</a></p>
</body>
</html>