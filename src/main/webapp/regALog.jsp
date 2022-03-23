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
    <title>URaHERO</title>
</head>
<body>
<img src="https://seaofmadness.webs.com/Welcome_flames.gif" style="width:50%;margin-left:auto;margin-right:auto;display:block;margin-bottom:3%">
<fieldset style="width:25%;padding:4%;background-color:grey;float:left;margin-left:10%">
    <form method="post" action="MainServletPrihlaseni" style="align-content:center;margin-left:auto;margin-right:auto;display:block;"> <!-- udělat 2 servlety jeden na přihlášení další na registraci -->
        <h1 style="font-variant-caps:all-small-caps;font-family:monospace">Přihlášení</h1>
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
</fieldset>
<fieldset style="width:25%;padding:4%;background-color:grey;float:right;margin-right:10%">
    <form method="post" action="MainServlet" style="align-content:center;margin-left:auto;margin-right:auto;display:block;">
        <h1 style="font-variant-caps:all-small-caps;font-family:monospace">Registrace</h1>
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
    </form>
</fieldset>
<H1 style="text-align:center;margin-top:25%;color:${messageColor}">${message}</H1>
</body>
</html>