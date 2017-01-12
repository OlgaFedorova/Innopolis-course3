<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ошибка входа</title>
</head>
<body>
<h2>Неверные имя пользователя или пароль.</h2>
<p>Введите корректные имя пользователя и пароль. Нажмите <a href="${pageContext.servletContext.contextPath}/logon">здесь</a>, чтобы попробовать снова.</p>
<p><a href="${pageContext.servletContext.contextPath}/index">НА ГЛАВНУЮ</a></p>
</body>
</html>
