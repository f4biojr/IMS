/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.grafico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class Grafico {

    public static String getURL_GOOGLE() {
        return URL_GOOGLE;
    }

    public static void setURL_GOOGLE(String aURL_GOOGLE) {
        URL_GOOGLE = aURL_GOOGLE;
    }

    private static String URL_GOOGLE  = "https://chart.googleapis.com/chart?";

    private String titulo;
    private String tipo;
    private int largura;
    private int altura;
    private List<String> dados = new ArrayList<String>();
    private List<String> labels = new ArrayList<String>();
    private String url_final;

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public List<String> getDados() {
        return dados;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setDados(List<String> dados) {
        this.setDados(dados);
    }

    public void setLabels(List<String> labels) {
        this.setLabels(labels);
    }

    public String getUrl_final() {
        return url_final;
    }

    public void setUrl_final(String url_final) {
        this.url_final = url_final;
    }

    public void addDados(String dado){
        this.dados.add(dado);
    }

    
}
