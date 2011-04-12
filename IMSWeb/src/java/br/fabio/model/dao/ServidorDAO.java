/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.dao;

import br.fabio.model.servico.Servico;
import br.fabio.model.servidor.Servidor;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class ServidorDAO {

    private Connection conexao;

    public ServidorDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void salva(Servidor servidor) throws SQLException, Exception {
        String sql = "INSERT INTO servidores (nome,ip,community,hostname) VALUES (?, ?, ?,?)";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, servidor.getNome());
        statement.setString(2, servidor.getIp());
        statement.setString(3, servidor.getCommunity());
        statement.setString(4, servidor.getHostname());
        statement.executeUpdate();
    }

     public void altera(Servidor servidor) throws SQLException, Exception {
        String sql = "UPDATE servidores SET nome = ?, ip = ?, community = ?, hostname = ? WHERE id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, servidor.getNome());
        statement.setString(2, servidor.getIp());
        statement.setString(3, servidor.getCommunity());
        statement.setString(4, servidor.getHostname());
        statement.setInt(5, servidor.getCodigo());
        statement.executeUpdate();
    }

    public void remove(int codigo) throws SQLException, Exception {
        String sql = "DELETE FROM servidores WHERE id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        statement.executeUpdate();
    }

    public List<Servidor> getTodosOsServidoresCadastrados() throws SQLException, Exception {
        String sql = "SELECT * FROM servidores";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        List listaDeServidores = new ArrayList();

        while (resultSet.next()){
            Servidor servidor = new Servidor();
            servidor.setCodigo(resultSet.getInt("id"));
            servidor.setNome(resultSet.getString("nome"));
            servidor.setIp(resultSet.getString("ip"));
            servidor.setHostname(resultSet.getString("hostname"));
            servidor.setCommunity(resultSet.getString("community"));
            listaDeServidores.add(servidor);
        }
        return listaDeServidores;
    }

    public Servidor getServidor(int codigo) throws SQLException, Exception {
        String sql = "SELECT * FROM servidores WHERE id = ? LIMIT 1";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        Servidor servidor = new Servidor();
        resultSet.next();
        servidor.setCodigo(resultSet.getInt("id"));
        servidor.setNome(resultSet.getString("nome"));
        servidor.setIp(resultSet.getString("ip"));
        servidor.setHostname(resultSet.getString("hostname"));
        servidor.setCommunity(resultSet.getString("community"));

        return servidor;

    }

    public List<Servico> getServicosDoServidor(int codigo) throws SQLException, Exception{
        String sql = "SELECT * FROM servicos WHERE id IN (SELECT id_servico FROM servidor_has_servicos WHERE id_servidor = ?);";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        ResultSet resultSet = (ResultSet) statement.executeQuery();
        List<Servico> servicos = new ArrayList<Servico>();
        while (resultSet.next()){
            Servico servico = new Servico();
            servico.setId(resultSet.getInt("id"));
            servico.setNome(resultSet.getString("nome"));
            servico.setMib(resultSet.getString("mib"));
            servicos.add(servico);
        }
        return servicos;        
    }

//    public Servidor

}
