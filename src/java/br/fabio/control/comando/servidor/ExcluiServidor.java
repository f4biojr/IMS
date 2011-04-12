/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.servidor;

import br.fabio.control.comando.Comando;
import br.fabio.model.dao.ServidorDAO;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class ExcluiServidor implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response)throws Exception {
            Connection conexao = (Connection) request.getAttribute("conexao");
            ServidorDAO dao = new ServidorDAO(conexao);
            dao.remove(Integer.parseInt(request.getParameter("codigo")));
            this.view = "geral?acao=servidor.ListarServidores";
    }

    public String getView() {
        return this.view;
    }

}
