<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Список студентов</title>
</head>
<body>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="${pageContext.servletContext.contextPath}/student/create">Добавить студента</a>
</sec:authorize>
<table border="1">
    <tr>
        <td>Имя</td>
        <td>Группа</td>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <td>Действия</td>
        </sec:authorize>
    </tr>
    <c:forEach items="${students}" var="student" varStatus="status">
        <tr valign="top">
            <td>${student.getName()}</td>
            <td>${student.getGroup()}</td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td>
                    <a href="${pageContext.servletContext.contextPath}/student/edit?id=${student.getId()}">Редактировать</a>
                    <a href="${pageContext.servletContext.contextPath}/student/delete?id=${student.getId()}">Удалить</a>
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