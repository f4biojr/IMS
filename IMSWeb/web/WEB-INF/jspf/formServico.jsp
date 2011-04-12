<%-- 
    Document   : formServico
    Created on : 11/11/2010, 21:33:47
    Author     : fabio
--%>

<%@ page pageEncoding="UTF-8" %>
<div>
    <fieldset>
        <legend>${param.tipo} Servico </legend>
        <form method="POST" action="geral?acao=${param.comando}">
            <label>Nome:</label><input type="text" name="nome" value="${servico.nome}"><br />
            <input type="hidden" name="codigo" value="${servico.id}">
            <label>MIB:</label><input type="text" name="mib" value="${servidor.mib}"><br />
            <button type="submit">${param.tipo}</button>
        </form>
    </fieldset>
</div>
