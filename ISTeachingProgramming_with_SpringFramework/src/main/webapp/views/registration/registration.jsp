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
                <sf:input path="name" type="text" size="25" id="name" value="${username}"/>
            </td>
        </tr>
        <tr>
            <td>Введите пароль:</td>
            <td><sf:input path="password" type="password" size="15" id="user_password"/></td>
        </tr>
        <tr>
            <td>Подтвердите пароль:</td>
            <td><sf:input path="confirmPassword" type="password" size="15" id="confirm_user_password"/></td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Создать"/></td>
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
