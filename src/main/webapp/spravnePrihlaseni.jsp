<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

<%
    request.setCharacterEncoding("UTF-8");
    String pocet = request.getParameter("pocet");
%>

<h1 color="green">Přihlášení č.${pocet} úspěšné!!</h1>
<img src="http://www.lolpix.com/_pics/Funny_Pictures_216/Funny_Pictures_21610.jpg">
<br><br><br>
<form>
    <input type="submit" name="odhášeni" onclick="regALog.jsp" value="Odhlásit">
</form>
</body>
</html>