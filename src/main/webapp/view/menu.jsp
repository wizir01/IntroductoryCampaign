<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<fmt:setLocale value="${requestScope.locale}"/>
<fmt:setBundle basename="local"/>
<ul>
    <li><a href="/?command=MainCommand"><fmt:message key="menu_home"/></a></li>
    <li><a href="/?command=ShowSubjectCommand"><fmt:message key="menu_subjects"/></a></li>
    <li><a href="/?command=ShowExamsCommand"><fmt:message key="menu_exams"/></a></li>
    <li><a href="/?command=ShowUniversitiesCommand"><fmt:message key="menu_university"/></a></li>
    <li><a href="/?command=RatingCommand"><fmt:message key="menu_rating"/></a></li>
    <li><a href="/?command=LogoutCommand">Log Out</a></li>
    <li><a href="/?locale=ru&command=LocalizationCommand">ru</a></li>
    <li><a href="/?locale=en&command=LocalizationCommand">en</a></li>
</ul>

</body>
</html>
