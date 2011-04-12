<%-- 
    Document   : formServico
    Created on : 11/11/2010, 21:33:47
    Author     : fabio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div>
    <fieldset>
        <legend>${param.tipo} Servico </legend>
        <form method="POST" action="geral?acao=${param.comando}">
            <label>Nome:</label><input type="text" name="nome" value="${servico.nome}"><br />
            <input type="hidden" name="codigo" value="${servico.id}">
            <label>MIB:</label><input type="text" name="mib" value="${servico.mib}"><br />
            <label>Tipo:</label><input type="text" name="tipo" value="${servico.tipo}"><br />
            <label>Ativo:</label><input type="radio" name="ativo" value="sim" <c:if test="${servico.ativo}"> checked </c:if> >
            <label>Inativo:</label><input type="radio" name="ativo" value="nao" <c:if test="${servico.ativo == false}"> checked </c:if> ><br />
            <button type="submit">${param.tipo}</button>
        </form>
    </fieldset>
</div>
