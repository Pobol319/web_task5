<%--@elvariable id="user" type="com.epam.project.entity.User"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmx:setLocale value="${locale}" scope="session"/>
<fmx:setBundle basename="locale.usual.menu" var="menuB"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><fmx:message bundle="${menuB}" key="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="<c:url value="/view/style/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="page-wrapper">
    <div class="menu-and-content-wrapper">
        <c:import url="/view/page/general/top_panel.jsp"/>
        <c:import url="/view/page/usual/left_panel.jsp"/>
        <div class="inner-content">
            <h1><fmx:message bundle="${menuB}" key="head"/>, ${user.login}!</h1>
        </div>
    </div>
    <c:import url="/view/page/general/footer.jsp"/>
</div>
</body>
</html>