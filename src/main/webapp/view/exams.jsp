<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exams</title>
</head>
<body>
<%@include file="menu.jsp" %>

<h1>Exams</h1>
<p>${requestScope.emptyField}</p>
<c:forEach var="exam" items="${requestScope.exams}">
    <form method="post" action="/">
        <ul>
            <li>
                <p><c:out value="${exam.userName}"></c:out></p>
            </li>
            <li>
                <p><c:out value="${exam.subjectName}"></c:out></p>
            </li>
            <c:if test="${!requestScope.admin}">
                <li>
                    <p><c:out value="${exam.mark}"></c:out></p>
                </li>
            </c:if>
            <c:if test="${requestScope.admin}">
                <c:if test="${exam.mark != 0}">
                    <li>
                        <p><c:out value="${exam.mark}"></c:out></p>
                    </li>
                </c:if>
                <c:if test="${exam.mark == 0}">
                    <li>
                        <label><input type="number" min="1" max="100" name="mark"></label> mark<br>
                    </li>
                    <input type="hidden" name="id" value="${exam.id}">
                    <input type="hidden" name="command" value="SetMarkCommand">
                    <button type="submit">Set Mark</button>
                </c:if>
            </c:if>
        </ul>
    </form>
    <hr>
</c:forEach>
</body>
</html>
