/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control.filtro;

import br.fabio.control.ConnectionFactory;
import java.sql.Connection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author fabio
 */
public class CriaConexao implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public CriaConexao() {
    } 

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
	throws IOException, ServletException {

        try {
            Connection conexao = ConnectionFactory.getConexao();
            request.setAttribute("conexao", conexao);
            chain.doFilter(request, response);
            conexao.close();
        } catch (Exception ex) {
            Logger.getLogger(CriaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 

    /**
     * Destroy method for this filter 
     */
    public void destroy() { 
    }

    /**
     * Init method for this filter 
     */
    public void init(FilterConfig filterConfig) {
        
    }

    public void log(String msg) {
	filterConfig.getServletContext().log(msg); 
    }

}
