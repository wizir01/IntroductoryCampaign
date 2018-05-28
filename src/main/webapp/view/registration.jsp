<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>

</head>
<body>
<h1>registration</h1>

<form method="post" action="/">
    <label><input type="text" required maxlength="60" name="name"></label>name<br>
    <label><input type="email" required maxlength="60" name="email" pattern="^[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\.)+[a-z]{2,6}$"></label>email<br>
    <label><input type="text" required maxlength="60" name="password"></label>password<br>

    <input type="hidden" name="command" value="RegistrationCommand">
    <input type="submit" name="button" value="Submit">
</form>
<a href="/">Log In</a>

<p>${requestScope.error}</p>

</body>
</html>