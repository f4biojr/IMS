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
        String sql = "INSERT INTO servicos (src_nome,src_mib,src_ativo,src_tipo) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, servico.getNome());
        statement.setString(2, servico.getMib());
        String ativo = null;
        if (servico.isAtivo()){
            ativo = "1";
        }
        if (!servico.isAtivo()){
            ativo = "0";
        }
        statement.setString(3, ativo);
        statement.setString(4, servico.getTipo());
        statement.executeUpdate();
    }

     public void altera(Servico servico) throws SQLException, Exception {
        String sql = "UPDATE servicos SET src_nome = ?, src_mib = ?, src_ativo = ?, src_tipo = ?  WHERE src_id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, servico.getNome());
        statement.setString(2, servico.getMib());
        String ativo = null;
        if (servico.isAtivo()){
            ativo = "1";
        }
        if (!servico.isAtivo()){
            ativo = "0";
        }
        statement.setString(3, ativo);
        statement.setString(4, servico.getTipo());
        statement.setInt(5, servico.getId());
        statement.executeUpdate();
    }

    public void remove(int codigo) throws SQLException, Exception {
        String sql = "DELETE FROM servicos WHERE src_id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        statement.executeUpdate();
    }

    public List<Servico> getTodosOsServicosCadastrados() throws SQLException, Exception {
        String sql = "SELECT * FROM servicos where src_ativo = 1";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        List listaDeServicos = new ArrayList();

        while (resultSet.next()){
            Servico servico = new Servico();
            servico.setId(resultSet.getInt("src_id"));
            servico.setNome(resultSet.getString("src_nome"));
            servico.setMib(resultSet.getString("src_mib"));
            servico.setAtivo(resultSet.getBoolean("src_ativo"));
            servico.setTipo(resultSet.getString("src_tipo"));
            listaDeServicos.add(servico);
        }
        return listaDeServicos;
    }

    public Servico getServico(int codigo) throws SQLException, Exception {
        String sql = "SELECT * FROM servicos WHERE src_id = ? LIMIT 1";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        Servico servico = new Servico();
        resultSet.next();
        servico.setId(resultSet.getInt("src_id"));
        servico.setNome(resultSet.getString("src_nome"));
        servico.setMib(resultSet.getString("src_mib"));
        if (resultSet.getBoolean("src_ativo")){
            servico.setAtivo(true);
        }else{
            servico.setAtivo(false);
        }
        servico.setTipo(resultSet.getString("src_tipo"));

        return servico;

    }

    public void limpaServicos(int servidor) throws SQLException, Exception {
        String sqlDelete = "DELETE FROM servidor_has_servicos WHERE shs_id_servidor = ?";
        PreparedStatement statementDelete = (PreparedStatement) conexao.prepareStatement(sqlDelete);
        statementDelete.setInt(1, servidor);
        statementDelete.executeUpdate();
    }

    public void salvaServidorServico(int servidor, int servico) throws SQLException, Exception {
        String sql = "INSERT INTO servidor_has_servicos (shs_id_servidor,shs_id_servico) VALUES (?, ?)";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, servidor);
        statement.setInt(2, servico);
        statement.executeUpdate();
    }


}
