<%-- 
    Document   : formAdministrador
    Created on : 11/11/2010, 21:33:47
    Author     : fabio
--%>

<%@ page pageEncoding="UTF-8" %>
<div>
    <fieldset>
        <legend>${param.tipo} Administrador </legend>
        <form method="POST" action="geral?acao=${param.comando}">
            <label>Nome:</label><input type="text" name="nome" value="${administrador.nome}"><br />
            <input type="hidden" name="codigo" value="${administrador.codigo}">
            <label>Login:</label><input type="text" name="login" value="${administrador.login}"><br />
            <label>Senha:</label><input type="text" name="senha" value="${administrador.senha}"><br />
            <label>E-mail:</label><input type="text" name="email" value="${administrador.email}"><br />
            <button type="submit">${param.tipo}</button>
        </form>
    </fieldset>
</div>
