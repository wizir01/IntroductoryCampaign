<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rating</title>
</head>
<body>
<%@include file="menu.jsp" %>

<h1>Rating</h1>
<form method="post" action="/">
    <select name="DepartmentId">
        <c:forEach var="department" items="${requestScope.departments}">
            <option value="${department.id}"><c:out value="${department.name}, місць: ${department.places}"></c:out></option>
        </c:forEach>
    </select>
    <p><input type="submit" value="Select"></p>
    <input type="hidden" name="command" value="ShowRatingCommand">
</form>
<br>
<table border="1">
    <tr>
        <td>University name</td>
        <td>Speciality</td>
        <td>Applicant name</td>
        <td>Rating</td>
    </tr>
    <c:forEach var="rating" items="${requestScope.ratings}">
        <tr>
            <td><c:out value="${rating.universityName}"></c:out></td>
            <td><c:out value="${rating.specialityName}"></c:out></td>
            <td><c:out value="${rating.userName}"></c:out></td>
            <td><c:out value="${rating.rating}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<c:if test="${requestScope.isAdmin}">
    <form>
        <input type="hidden" name="command" value="SendNotificationsCommand">
        <input type="submit" value="Send notifications">
    </form>
    <c:out value="${requestScope.Send}"></c:out>
</c:if>
</body>
</html>
