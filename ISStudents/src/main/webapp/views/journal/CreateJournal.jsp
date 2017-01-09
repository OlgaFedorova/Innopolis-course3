<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Добавить новую запись в журнал</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/journal/create" method="POST">
    <table>
        <tr>
            <td align="right" >Дата : </td>
            <td>
                <input type="date" name="date">
            </td>
        </tr>
        <tr>
            <td align="right" >Тема : </td>
            <td>
                <select name="subject">
                    <option value="${selected.getId()}" selected>${selected.getSubject()}</option>
                    <c:forEach items="${lectures}" var="idLecture">
                        <c:if test="${idLecture != selected}">
                            <option value="${idLecture.getId()}">${idLecture.getSubject()}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" >Студент : </td>
            <td>
                <select name="idStudent">
                    <option value="${selected.getId()}" selected>${selected.toString()}</option>
                    <c:forEach items="${students}" var="idStudent">
                        <c:if test="${idStudent != selected}">
                            <option value="${idStudent.getId()}">${idStudent.toString()}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Создать"/></td>
        </tr>
    </table>
</form>
</body>
</html>