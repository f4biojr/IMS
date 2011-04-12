/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fabio.model.grafico;

/**
 *
 * @author imobFort
 */
public class UtilsGrafico {
     public static String timeticksToTempo(int timeticks){
        String tempo    = new String();
        String dias     = "0";
        String horas    = "0";
        String minutos  = "0";
        String segundos = "0";


        // timeticks / 8640000 = days
        if (timeticks > 8640000){
            Integer diasInt = (timeticks / 8640000);
            dias = diasInt.toString();
            timeticks = timeticks - (8640000 * diasInt);
        }
        // timeticks / 360000 = hours
        if (timeticks > 360000){
            Integer horasInt = (timeticks / 360000);
            horas = horasInt.toString();
            timeticks = timeticks - (360000 * horasInt);
        }
        // timeticks / 6000 = minutes
        if (timeticks > 6000){
            Integer minutosInt = (timeticks / 6000);
            minutos = minutosInt.toString();
            timeticks = timeticks - (6000 * minutosInt);
        }
        // timeticks / 100 = seconds
        if (timeticks > 100){
            Integer segundosInt = (timeticks / 100);
            segundos = segundosInt.toString();
            timeticks = timeticks - (100 * segundosInt);
        }

        tempo = dias + " dias, " + horas + " horas, " + minutos +" minutos, " + segundos + " segundos ";

        return tempo;
     }
}
