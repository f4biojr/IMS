/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public interface Comando {

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public String  getView();

}
