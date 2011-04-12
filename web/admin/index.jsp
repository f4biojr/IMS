<%-- 
    Document   : index
    Created on : 01/12/2010, 16:53:40
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

        <title>JSP Page</title>
    </head>
    <body>
        <div id="topo"><%@include file="menu.jsp" %></div>
        <div id="menu">
            <ul>
                
            </ul>
        </div>
        <div id="monitor">
            <div id="uptime">
                <ul>
                    <li><h3>Uptime</h3></li>
                    <c:forEach var="servidor" items="${servidores}">
                        <li>
                            <p>${servidor.nome}:<span>${servidor.uptime}</span></p>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        
    </body>
</html>
