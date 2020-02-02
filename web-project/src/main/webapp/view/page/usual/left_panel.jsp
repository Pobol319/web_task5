<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmx:setBundle basename="locale.usual.left_panel" var="leftPanelB"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><fmx:message bundle="${leftPanelB}" key="title"/></title>
</head>
<body>
<ul class="vertical-menu">
    <li>
        <form action="<c:url value="/command"/>">
            <input type="hidden" name="command" value="register_to_faculty">
            <button type="submit">
                <fmx:message bundle="${leftPanelB}" key="form.get.usual.menu.button.register"/>
            </button>
        </form>
        <br>
    </li>
        <li>
        <form action="<c:url value="/command"/>">
            <input type="hidden" name="command" value="delete_statement">
            <button type="submit">
                <fmx:message bundle="${leftPanelB}" key="form.get.usual.menu.button.delete"/>
            </button>
        </form>
        <br>
    </li>
        <li>
        <form action="<c:url value="/command"/>">
            <input type="hidden" name="command" value="do_transaction">
            <button type="submit">
                <fmx:message bundle="${leftPanelB}" key="form.get.usual.menu.button.transaction"/>
            </button>
        </form>
        <br>
    </li>
</ul>
</body>
</html>