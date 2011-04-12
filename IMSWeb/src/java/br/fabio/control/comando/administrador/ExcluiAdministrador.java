/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.administrador;

import br.fabio.control.comando.Comando;
import br.fabio.model.dao.AdministradorDAO;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class ExcluiAdministrador implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
            Connection conexao = (Connection)request.getAttribute("conexao");
            AdministradorDAO dao = new AdministradorDAO(conexao);
            dao.remove(Integer.parseInt(request.getParameter("codigo")));
            this.view = "geral?acao=administrador.ListarAdministradores";

    }

    public String getView() {
        return this.view;
    }

}
