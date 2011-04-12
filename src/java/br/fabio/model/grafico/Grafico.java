/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.grafico;

import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class Grafico {

    private ArrayList<String> horario = new ArrayList<String>();
    private ArrayList<String> estado = new ArrayList<String>();


    public ArrayList<String> getHorario() {
        return horario;
    }

    public ArrayList<String> getEstado() {
        return estado;
    }

    public void setHorario(ArrayList<String> horario) {
        this.horario = horario;
    }

    public void setEstado(ArrayList<String> estado) {
        this.estado = estado;
    }

    public void addHorario(String horario) {
        this.horario.add("'"+horario+"'");
    }

    public void addEstado(String estado) {
        this.estado.add(estado);
    }

    
}
