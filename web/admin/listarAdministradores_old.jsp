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
        <div id="topo"></div>
        <div id="menu"><%@include file="menu.jsp" %></div>
        <div id="lista">
            <fieldset>
                <legend>Lista de Administradores</legend>
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th>C&oacute;digo</th>
                        <th>Login</th>
                        <th>Nome</th>
                        <th>E-mail</th>
                        <th>Remover</th>
                    </tr>
                    <c:forEach var="administrador" items="${administradores}">
                        <tr>
                            <td><a href="geral?acao=administrador.DetalhaAdministrador&codigo=${administrador.codigo}">${administrador.codigo}</a></td>
                            <td>${administrador.login}</td>
                            <td>${administrador.nome}</td>
                            <td>${administrador.email}</td>
                            <td>
                                <form method="POST" action="geral?acao=administrador.ExcluiAdministrador&codigo=${administrador.codigo}" id="${administrador.codigo}">
                                    <input type="hidden" value="${administrador.codigo}" name="codigo">
                                    <input type="submit" value="X">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </div>
    </body>
</html>

