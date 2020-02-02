<%--@elvariable id="errorMessage" type="java.lang.String"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmx:setBundle basename="locale.usual.error" var="errorB"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><fmx:message bundle="${errorB}" key="title"/></title>
    <link href="<c:url value="/view/style/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="page-wrapper">
    <div class="menu-and-content-wrapper">
        <c:import url="/view/page/general/top_panel.jsp"/>
        <c:import url="/view/page/usual/left_panel.jsp"/>
        <div class="inner-content">
            <div class="centered">
                <h1>${errorMessage}</h1>
                <button onclick="history.back()">
                    <fmx:message bundle="${errorB}" key="button.back.to.previous.page"/>
                </button>
            </div>
        </div>
    </div>
    <c:import url="/view/page/general/footer.jsp"/>
</div>
</body>
</html>
