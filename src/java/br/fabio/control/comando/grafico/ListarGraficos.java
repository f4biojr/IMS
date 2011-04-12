/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.grafico;

import br.fabio.control.comando.Comando;
import br.fabio.model.dao.GraficoDAO;
import br.fabio.model.servidor.Servidor;
import br.fabio.model.dao.ServidorDAO;
import br.fabio.model.servico.Servico;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class ListarGraficos implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response)throws Exception {
            Connection conexao = (Connection) request.getAttribute("conexao");
            ServidorDAO dao = new ServidorDAO(conexao);
            GraficoDAO daoGrafico = new GraficoDAO(conexao);

            //fazer join para trazer servidores e serviços em uma consulta
            long tempoInicial = System.currentTimeMillis();
            List<Servidor> listaServidores = dao.getTodosOsServidoresCadastrados();
            
            for (Servidor servidor: listaServidores){
                List<Servico> servicos = dao.getServicosDoServidor(servidor.getCodigo());
                List<Servico> servicosFinal = new ArrayList<Servico>();
                for (Servico servico: servicos){
                    if(servico.isAtivo()){
                        Servico servicoFinal = daoGrafico.getEstadoNasUltimasSeisHoras(servico, servidor.getCodigo());
                        servicosFinal.add(servico);
                    }
                }
                servidor.setServicos(servicosFinal);
            }
            request.setAttribute("servidores", listaServidores);
            this.view = "listarGraficos.jsp";
            System.out.println("Tempo no banco: " + (System.currentTimeMillis() - tempoInicial));
    }

    public String getView() {
        return this.view;
    }
}
