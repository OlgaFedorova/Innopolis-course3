<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/registration" method="POST">
    <table>
        <tr>
            <td align="right" >Имя пользователя: </td>
            <td>
                <input type="text" size="25" name="name" value="${username}">
            </td>
        </tr>
        <tr>
            <td>Введите пароль:</td>
            <td><input type="password" size="15" name="user_password"></td>
        </tr>
        <tr>
            <td>Подтвердите пароль:</td>
            <td><input type="password" size="15" name="confirm_user_password"></td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Создать"/></td>
        </tr>
        <tr>
            <td><input type="reset" align="center" value="Очистить"/></td>
        </tr>
    </table>
</form>
<h3>${info}</h3>
<p><a href="${pageContext.servletContext.contextPath}/index">НА ГЛАВНУЮ</a></p>
</body>
</html>
