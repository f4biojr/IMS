/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.dao;
import br.fabio.model.grafico.Grafico;
import br.fabio.model.servico.Servico;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
/**
 *
 * @author fabio
 */
public class GraficoDAO {
    
    private Connection conexao;

    public GraficoDAO(Connection conexao){
        this.conexao = conexao;
    }

   
    public Servico getEstadoNasUltimasSeisHoras(Servico servico, int id_servidor) throws SQLException, Exception{

        String sql = "SELECT est_estado,est_horario FROM estado WHERE est_horario > SUBTIME(NOW(),'0:30:0') AND est_id_servico = ? AND est_id_servidor = ? GROUP BY est_horario ORDER BY est_horario;";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, servico.getId());
        statement.setInt(2, id_servidor);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        String resultado = "";
        Grafico grafico = new Grafico();
        while (resultSet.next()){
            String estado = resultSet.getString("est_estado");
            if (servico.getTipo().equals("int")){
                if (estado.contains("Timeout") || estado.contains("Error") || estado.contains("Unknown") || estado.contains("Failure")){
                    estado = "";
                }
                estado = estado.replace("\"", "");
                estado = estado.replace("(", "");
                estado = estado.replace(")", "");
                if( !estado.equals("") && Float.parseFloat(estado) > 1000 ){
                    Float estadoFloat = Float.parseFloat(estado) / 1024;
                    Integer estadoInt = Math.round(estadoFloat.intValue());
                    estado = estadoInt.toString();                    
                }
            }
            java.sql.Timestamp horarioSQL  = resultSet.getTimestamp("est_horario");
            String horario = new SimpleDateFormat("HH:mm").format(horarioSQL);
            if (resultado.equals("")){
                resultado = "['" + horario + "'," + estado + "]";
            }else{
                resultado = resultado + ",['" + horario + "'," + estado + "]";
            }
            servico.setEstado(resultado);
            grafico.addEstado(estado);
            grafico.addHorario(horario);
        }
        servico.setGrafico(grafico);
        return servico;
    }

    public Integer getUptime(int id_servidor) throws SQLException, Exception{
        String sql = "SELECT est_estado, est_horario FROM estado WHERE est_horario > SUBTIME(NOW(),'0:10:0') AND est_id_servico = 11 AND est_id_servidor = ? ORDER BY est_horario LIMIT 1;";
        PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, id_servidor);
        ResultSet resultSet = (ResultSet) statement.executeQuery();

        String estado = "0";
        while (resultSet.next()){
            estado = resultSet.getString("est_estado").replace(")", "").replace("(", "");
            if (estado.contains("Timeout") || estado.contains("Error") || estado.contains("Unknown") || estado.contains("Failure")){
                    estado = "0";
                }
        }
        Integer estadoInt = Integer.parseInt(estado);
        return estadoInt;
    }
}
