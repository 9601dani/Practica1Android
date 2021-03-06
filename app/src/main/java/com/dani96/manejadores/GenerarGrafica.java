package com.dani96.manejadores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class GenerarGrafica implements Serializable {

    private String titulo;
    private ArrayList<String> ejeX;
    private ArrayList<Double> ejeY;
    private ArrayList<String> etiqueta;
    private ArrayList<Double> valor;
    private ArrayList<Tupla> tuplas;
    private ArrayList<Grafica> graficas;
    private Tipo tipo;
    private Double total;
    private String extra;

    public GenerarGrafica() {

        titulo = null;
        graficas = new ArrayList<>();
        ejeX = new ArrayList<>();
        ejeY = new ArrayList<>();
        etiqueta = new ArrayList<>();
        valor = new ArrayList<>();
        tuplas = new ArrayList<>();
        tipo = null;
        total = null;
        extra = null;

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEjeX(ArrayList<String> lista) {
        this.ejeX.addAll(lista);
    }

    public void setEtiqueta(ArrayList<String> etiqueta) {
        this.etiqueta.addAll(etiqueta);
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo(){
        return this.tipo;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void agregarEjeY(Double expd){
        ejeY.add(expd);
    }

    public void agregarValor(Double expd){
        valor.add(expd);
    }

    public void agregarTupla(Integer e1, Integer e2){
        System.out.println("e1 + e2 = " + e1 + e2);
        tuplas.add(new Tupla(e1, e2));
    }

    public void crearGraficaBarras(){
        Collections.reverse(this.ejeX);
        Collections.reverse(this.ejeY);
        graficas.add(new Barra(this.titulo, this.tuplas, this.ejeX, this.ejeY));

        this.titulo = null;
        this.tuplas.clear();
        this.ejeX.clear();
        this.ejeY.clear();
        System.out.println(graficas.get(graficas.size()-1));
    }

    public void crearGraficaPie(){
        if(this.tipo == Tipo.PORCENTAJE){
            this.total = 360.0;
        }

        Collections.reverse(this.etiqueta);
        Collections.reverse(this.valor);
        graficas.add(new Pie(this.titulo, this.tuplas, this.etiqueta, this.valor, this.tipo, this.total,this.extra));
        this.titulo = null;
        this.tuplas.clear();
        this.etiqueta.clear();
        this.valor.clear();
        this.tipo = null;
        this.total = null;
        this.extra = null;
        System.out.println(graficas.get(graficas.size()-1));
    }

    public void filtrarGraficas(ArrayList<String> ejecutarGraficas){
        ArrayList<Grafica> graficaList = new ArrayList<>();
        for(String eGrafica: ejecutarGraficas){
            for(Grafica grafica: graficas){
                if(grafica.titulo.equals(eGrafica)){
                    graficaList.add(grafica);
                    break;
                }
            }
        }

        graficas = graficaList;
    }

    public ArrayList<Grafica> getGraficas() {
        return graficas;
    }

}
