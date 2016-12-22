<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список лекций</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/lecture/CreateLecture.jsp">Добавить лекцию</a>
<table border="1">
    <tr>
        <td>Тема</td>
        <td>Количество часов теории</td>
        <td>Количество часов практики</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${lectures}" var="lecture" varStatus="status">
        <tr valign="top">
            <td>${lecture.getSubject()}</td>
            <td>${lecture.getHoursOfTheory()}</td>
            <td>${lecture.getHoursOfPractice()}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/lecture/edit?id=${lecture.getId()}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/lecture/delete?id=${lecture.getId()}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>