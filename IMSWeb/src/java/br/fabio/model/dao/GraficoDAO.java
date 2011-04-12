/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.dao;
import br.fabio.model.grafico.Grafico;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author fabio
 */
public class GraficoDAO {
    
    private Connection conexao;

    public GraficoDAO(Connection conexao){
        this.conexao = conexao;
    }

    public List getDadosPorPeriodoPorServicoPorServidor(Date data_inicial, Date data_final, int codigo_servico, int codigo_servidor) throws SQLException, Exception{
        
        java.sql.Date data_inicial_sql = new java.sql.Date(data_inicial.getTime());
        java.sql.Date data_final_sql = new java.sql.Date(data_final.getTime());

        String sql = "SELECT estado FROM estado WHERE horario > ? AND horario < ? AND id_servico = ? AND id_servidor = ?";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setDate(1, data_inicial_sql);
        statement.setDate(2, data_final_sql);
        statement.setInt(3, codigo_servico);
        statement.setInt(4, codigo_servidor);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        Grafico grafico = new Grafico();
        List dados = new ArrayList();

        while (resultSet.next()){
            
        }


        return dados;
    }
}
