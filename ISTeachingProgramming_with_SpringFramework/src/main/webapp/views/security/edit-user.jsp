<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<sf:form method="POST" modelAttribute="user">
    <table>
        <tr>
            <td align="right" >Имя пользователя: </td>
            <td>
                ${user.getName()}
            </td>
        </tr>
        <tr>
            <td>Введите текущий пароль:</td>
            <td><sf:input path="currentPassword" type="password" size="15" id="current_password"/></td>
        </tr>
        <tr>
            <td>Введите новый пароль:</td>
            <td><sf:input path="newPassword" type="password" size="15" id="new_password"/></td>
        </tr>
        <tr>
            <td>Подтвердите пароль:</td>
            <td><sf:input path="confirmNewPassword" type="password" size="15" id="confirm_password"/></td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Сохранить"/></td>
        </tr>
        <tr>
            <td><input type="reset" align="center" value="Очистить"/></td>
        </tr>
    </table>
</sf:form>
<h3>${info}</h3>
<p><a href="${pageContext.servletContext.contextPath}/index">НА ГЛАВНУЮ</a></p>
</body>
</html>
