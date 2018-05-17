<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>

</head>
<body>

<h1>list of users</h1><br />

<%--<c:forEach var="user" items="${requestScope.users}">--%>
    <%--<ul>--%>
        <%--<li>name: <c:out value="${user.name}"/></li>--%>

        <%--<li>email: <c:out value="${user.email}"/></li--%>

        <%--<li>password: <c:out value="${user.password}"/></li>--%>
    <%--</ul>--%>
<%--</c:forEach>--%>

<h1>registration</h1>

<form method="post" action="/">
    <label><input type="text" name="name"></label>name<br>
    <label><input type="text" name="email"></label>email<br>
    <label><input type="text" name="password"></label>password<br>

    <input type="hidden" name="command" value="RegistrationCommand">
    <button type="submit">registration</button>
</form>

<p>${requestScope.error}</p>

</body>
</html>