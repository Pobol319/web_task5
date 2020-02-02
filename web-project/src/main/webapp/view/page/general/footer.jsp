<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmx:setBundle basename="locale.general.footer" var="footerB"/>
<html>
<head>
    <title><fmx:message bundle="${footerB}" key="title"/></title>
</head>
<body>
<div class="footer"><p><fmx:message bundle="${footerB}" key="text"/></p></div>
</body>
</html>
