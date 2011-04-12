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
        String sql = "INSERT INTO servidores (srv_nome,srv_ip,srv_community,srv_hostname) VALUES (?, ?, ?,?)";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, servidor.getNome());
        statement.setString(2, servidor.getIp());
        statement.setString(3, servidor.getCommunity());
        statement.setString(4, servidor.getHostname());
        statement.executeUpdate();
    }

     public void altera(Servidor servidor) throws SQLException, Exception {
        String sql = "UPDATE servidores SET srv_nome = ?, srv_ip = ?, srv_community = ?, srv_hostname = ? WHERE srv_id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, servidor.getNome());
        statement.setString(2, servidor.getIp());
        statement.setString(3, servidor.getCommunity());
        statement.setString(4, servidor.getHostname());
        statement.setInt(5, servidor.getCodigo());
        statement.executeUpdate();
    }

    public void remove(int codigo) throws SQLException, Exception {
        String sql = "DELETE FROM servidores WHERE srv_id = ?";
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
            servidor.setCodigo(resultSet.getInt("srv_id"));
            servidor.setNome(resultSet.getString("srv_nome"));
            servidor.setIp(resultSet.getString("srv_ip"));
            servidor.setHostname(resultSet.getString("srv_hostname"));
            servidor.setCommunity(resultSet.getString("srv_community"));
            
            listaDeServidores.add(servidor);
        }
        return listaDeServidores;
    }

    public Servidor getServidor(int codigo) throws SQLException, Exception {
        String sql = "SELECT * FROM servidores WHERE srv_id = ? LIMIT 1";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        Servidor servidor = new Servidor();
        resultSet.next();
        servidor.setCodigo(resultSet.getInt("srv_id"));
        servidor.setNome(resultSet.getString("srv_nome"));
        servidor.setIp(resultSet.getString("srv_ip"));
        servidor.setHostname(resultSet.getString("srv_hostname"));
        servidor.setCommunity(resultSet.getString("srv_community"));

        return servidor;

    }

    public List<Servico> getServicosDoServidor(int codigo) throws SQLException, Exception{
        String sql = "SELECT * FROM servicos WHERE src_id IN (SELECT shs_id_servico FROM servidor_has_servicos WHERE shs_id_servidor = ?);";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        ResultSet resultSet = (ResultSet) statement.executeQuery();
        List<Servico> servicos = new ArrayList<Servico>();
        while (resultSet.next()){
            Servico servico = new Servico();
            servico.setId(resultSet.getInt("src_id"));
            servico.setNome(resultSet.getString("src_nome"));
            servico.setMib(resultSet.getString("src_mib"));
            servico.setAtivo(resultSet.getBoolean("src_ativo"));
            servico.setTipo(resultSet.getString("src_tipo"));
            servicos.add(servico);
        }
        return servicos;        
    }

    public void salvaUptime(int servidor) throws SQLException, Exception {
        String sql = "INSERT INTO servidor_has_servicos (shs_id_servidor,shs_id_servico) VALUES (?, 11)";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, servidor);
        statement.executeUpdate();
    }

//    public Servidor

}
