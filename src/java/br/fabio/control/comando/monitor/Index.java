/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.monitor;

import br.fabio.control.comando.Comando;
import br.fabio.model.dao.GraficoDAO;
import br.fabio.model.dao.ServidorDAO;
import br.fabio.model.grafico.UtilsGrafico;
import br.fabio.model.servidor.Servidor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;
/**
 *
 * @author imobFort
 */
public class Index implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Connection conexao = (Connection) request.getAttribute("conexao");
            ServidorDAO dao = new ServidorDAO(conexao);
            GraficoDAO daoGrafico = new GraficoDAO(conexao);
            List<Servidor> listaServidores = dao.getTodosOsServidoresCadastrados();
            for (Servidor servidor: listaServidores){
                Integer uptime = daoGrafico.getUptime(servidor.getCodigo());
                servidor.setUptime(UtilsGrafico.timeticksToTempo(uptime));
            }
            request.setAttribute("servidores", listaServidores);
            this.view = "index.jsp";
    }

    public String getView() {
        return this.view;
    }

}
