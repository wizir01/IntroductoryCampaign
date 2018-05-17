<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Log In</h1>

<form method="post" action="">

    <label><input type="text" name="email"></label>email<br>

    <label><input type="text" name="password"></label>password<br>

    <input type="hidden" name="command" value="LoginCommand">
    <button type="submit">Login</button>

</form>

<p>${requestScope.notFound}</p>

<a href="/view/registration.jsp">Create new account</a>

</body>
</html>
