/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.servico;

import br.fabio.model.servico.Servico;
import br.fabio.model.dao.ServicoDAO;
import br.fabio.model.servico.UtilsServico;
import br.fabio.control.comando.Comando;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class CadastraServico implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception{
            Connection conexao = (Connection) request.getAttribute("conexao");
            ServicoDAO dao = new ServicoDAO(conexao);
            Servico servico = UtilsServico.getServicoPopulado(request);
            dao.salva(servico);
            this.view = "geral?acao=servico.ListarServicos";
    }

    public String getView() {
        return this.view;
    }

}
