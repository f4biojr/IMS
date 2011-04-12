package br.fabio.model.dao;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package br.fabio.filtro;
//
//import br.univali.log.Log;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author fabio
// */
//public class AuditoriaDAO {
//
//    public Connection conexao = null;
//
//    AuditoriaDAO(Connection conexao) {
//        this.conexao = conexao;
//    }
//
//
//    public void salva(String acao, String nomeUsuario) throws SQLException, Exception {
//        String sql = "INSERT INTO log (data, usuario, acao) VALUES (now(), ?, ?)";
//        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
//        statement.setString(1, nomeUsuario);
//        statement.setString(2, acao);
//        statement.executeUpdate();
//    }
//
//    public List getLogPeloCodigo(int codigo) throws SQLException, Exception {
//        String sql = "SELECT * FROM log WHERE codigo = ?";
//        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
//        statement.setInt(1, codigo);
//        ResultSet resultSet = (ResultSet) statement.executeQuery();
//
//        List listaDeAcoes = new ArrayList();
//
//        while (resultSet.next()){
//            Log log = new Log();
//            log.setId(resultSet.getInt("id"));
//            log.setData(resultSet.getDate("data"));
//            log.setAcao(resultSet.getString("acao"));
//            log.setUsuario(resultSet.getString("usuario"));
//            listaDeAcoes.add(log);
//        }
//
//        return listaDeAcoes;
//
//    }
//
//}
