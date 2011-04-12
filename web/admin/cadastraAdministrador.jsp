<%-- 
    Document   : principal
    Created on : 03/09/2010, 14:27:57
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/estilo.css" type="text/css">
        <%@include file="js/js_menu.jsp" %>
        <title>Cadastrar Administrador</title>
    </head>
    <body>
        <div id="topo"><%@include file="menu.jsp" %></div>
        <div id="cadastro">
            <jsp:include page="/WEB-INF/jspf/formAdministrador.jsp">
                <jsp:param name="tipo" value="Cadastrar" />
                <jsp:param name="comando" value="administrador.CadastraAdministrador" />
            </jsp:include>
        </div>
        <%@include file="js/js_lista.jsp" %>
    </body>
</html>
