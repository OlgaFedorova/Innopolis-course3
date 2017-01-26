<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Добавить новую запись в журнал</title>
</head>
<body>
<sf:form method="POST" modelAttribute="journal">
    <table>
        <tr>
            <td align="right" >Дата : </td>
            <td>
                <sf:input path="dateOfRecord" type="date" id="date_of_record"/>
            </td>
        </tr>

        <tr>
            <td align="right" >Тема : </td>
            <td>
                <sf:select path="idLecture" id="lectures">
                    <c:forEach items="${lectures}" var="lecture">
                        <sf:option value="${lecture.getId()}">
                            <c:out value="${lecture.getSubject()}"/>
                        </sf:option>
                    </c:forEach>
                </sf:select>
            </td>
        </tr>
        <tr>
            <td align="right" >Студент : </td>
            <td>
                <sf:select path="idStudent" id="students">
                    <c:forEach items="${students}" var="student">
                        <sf:option value="${student.getId()}">
                            <c:out value="${student.getName()}"/>
                        </sf:option>
                    </c:forEach>
                </sf:select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Создать"/></td>
        </tr>
    </table>
</sf:form>
</body>
</html>