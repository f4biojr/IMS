<%-- 
    Document   : formAdministrador
    Created on : 11/11/2010, 21:33:47
    Author     : fabio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div>
    <fieldset>
        <legend>${param.tipo} Servidor </legend>
        <form method="POST" action="geral?acao=${param.comando}">
            <label>Nome:</label><input type="text" name="nome" value="${servidor.nome}"><br />
            <input type="hidden" name="codigo" value="${servidor.codigo}">
            <label>Hostname:</label><input type="text" name="hostname" value="${servidor.hostname}"><br />
            <label>IP:</label><input type="text" id="ip" name="ip" value="${servidor.ip}" onBlur="isIP(this)"><br />
            <label>Comunidade:</label><input type="text" name="comunidade" value="${servidor.community}"><br />
            <div id="monitoramento" >
                <c:if test="${not empty servicos}">
                <c:forEach var="servico" items="${servicos}">
                    <c:if test="${servico.id != 11}">
                        <div id="servicos">
                            <label for="${servico.nome}">${servico.nome}</label>
                            <input type="checkbox" class="servico" id="${servico.nome}" value="${servico.id}" <c:if test="${servico.ativo}">checked</c:if> name="servicos">
                        </div>
                    </c:if>
                </c:forEach>
                </c:if>
            </div>
            <br/><br/><br/>
            <button type="submit">${param.tipo}</button>
        </form>
    </fieldset>
</div>
