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
        <title>Listar Servidores</title>
    </head>
    <body>
        <div id="topo"><%@include file="menu.jsp" %></div>
        <div id="lista_servidores" >
            <c:forEach var="servidor" items="${servidores}">
                <h3><a href="#${servidor.nome}">${servidor.nome}</a></h3>
                    <div>
                        <ul>
                            <c:forEach var="servico" items="${servidor.servicos}">
<!--                                <li>${servico.nome}</li>-->
                                    <li>
                                        <div id="${servidor.nome}${servico.id}" class="grafico"></div>
                                        <script type="text/javascript">
                                            var ${servidor.nome}${servico.id};
                                            ${servidor.nome}${servico.id} = new Highcharts.Chart({
                                                chart: {
                                                    renderTo: '${servidor.nome}${servico.id}',
                                                    defaultSeriesType: 'line'
                                                },
                                                title: {
                                                    text: '${servico.nome}'
                                                },
                                                xAxis: {
                                                    categories: ${servico.grafico.horario}
                                                },
                                                yAxis: {
                                                    title: {
                                                       text: ''
                                                    }
                                                },
                                                series: [{
                                                    name: '${servico.nome}',
                                                    data: ${servico.grafico.estado}
                                                }]
                                            });
                                        </script>
                                    </li>
                            </c:forEach>
                        </ul>
                        <br clear="all">
                    </div>
            </c:forEach>
        </div>
        <%@include file="js/js_lista.jsp" %>
    </body>
</html>

