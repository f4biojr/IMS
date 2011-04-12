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
        String sql = "INSERT INTO administradores (adm_login,adm_senha,adm_nome,adm_email,adm_admin) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, administrador.getLogin());
        statement.setString(2, administrador.getSenha());
        statement.setString(3, administrador.getNome());
        statement.setString(4, administrador.getEmail());
        statement.setBoolean(5, administrador.isAdmin());
        statement.executeUpdate();
    }

     public void altera(Administrador administrador) throws SQLException, Exception {
        String sql = "UPDATE administradores SET adm_login = ?, adm_senha = ?, adm_nome = ?, adm_email = ?, adm_admin = ? WHERE adm_id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setString(1, administrador.getLogin());
        statement.setString(2, administrador.getSenha());
        statement.setString(3, administrador.getNome());
        statement.setString(4, administrador.getEmail());
        statement.setBoolean(5, administrador.isAdmin());
        statement.setInt(6, administrador.getCodigo());
        statement.executeUpdate();
    }

    public void remove(int codigo) throws SQLException, Exception {
        String sql = "DELETE FROM administradores WHERE adm_id = ? LIMIT 1";
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

            administrador.setCodigo(resultSet.getInt("adm_id"));
            administrador.setLogin(resultSet.getString("adm_login"));
            administrador.setNome(resultSet.getString("adm_nome"));
            administrador.setSenha(resultSet.getString("adm_senha"));
            administrador.setEmail(resultSet.getString("adm_email"));
            administrador.setAdmin(resultSet.getBoolean("adm_admin"));

            listaDeAdministradores.add(administrador);
        }
        return listaDeAdministradores;
    }

    public Administrador getAdministrador(int codigo) throws SQLException, Exception {
        String sql = "SELECT * FROM administradores WHERE adm_id = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        Administrador administrador = new Administrador();
        resultSet.next();
        administrador.setCodigo(resultSet.getInt("adm_id"));
        administrador.setLogin(resultSet.getString("adm_login"));
        administrador.setNome(resultSet.getString("adm_nome"));
        administrador.setSenha(resultSet.getString("adm_senha"));
        administrador.setEmail(resultSet.getString("adm_email"));
        administrador.setAdmin(resultSet.getBoolean("adm_admin"));

        return administrador;

    }

}
