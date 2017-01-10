<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Вход</title>
</head>

<h2>Введите учетные данные:</h2>
<br><br>
<sf:form method="POST" modelAttribute="user">
    <table>
        <tr>
            <td>Введите имя пользователя:</td>
            <td><sf:input path="name" type="text" id="username" size="25"/></td>
        </tr>
        <tr>
            <td>Введите пароль:</td>
            <td><sf:input path="password" type="password" size="15" id="user_password"/></td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Вход"/></td>
        </tr>
        <tr>
            <td><input type="reset" align="center" value="Очистить"/></td>
        </tr>
    </table>
</sf:form>
<p><a href="/index">НА ГЛАВНУЮ</a></p>
</html>
