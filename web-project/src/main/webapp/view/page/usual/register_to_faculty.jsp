<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmx:setBundle basename="locale.usual.faculties_menu" var="facultiesMenuB"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><fmx:message bundle="${facultiesMenuB}" key="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="<c:url value="/view/style/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="page-wrapper">
    <div class="menu-and-content-wrapper">
        <c:import url="/view/page/general/top_panel.jsp"/>
        <c:import url="/view/page/usual/left_panel.jsp"/>
        <div class="inner-content">
            <h1><fmx:message bundle="${facultiesMenuB}" key="head"/></h1>

            <%--@elvariable id="allFaculties" type="java.util.List<com.epam.project.entity.Faculty>"--%>
            <c:forEach items="${allFaculties}" var="faculty">
                <div class="entity">
                    <h3><fmx:message bundle="${facultiesMenuB}" key="faculty.name"/> - ${faculty.name}</h3>
                    <p><fmx:message bundle="${facultiesMenuB}" key="faculty.maxSize"/> - ${faculty.maxSize}</p>
                </div>
            </c:forEach>
        </div>
    </div>
    <br><br>
    <form method="post" action="<c:url value="/command"/>" >
    <p><fmx:message bundle="${facultiesMenuB}" key="choose.faculty"/></p>
    <select name="facultyId">
    <c:forEach items="${allFaculties}" var="faculty">
    <option value = "${faculty.id}"> ${faculty.name}</option>
    </c:forEach>
    </select>
                    <input type="hidden" name="command" value="get_required_subjects">
                    <button type="submit">
                        <fmx:message bundle="${facultiesMenuB}" key="faculty.get.subjects"/>
                    </button>
                </form>

    <br><br>
    <c:import url="/view/page/general/footer.jsp"/>
</div>
</body>
</html>