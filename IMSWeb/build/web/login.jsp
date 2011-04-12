<%-- 
    Document   : index
    Created on : 03/09/2010, 14:22:57
    Author     : fabio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IMSWeb</title>
    </head>
    <body>
        <h3>IMSWeb</h3>
        <form method="POST" action="j_security_check" id="formLogin">
            <label for="login">Nome:</label><input type="text" name="j_username" id="login">
            <br />
            <label for="senha">Senha:</label><input type="password" name="j_password" id="senha">
            <br />
            <input type="submit" value="Login">
        </form>
    </body>
</html>