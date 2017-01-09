<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список студентов</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/idStudent/CreateStudent.jsp">Добавить студента</a>
<table border="1">
    <tr>
        <td>Имя</td>
        <td>Группа</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${students}" var="idStudent" varStatus="status">
        <tr valign="top">
            <td>${idStudent.getName()}</td>
            <td>${idStudent.getGroup()}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/idStudent/edit?id=${idStudent.getId()}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/idStudent/delete?id=${idStudent.getId()}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<br>
<p><a href="/index.html">НА ГЛАВНУЮ</a></p>
</body>
</html>