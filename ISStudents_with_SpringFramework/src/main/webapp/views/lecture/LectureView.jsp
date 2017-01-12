<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Список лекций</title>
</head>
<body>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="${pageContext.servletContext.contextPath}/lecture/create">Добавить лекцию</a>
</sec:authorize>
<table border="1">
    <tr>
        <td>Тема</td>
        <td>Количество часов теории</td>
        <td>Количество часов практики</td>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <td>Действия</td>
        </sec:authorize>
    </tr>
    <c:forEach items="${lectures}" var="lecture" varStatus="status">
        <tr valign="top">
            <td>${lecture.getSubject()}</td>
            <td>${lecture.getHoursOfTheory()}</td>
            <td>${lecture.getHoursOfPractice()}</td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td>
                    <a href="${pageContext.servletContext.contextPath}/lecture/edit?id=${lecture.getId()}">Редактировать</a>
                    <a href="${pageContext.servletContext.contextPath}/lecture/delete?id=${lecture.getId()}">Удалить</a>
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