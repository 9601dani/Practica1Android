package com.dani96.manejadores;

public enum TipoError {
    LEXICO("Lexico"),
    SINTACTICO("Sintáctico");

    private String type;

    TipoError(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public static TipoError obtenerTipo(String value){
        if(value.equals(LEXICO.getType())){
            return LEXICO;
        } else if(value.equals(SINTACTICO.getType())){
            return SINTACTICO;
        }

        return null;
    }
}
