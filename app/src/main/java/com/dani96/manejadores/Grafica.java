package com.dani96.manejadores;

import java.io.Serializable;
import java.util.ArrayList;

public class Grafica implements Serializable {
    protected String titulo;
    protected ArrayList<Tupla> listaTupla = new ArrayList<>();

    public Grafica(String titulo, ArrayList<Tupla> listaTupla) {
        this.titulo = titulo;
        this.listaTupla = listaTupla;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Tupla> getListaTupla() {
        return listaTupla;
    }

    public void setListaTupla(ArrayList<Tupla> listaTupla) {
        this.listaTupla = listaTupla;
    }
}
