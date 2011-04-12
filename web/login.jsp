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
        <link rel="stylesheet" href="../css/estilo.css" type="text/css">
        <title>IMSWeb</title>
    </head>
    <body class="login">
        <div>
            <img class="logo" src="../img/ims_logo_150_83.png" alt="IMS logo">
            <form method="POST" action="j_security_check" id="formLogin">
                <br>
                <label for="login">Nome:</label><input type="text" name="j_username" id="login">
                <br>
                <label for="senha">Senha:</label><input type="password" name="j_password" id="senha">
                <input type="submit" value="Login">
            </form>
        </div>
        
    </body>
</html>