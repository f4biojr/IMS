/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.administrador;

import br.fabio.model.administrador.Administrador;
import br.fabio.model.dao.AdministradorDAO;
import br.fabio.model.administrador.UtilsAdministrador;
import br.fabio.control.comando.Comando;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class CadastraAdministrador implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception{
            Connection conexao = (Connection)request.getAttribute("conexao");
            AdministradorDAO dao = new AdministradorDAO(conexao);
            Administrador administrador = UtilsAdministrador.getAdministradorPopulado(request);
            dao.salva(administrador);
            this.view = "geral?acao=administrador.ListarAdministradores";
    }

    public String getView() {
        return this.view;
    }

}
