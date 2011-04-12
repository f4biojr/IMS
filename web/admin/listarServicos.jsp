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
        <title>Listar Servi&ccedil;os</title>
    </head>
    <body>
        <div id="topo"><%@include file="menu.jsp" %></div>
        <div id="lista">
            <c:forEach var="servico" items="${servicos}">
                <h3><a href="#">${servico.nome}</a></h3>
                    <div>
                        <ul>
                            <li>C&oacute;digo: ${servico.id}</li>
                            <li>Nome: ${servico.nome}</li>
                            <li>MIB: ${servico.mib}</li>
                            <li>
                                <a href="geral?acao=servico.DetalhaServico&codigo=${servico.id}">
                                        <img src="../img/tools.gif" alt="Editar" title="Editar">
                                </a>
                                <a href="geral?acao=servico.ExcluiServico&codigo=${servico.id}">
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

