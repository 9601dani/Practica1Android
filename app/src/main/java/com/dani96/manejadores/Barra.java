package com.dani96.manejadores;

import java.util.ArrayList;

public class Barra extends Grafica{

    private ArrayList<String> ejeX = new ArrayList<>();
    private ArrayList<Double> ejeY = new ArrayList<>();

    public Barra(String titulo, ArrayList<Tupla> ListaTupla, ArrayList<String> ejeX, ArrayList<Double> ejeY) {
        super(titulo, ListaTupla);
        this.ejeX.addAll(ejeX);
        this.ejeY.addAll(ejeY);
    }

    public ArrayList<String> getEjeX() {
        return ejeX;
    }

    public void setEjeX(ArrayList<String> ejeX) {
        this.ejeX = ejeX;
    }

    public ArrayList<Double> getEjeY() {
        return ejeY;
    }

    public void setEjeY(ArrayList<Double> ejeY) {
        this.ejeY = ejeY;
    }

    @Override
    public String toString() {
        return "Barras{" +
                "ejeX=" + ejeX +
                ", ejeY=" + ejeY +
                ", titulo='" + titulo + '\'' +
                ", ArrayListaTupla=" + listaTupla +
                '}';
    }
}