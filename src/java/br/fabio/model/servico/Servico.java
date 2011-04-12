/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.servico;

import br.fabio.model.grafico.Grafico;
import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class Servico {

    private int id;
    private String nome;
    private String mib;
    private String tipo;
    private boolean ativo;
    private String estado;
    private Grafico grafico;



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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Grafico getGrafico() {
        return grafico;
    }

    public void setGrafico(Grafico grafico) {
        this.grafico = grafico;
    }

   
}
