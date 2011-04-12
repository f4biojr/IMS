/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.servidor;

import br.fabio.model.servico.Servico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class Servidor {

    private int codigo;
    private String nome;
    private String ip;
    private String hostname;
    private String community;
    private List<Servico> servicos;
    private String uptime;
    
    public void Servidor(){
        this.servicos = new ArrayList<Servico>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getIp() {
        return ip;
    }

    public String getHostname() {
        return hostname;
    }

    public String getCommunity() {
        return community;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }

    public boolean temServico(int id){
        for (Servico servicoId : this.servicos){
            if (servicoId.getId() == id){
                return true;
            }
        }
        return false;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
    
}
