package com.ikerman.myapplication;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by widemos on 25/2/16.
 */
public class Ruta {
    private int id;
    private double[] rutax;
    private double[] rutay;
    private int hora;
    private int min;
    private int segundos;
    private int dia;
    private int mes;
    private int año;

    public Ruta() {



    }

    public Ruta(String nombre, String apellidos) {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }


    public double[] getRutax() {
        return rutax;
    }

    public void setRutax(double[] rutax) {
        this.rutax = rutax;
    }

    public double[] getRutay() {
        return rutay;
    }

    public void setRutay(double[] rutay) {
        this.rutay = rutay;
    }
}
