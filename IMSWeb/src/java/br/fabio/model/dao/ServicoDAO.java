/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.dao;

import br.fabio.model.servico.Servico;
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
public class ServicoDAO {

    private Connection conexao;

    public ServicoDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void salva(Servico servico) throws SQLException, Exception {
        String sql = "INSERT INTO servicos (nome,mib) VALUES (?, ?)";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, servico.getNome());
        statement.setString(2, servico.getMib());
        statement.executeUpdate();
    }

     public void altera(Servico servico) throws SQLException, Exception {
        String sql = "UPDATE servicos SET nome = ?, mib = ? WHERE id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, servico.getNome());
        statement.setString(2, servico.getMib());
        statement.setInt(3, servico.getId());
        statement.executeUpdate();
    }

    public void remove(int codigo) throws SQLException, Exception {
        String sql = "DELETE FROM servicos WHERE id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        statement.executeUpdate();
    }

    public List<Servico> getTodosOsServicosCadastrados() throws SQLException, Exception {
        String sql = "SELECT * FROM servicos";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        List listaDeServicos = new ArrayList();

        while (resultSet.next()){
            Servico servico = new Servico();
            servico.setId(resultSet.getInt("id"));
            servico.setNome(resultSet.getString("nome"));
            servico.setMib(resultSet.getString("mib"));
            listaDeServicos.add(servico);
        }
        return listaDeServicos;
    }

    public Servico getServico(int codigo) throws SQLException, Exception {
        String sql = "SELECT * FROM servicoes WHERE id = ? LIMIT 1";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        Servico servico = new Servico();
        resultSet.next();
        servico.setId(resultSet.getInt("id"));
        servico.setNome(resultSet.getString("nome"));
        servico.setMib(resultSet.getString("mib"));

        return servico;

    }

    public void limpaServicos(int servidor) throws SQLException, Exception {
        String sqlDelete = "DELETE FROM servidor_has_servicos WHERE id_servidor = ?";
        PreparedStatement statementDelete = (PreparedStatement) conexao.prepareStatement(sqlDelete);
        statementDelete.setInt(1, servidor);
        statementDelete.executeUpdate();
    }

    public void salvaServidorServico(int servidor, int servico) throws SQLException, Exception {
        String sql = "INSERT INTO servidor_has_servicos (id_servidor,id_servico) VALUES (?, ?)";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, servidor);
        statement.setInt(2, servico);
        statement.executeUpdate();
    }

}
