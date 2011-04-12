/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.servico;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fabio
 */
public class UtilsServico {

    public static Servico getServicoPopulado(HttpServletRequest request){
        Servico servico = new Servico();
        if (!request.getParameter("codigo").equals("")){
            servico.setId(Integer.parseInt(request.getParameter("codigo")));
        }
        servico.setNome(request.getParameter("nome"));
        servico.setMib(request.getParameter("mib"));
        return servico;
    }

    public static List<Servico> getServicosAtivos(List<Servico> servicosDisponiveis, List<Servico> servicosServidor){
        List<Servico> servicosAtivos = new ArrayList<Servico>();
        for (Servico servico : servicosDisponiveis){
            for (Servico servicoDoServidor : servicosServidor){
                if(servico.getId() == servicoDoServidor.getId()){
                    servico.setAtivo(true);
                }
            }
           servicosAtivos.add(servico);
        }
        return servicosAtivos;
    }
}

