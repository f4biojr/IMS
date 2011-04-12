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
        <link rel="stylesheet" href="../css/estilo.css" type="text/css">
        <%@include file="js/js_menu.jsp" %>
        <title>Listar Administradores</title>
    </head>
    <body>
        <div id="topo"><%@include file="menu.jsp" %></div>
        <div id="lista">
                <c:forEach var="administrador" items="${administradores}">
                    <h3><a href="#">${administrador.nome}</a></h3>
                    <div>
                        <img src="../img/default_avatar.gif" alt="Avatar padrão">
                        <ul>
                            <li>C&oacute;digo: ${administrador.codigo}</li>
                            <li>Login: ${administrador.login}</li>
                            <li>E-mail: ${administrador.email}</li>
                            <li>
                                <a href="geral?acao=administrador.DetalhaAdministrador&codigo=${administrador.codigo}">
                                        <img src="../img/tools.gif" alt="Editar" title="Editar">
                                </a>
                                <a href="geral?acao=administrador.ExcluiAdministrador&codigo=${administrador.codigo}">
                                    <img src="../img/remove.gif" alt="Excluir" title="Excluir">
                                </a>
                            </li>
                        </ul>
                        <br clear="all">
                    </div>
                </c:forEach>
        </div>
        <%@include file="js/js_lista.jsp" %>
    </body>
</html>

