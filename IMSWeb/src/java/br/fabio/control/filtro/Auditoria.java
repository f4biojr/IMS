package br.fabio.control.filtro;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package br.fabio.filtro;
//
//import br.univali.usuario.Usuario;
//import com.mysql.jdbc.Connection;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author fabio
// */
//public class Auditoria implements javax.servlet.Filter {
//
//    public void init(FilterConfig fc) throws ServletException {
//
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        try {
//            HttpSession session = ((HttpServletRequest)request).getSession(); //pega a sessao
//            Usuario usuarioSessao = (Usuario) session.getAttribute("usuario"); //pega usuario da sessao
//            String acao = request.getParameter("acao"); //pega a acao que esta sendo executada
//            AuditoriaDAO dao = new AuditoriaDAO((Connection) request.getAttribute("conexao"));
//            dao.salva(acao, usuarioSessao.getNome());
//        } catch (SQLException ex) {
//            Logger.getLogger(Auditoria.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(Auditoria.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        chain.doFilter(request, response);
//
//
//
//        chain.doFilter(request, response);
//    }
//
//    public void destroy() {
//
//    }
//
//}
