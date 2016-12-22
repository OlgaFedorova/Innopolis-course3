<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список студентов</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/student/CreateStudent.jsp">Добавить студента</a>
<table border="1">
    <tr>
        <td>Имя</td>
        <td>Группа</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${students}" var="student" varStatus="status">
        <tr valign="top">
            <td>${student.getName()}</td>
            <td>${student.getGroup()}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/student/edit?id=${student.getId()}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/student/delete?id=${student.getId()}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>