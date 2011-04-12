/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.servidor;

import br.fabio.control.comando.Comando;
import br.fabio.model.dao.ServicoDAO;
import br.fabio.model.servidor.Servidor;
import br.fabio.model.dao.ServidorDAO;
import br.fabio.model.servico.Servico;
import br.fabio.model.servico.UtilsServico;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class DetalhaServidor implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
            Connection conexao = (Connection) request.getAttribute("conexao");
            ServidorDAO servidorDao = new ServidorDAO(conexao);
            ServicoDAO servicoDao = new ServicoDAO(conexao);
            Servidor servidor = servidorDao.getServidor(Integer.parseInt(request.getParameter("codigo")));
            servidor.setServicos(servidorDao.getServicosDoServidor(servidor.getCodigo()));
            List<Servico> servicos = UtilsServico.getServicosAtivos(servicoDao.getTodosOsServicosCadastrados(), servidor.getServicos());
            //List<Servico> servicos = servicoDao.getTodosOsServicosCadastrados();
            request.setAttribute("servidor", servidor);
            request.setAttribute("servicos", servicos);
            this.view = "detalhaServidor.jsp";
    }

    public String getView() {
        return this.view;
    }

}
