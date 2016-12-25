<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Вход</title>
</head>

<h2>Введите учетные данные:</h2>
<br><br>
<form action="${pageContext.servletContext.contextPath}/security/logon" method=post>
    <table>
        <tr>
            <td>Введите имя пользователя:</td>
            <td><input type="text" name="username" size="25"></td>
        </tr>
        <tr>
            <td>Введите пароль:</td>
            <td><input type="password" size="15" name="user_password"></td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Вход"/></td>
        </tr>
        <tr>
            <td><input type="reset" align="center" value="Очистить"/></td>
        </tr>
    </table>
</form>
<p><a href="/index.html">НА ГЛАВНУЮ</a></p>
</html>
