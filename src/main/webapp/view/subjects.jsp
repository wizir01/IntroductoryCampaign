<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subjects</title>
</head>
<body>
<%@include file="menu.jsp" %>

<h2>Select subjects</h2>
<p>${requestScope.noAvailable}</p>
<form method="post" action="/">
    <ul>
        <c:forEach var="subject" items="${requestScope.subjects}">
            <li>
                <p><c:out value="${subject.name}"/></p>

                <input type="checkbox" name="subjectId" value="${subject.id}">

            </li>
        </c:forEach>
    </ul>

    <p>
        <input type="hidden" name="command" value="SelectSubjectsCommand">
        <input type="submit" name="button" value="Submit">
    </p>
    <p>${requestScope.emptyCheckbox}</p>
</form>
</body>
</html>
