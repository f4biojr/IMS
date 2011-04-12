/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.dao;

import br.fabio.model.administrador.Administrador;
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
public class AdministradorDAO {

    private Connection conexao;

    public AdministradorDAO(Connection conexao) {
        this.conexao = conexao;
    }



    public void salva(Administrador administrador) throws SQLException, Exception {
        String sql = "INSERT INTO administradores (login,senha,nome,email) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, administrador.getLogin());
        statement.setString(2, administrador.getSenha());
        statement.setString(3, administrador.getNome());
        statement.setString(4, administrador.getEmail());
        statement.executeUpdate();
    }

     public void altera(Administrador administrador) throws SQLException, Exception {
        String sql = "UPDATE administradores SET login = ?, senha = ?, nome = ?, email = ? WHERE id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, administrador.getLogin());
        statement.setString(2, administrador.getSenha());
        statement.setString(3, administrador.getNome());
        statement.setString(4, administrador.getEmail());
        statement.setInt(5, administrador.getCodigo());
        statement.executeUpdate();
    }

    public void remove(int codigo) throws SQLException, Exception {
        String sql = "DELETE FROM administradores WHERE id = ? LIMIT 1";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        statement.executeUpdate();
    }

    public List getTodosOsAdministradoresCadastrados() throws SQLException, Exception {
        String sql = "SELECT * FROM administradores";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        List listaDeAdministradores = new ArrayList();

        while (resultSet.next()){

            Administrador administrador = new Administrador();

            administrador.setCodigo(resultSet.getInt("id"));
            administrador.setLogin(resultSet.getString("login"));
            administrador.setNome(resultSet.getString("nome"));
            administrador.setSenha(resultSet.getString("senha"));
            administrador.setEmail(resultSet.getString("email"));

            listaDeAdministradores.add(administrador);
        }
        return listaDeAdministradores;
    }

    public Administrador getAdministrador(int codigo) throws SQLException, Exception {
        String sql = "SELECT * FROM administradores WHERE id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        Administrador administrador = new Administrador();
        resultSet.next();
        administrador.setCodigo(resultSet.getInt("id"));
        administrador.setLogin(resultSet.getString("login"));
        administrador.setNome(resultSet.getString("nome"));
        administrador.setSenha(resultSet.getString("senha"));
        administrador.setEmail(resultSet.getString("email"));

        return administrador;

    }

}
