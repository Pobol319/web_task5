<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authorization</title>
    <link href="<c:url value="/view/style/main.css"/>" rel="stylesheet">
</head>
<body>
    <div class="centered">
        <h1>Welcome to selection committee</h1>
        <form method="post" action="<c:url value="/command"/>" class="sign-in">
            <input type="hidden" name="command" value="authorize">
            <label for="login">Login</label><br>
            <input type="text" required placeholder="Login" name="login" id="login"><br>
            <label for="password">Password</label><br>
            <input type="password" required placeholder="Password" name="password" id="password"><br>
            <button type="submit">Sign in</button>
        </form>
        <p class="error">${error}</p>
    </div>
</body>
</html>
