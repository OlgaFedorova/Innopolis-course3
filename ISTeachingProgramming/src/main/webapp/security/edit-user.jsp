<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/main/edit-user" method="POST">
    <table>
        <tr>
            <td align="right" >Имя пользователя: </td>
            <td>
                ${username}
            </td>
        </tr>
        <tr>
            <td>Введите текущий пароль:</td>
            <td><input type="password" size="15" name="current_password"></td>
        </tr>
        <tr>
            <td>Введите новый пароль:</td>
            <td><input type="password" size="15" name="new_password"></td>
        </tr>
        <tr>
            <td>Подтвердите пароль:</td>
            <td><input type="password" size="15" name="confirm_password"></td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Сохранить"/></td>
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
