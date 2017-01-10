<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta charset="utf-8" />
    <title>${name}</title>
</head>
<body>
<sf:form method="POST" modelAttribute="decision">
    <table>
        <tr>
            <td align="right" >Id : </td>
            <td align="left">${task.getId()}</td>
        </tr>
        <tr>
            <td align="right" >Название : </td>
            <td align="left">${task.getName()}</td>
        </tr>
        <tr>
            <td align="right" >Содержание : </td>
            <td align="left">${task.getContent()}</td>
        </tr>
        <tr>
            <td align="right" >Решение : </td>
            <td>
                <sf:textarea path="decision" rows="30" cols="100" id="decision"/>
            </td>
        </tr>
        <tr>
            <td><input type="reset" align="center" value="Очистить"/></td>
            <td><input type="submit" align="center" value="Отправить на проверку"/></td>
        </tr>
    </table>
</sf:form>
<p><a href="${pageContext.servletContext.contextPath}/main/tasks/view">К СПИСКУ ЗАДАНИЙ</a></p>
<p><a href="${pageContext.servletContext.contextPath}/index">НА ГЛАВНУЮ</a></p>
</body>
</html>