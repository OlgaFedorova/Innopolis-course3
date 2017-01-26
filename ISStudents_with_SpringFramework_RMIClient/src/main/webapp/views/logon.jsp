<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<h1>My Login:</h1>
<form name='f' action="/login" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td>
                <input name="submit" type="submit" value="submit" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </td>
        </tr>
    </table>
</form>
<p><a href="${pageContext.servletContext.contextPath}/index">НА ГЛАВНУЮ</a></p>
</body>
</html>
