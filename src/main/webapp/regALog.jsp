<%--
  Created by IntelliJ IDEA.
  User: urman
  Date: 22.03.2022
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PŘIHLÁŠENÍ</title>
</head>
<body>
<form method="post" action="MainServletPrihlaseni"> <!-- udělat 2 servlety jeden na přihlášení další na registraci -->
    <p>
        <label for="jmenoPrihlaseni">Jméno: </label>
        <input type="text" id="jmenoPrihlaseni" name="jmenoPrihlaseni" minlength="2" maxlength="30"
               value="${jmenoAttribute}" required autofocus>
    </p>
    <p>
        <label for="hesloPrihlaseni">Heslo: </label>
        <input type="password" id="hesloPrihlaseni" name="hesloPrihlaseni" minlength="3" maxlength="30"
               value="${hesloAttribute}" required>
    </p>
    <p>
        <input type="submit" name="prihlaseni" value="Přihlásit se">
    </p>
</form>
<form method="post" action="MainServlet">
    <p>
        <label for="jmenoRegistrace">Jméno: </label>
        <input type="text" id="jmenoRegistrace" name="jmenoRegistrace" minlength="2" maxlength="30" required autofocus>
    </p>
    <p>
        <label for="hesloRegistrace">Heslo: </label>
        <input type="password" id="hesloRegistrace" name="hesloRegistrace" minlength="3" maxlength="30" required>
    </p>
    <p>
        <input type="submit" name="registrace" value="Registrovat se">
    </p>
    <H1>Message: ${message}</H1>
</form>
</body>
</html>
