/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.servidor;

import br.fabio.model.dao.ServicoDAO;
import br.fabio.model.servico.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fabio
 */
public class UtilsServidor {

    public static Servidor getServidorPopulado(HttpServletRequest request){
        Servidor servidor = new Servidor();
        if (!request.getParameter("codigo").equals("")){
            servidor.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        }
        servidor.setCommunity(request.getParameter("comunidade"));
        servidor.setHostname(request.getParameter("hostname"));
        servidor.setIp(request.getParameter("ip"));
        servidor.setNome(request.getParameter("nome"));
        if ( request.getParameterValues("servicos") != null ){
            String[] servicos = request.getParameterValues("servicos");
            List<Servico> servicosServidor = new ArrayList<Servico>();
            for (String idServico: servicos){
            Servico servico = new Servico();
            servico.setId(Integer.parseInt(idServico));
            servicosServidor.add(servico);
        }
        servidor.setServicos(servicosServidor);
        }
        return servidor;    
    }
}
