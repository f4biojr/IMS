<%-- 
    Document   : listarServidores
    Created on : 08/09/2010, 14:23:41
    Author     : fabio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div id="lista">
            <c:forEach var="servidor" items="${servidores}">
                <h3><a href="#">${servidor.nome}</a></h3>
                    <div>
                        <ul>
                            <li>C&oacute;digo: ${servidor.codigo}</li>
                            <li>Nome: ${servidor.nome}</li>
                            <li>Hostname: ${servidor.hostname}</li>
                            <li>IP: ${servidor.ip}</li>
                            <li>
                                <a href="geral?acao=servidor.DetalhaServidor&codigo=${servidor.codigo}">
                                        <img src="../img/tools.gif" alt="Editar" title="Editar">
                                </a>
                                <a href="geral?acao=servidor.ExcluiServidor&codigo=${servidor.codigo}">
                                    <img src="../img/remove.gif" alt="Excluir" title="Excluir">
                                </a>
                            </li>
                        </ul>
                        <br clear="all">
                    </div>
            </c:forEach>
        </div>
    </body>
</html>

