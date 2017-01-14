<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<h2>Вы авторизованы в системе как ${username}.</h2>
<p>Необходимо выйти из системы. Нажмите <a href="${pageContext.servletContext.contextPath}/logout">здесь</a>, чтобы выйти.</p>
<p><a href="${pageContext.servletContext.contextPath}/index">НА ГЛАВНУЮ</a></p>
</body>
</html>
