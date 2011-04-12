/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.administrador;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fabio
 */
public class UtilsAdministrador {

     public static Administrador getAdministradorPopulado(HttpServletRequest request){

        Administrador novoAdministrador = new Administrador();
        String teste = request.getParameter("codigo");
        if ( request.getParameter("codigo") != ""){
            novoAdministrador.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        }

        novoAdministrador.setNome(request.getParameter("nome"));
        novoAdministrador.setLogin(request.getParameter("login"));
        novoAdministrador.setEmail(request.getParameter("email"));
        novoAdministrador.setSenha(request.getParameter("senha"));

        return novoAdministrador;

    }
}
