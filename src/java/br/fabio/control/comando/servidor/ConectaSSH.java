/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando.servidor;

import br.fabio.control.comando.Comando;
import br.fabio.model.dao.ServidorDAO;
import br.fabio.model.servidor.Servidor;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class ConectaSSH implements Comando {

    private String view;

    public void executa(HttpServletRequest request, HttpServletResponse response)throws Exception {
            Connection conexao = (Connection) request.getAttribute("conexao");
            ServidorDAO servidorDao = new ServidorDAO(conexao);
            Servidor servidor = servidorDao.getServidor(Integer.parseInt(request.getParameter("codigo")));
            String[] cmd = {"/usr/bin/gnome-terminal", "-e", "ssh -p 9022 fabio@"+servidor.getIp()  };
            Runtime.getRuntime().exec(cmd);

            ServidorDAO dao = new ServidorDAO(conexao);
            List<Servidor> listaServidores = dao.getTodosOsServidoresCadastrados();
            request.setAttribute("servidores", listaServidores);
            this.view = "listarServidores.jsp";
    }

    public String getView() {
        return this.view;
    }
}
