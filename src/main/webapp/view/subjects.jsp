<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subjects</title>
</head>
<body>
<%@include file="menu.jsp" %>

<h2>Виберіть предмети</h2>
<ul>
    <c:forEach items="${requestScope.subjects}" var="subject">
        <li>
            <p><c:out value="${subject.name}"/></p>
            <input type="checkbox" name="subject_id" value="${subject}">
        </li>
    </c:forEach>
</ul>
<%--<input type="hidden" name="command" value="ShowSubjectsCommand">--%>
<%--<button type="submit">Show Subjects</button>--%>

</body>
</html>
