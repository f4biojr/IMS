package br.fabio.control.filtro;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package br.fabio.filtro;
//
//import br.univali.usuario.Usuario;
//import br.univali.usuario.UsuarioDAO;
//import com.mysql.jdbc.Connection;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author fabio
// */
//public class VerificaLogin implements Filter {
//
//    private static final boolean debug = true;
//
//    // The filter configuration object we are associated with.  If
//    // this value is null, this filter instance is not currently
//    // configured.
//    private FilterConfig filterConfig = null;
//
//    public VerificaLogin() {
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain)
//	throws IOException, ServletException {
//        //String loginForm = request.getParameter("login");
//        //String senhaForm = request.getParameter("password");
//        HttpSession session = ((HttpServletRequest)request).getSession(); //pega a sessao
//        if ( request.getParameter("login") != null || request.getParameter("password") != null){
//            try {
//                UsuarioDAO dao = new UsuarioDAO((Connection) request.getAttribute("conexao"));
//                List listaDeUsuarios = dao.getTodosOsUsuariosCadastrados();
//                String login = (String) request.getParameter("login");
//                String password = (String) request.getParameter("password");
//
//                for(int i = 0; i < listaDeUsuarios.size(); i++){
//                    Usuario usuarioBanco = (Usuario) listaDeUsuarios.get(i);
//                    //if(usuarioBanco.getLogin().equals(login) && usuarioBanco.equals(password)){
//                    boolean loginok = login.equals(usuarioBanco.getLogin());
//                    boolean senhaok = usuarioBanco.getSenha().equals(password);
//                    if( loginok && senhaok ){
//                        session.setAttribute("usuario", usuarioBanco);
//                        ((HttpServletRequest)request).setAttribute("session", session);
//                        chain.doFilter(request, response);
//                    }
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(VerificaLogin.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (Exception ex) {
//                Logger.getLogger(VerificaLogin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{
//            Usuario teste = (Usuario) session.getAttribute("usuario");
//            if (session.getAttribute("usuario") != null){
//                chain.doFilter(request, response);
//            }else{
//            ((HttpServletResponse)response).sendRedirect("../index.jsp");
//            }
//        }
//
//    }
//
//    public void init(FilterConfig fc) throws ServletException {
//    }
//
//    public void destroy() {
//
//    }
//
//}
