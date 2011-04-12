/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.administrador;

import br.fabio.control.comando.Comando;
import br.fabio.model.administrador.Administrador;
import br.fabio.model.dao.AdministradorDAO;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class ListarAdministradores implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response)throws Exception {
            Connection conexao = (Connection)request.getAttribute("conexao");
            AdministradorDAO dao = new AdministradorDAO(conexao);
            List<Administrador> listaAdministradores = dao.getTodosOsAdministradoresCadastrados();
            request.setAttribute("administradores", listaAdministradores);
            this.view = "listarAdministradores.jsp";
    }

    public String getView() {
        return this.view;
    }
}
