<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список лекций</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/idLecture/CreateLecture.jsp">Добавить лекцию</a>
<table border="1">
    <tr>
        <td>Тема</td>
        <td>Количество часов теории</td>
        <td>Количество часов практики</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${lectures}" var="idLecture" varStatus="status">
        <tr valign="top">
            <td>${idLecture.getSubject()}</td>
            <td>${idLecture.getHoursOfTheory()}</td>
            <td>${idLecture.getHoursOfPractice()}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/idLecture/edit?id=${idLecture.getId()}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/idLecture/delete?id=${idLecture.getId()}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<br>
<p><a href="/index.html">НА ГЛАВНУЮ</a></p>
</body>
</html>