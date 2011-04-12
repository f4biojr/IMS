/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.administrador;

import br.fabio.control.comando.Comando;
import br.fabio.model.administrador.Administrador;
import br.fabio.model.dao.AdministradorDAO;
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
public class DetalhaAdministrador implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response)throws Exception{
            Connection conexao = (Connection)request.getAttribute("conexao");
            AdministradorDAO dao = new AdministradorDAO(conexao);
            Administrador administrador = dao.getAdministrador(Integer.parseInt(request.getParameter("codigo")));
            request.setAttribute("administrador", administrador);
            this.view = "detalhaAdministrador.jsp";
    }
    
    public String getView() {
        return this.view;
    }

}
