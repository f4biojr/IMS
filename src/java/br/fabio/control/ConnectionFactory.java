/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.control;


//import br.fabio.model.servidor.Servidor;
import java.sql.Connection;
//import java.io.InputStream;
//import java.sql.DriverManager;
//import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author fabio
 */
public class ConnectionFactory {


    private static DataSource dataSource;

    public static Connection getConexao() throws Exception {

        try{
            if ( dataSource == null){

                InitialContext contextoInicial = new InitialContext();
                Context contexto = (Context) contextoInicial.lookup("java:/comp/env");
                dataSource = (DataSource) contexto.lookup("ims");
            }

            return (Connection) dataSource.getConnection();
        }
        catch(Exception e){
            throw new Exception("Falha na conexao - " + e);
        }
    }

//    public static Connection getConexao() throws Exception {
//
//        Properties arquivoDePropriedades = new Properties();
//        InputStream is = Servidor.class.getClassLoader().getResourceAsStream("db.properties");
//        arquivoDePropriedades.load(is);
//
//        String driver = arquivoDePropriedades.getProperty("banco.driver");
//
//        String url = arquivoDePropriedades.getProperty("banco.url");
//        String usuario = arquivoDePropriedades.getProperty("banco.usuario");
//        String senha = arquivoDePropriedades.getProperty("banco.senha");
//
//        try{
//            Class.forName(driver).newInstance();
//            return (Connection) DriverManager.getConnection(url, usuario, senha);
//        }
//        catch(Exception e){
//            throw new Exception("Falha na conexão - " + e);
//        }
//
//    }

}
