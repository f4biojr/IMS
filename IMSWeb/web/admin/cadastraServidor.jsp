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
        <link rel="stylesheet" href="../estilo.css" type="text/css">
        <%@include file="js/js_menu.jsp" %>
        <%@include file="js/js_lista.jsp" %>
        <title>Cadastrar Servidor</title>
    </head>
    <body>
        <div id="topo"><%@include file="menu.jsp" %></div>
        <div id="cadastro">
            <jsp:include page="/WEB-INF/jspf/formServidor.jsp">
                <jsp:param name="tipo" value="Cadastrar" />
                <jsp:param name="comando" value="servidor.CadastraServidor" />
            </jsp:include>
        </div>
        
    </body>
</html>
