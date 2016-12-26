<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Главная</title>
</head>
<body>
<p>Текущий пользователь: ${username}</p>
<p><a href="${pageContext.servletContext.contextPath}/registration">Регистрация</a></p>
<p><a href="${pageContext.servletContext.contextPath}/security/logon">Вход</a></p>
<p><a href="${pageContext.servletContext.contextPath}/logout">Выход</a></p>
<p><a href="${pageContext.servletContext.contextPath}/main/edit-user">Редактирование профиля</a></p>
<p><a href="${pageContext.servletContext.contextPath}/main/secret">Задания</a></p>
<p><a href="${pageContext.servletContext.contextPath}/main/secret">Рейтинг пользователей</a></p>
</body>
</html>
