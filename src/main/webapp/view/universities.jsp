<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Universities</title>
</head>
<body>
<%@include file="menu.jsp" %>

<h1>Universities</h1>
<form method="post" action="/">
    <select name="UniversityId">
        <c:forEach var="university" items="${requestScope.universities}">
            <option value="${university.id}"><c:out value="${university.name}"></c:out></option>
        </c:forEach>
    </select>
    <p><input type="submit" value="Select"></p>
    <input type="hidden" name="command" value="ShowDepartmentsCommand">
</form>
<br>
<p>
    <c:out value="${requestScope.failure}"></c:out>
    <c:forEach var="reqSubject" items="${requestScope.reqSubjects}">
        <c:out value="${reqSubject.name}; "></c:out>
    </c:forEach>
</p>

<table border="1">
    <tr>
        <td>Speciality</td>
        <td>Study Places</td>
        <c:if test="${!requestScope.isAdmin}"><td>Select</td></c:if>

    </tr>
    <c:forEach var="department" items="${requestScope.departments}">
        <form method="post" action="/">
            <tr>
                <td><c:out value="${department.name}"></c:out></td>
                <td><c:out value="${department.places}"></c:out></td>
                    <input type="hidden" name="command" value="SelectDepartmentCommand">
                <input type="hidden" name="DepartmentId" value="${department.id}">
                <c:if test="${!requestScope.isAdmin}"><td><input type="submit" name="button" value="Submit"></td></c:if>

            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
