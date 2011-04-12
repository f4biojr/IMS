/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.servico;

/**
 *
 * @author fabio
 */
public class Servico {

    private int id;
    private String nome;
    private String mib;
    private boolean ativo;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMib() {
        return mib;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMib(String mib) {
        this.mib = mib;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
