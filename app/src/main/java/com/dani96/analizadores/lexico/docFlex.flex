  
/*primer seccion: codigo de usuario*/
/* PARA COMPILAR java -jar jflex-full-1.8.2.jar /home/daniel/IntelliJIDEAProjects/MyApplication1/app/src/main/java/com/example/analizadores/lexico/docFlex.flex */
package com.example.analizadores.lexico;
import java_cup.runtime.*;
import com.dani96.analizadores.sintactico.sym;

%%

/*segunda seccion: configuracion*/
%class DocFLex
%unicode
%line
%column
%cup
%public
%eofclose false

%state COMENTARIO_BLOQUE
%state CADENA_BLOQUE

ESPACIOS = [\r|\n|\r\n] | [ \t\f]
LETRA = [a-zA-Z]
NUMERO = [0-9]
SIGNO_MENOS = "-"
SIGNO_MAS = "+"
SIGNO_POR = "*"
SIGNO_DIVISION = "/"
COMA = ","
PUNTO_COMA = ";"
DOS_PUNTOS = ":"
INICIO_COMENTARIO = "#"
PARENTESIS_ABIERTO = "("
PARENTESIS_CERRADO = ")"
CORCHETE_ABIERTO = "["
CORCHETE_CERRADO = "]"
LLAVE_ABIERTA = "{"
LLAVE_CERRADA = "}"
DEF = (D|d)"ef"
TITULO = "titulo"
BARRAS = "Barras"
PIE = "Pie"
EJEX = "ejex"
EJEY = "ejey"
ETIQUETAS = "etiquetas"
VALORES = "valores"
UNIR = "unir"
TIPO = "tipo"  
TOTAL = "total"
EXTRA = "extra"
EJECUTAR = "ejecutar"
PALABRA = ({LETRA})+ 
CADENA= ({PALABRA}|{NUMERO})* 
COMILLA = \"
SALTO_LINEA= \n
CANTIDAD = "Cantidad"
PORCENTAJE = "Porcentaje"
ENTERO = 0|[1-9][0-9]*
DECIMAL = ({ENTERO})"."[0-9]+
%{
    String lexema = "";

    private void addLexema(String yytext){
        lexema+=yytext;
    }
    private void error(String message) {
        System.out.println("Error en linea: "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
      }
%}

 
%eof{
%eof}

%%


/*tercer seccion: reglas lexicas*/

<YYINITIAL>{
    {ESPACIOS}                        {;}
    {INICIO_COMENTARIO}             {yybegin(COMENTARIO_BLOQUE);}
    {COMILLA}                       {yybegin(CADENA_BLOQUE);}
    {COMA}                          {return new Symbol(sym.COMA,yyline +1, yycolumn +1);}
    {DEF}                           {return new Symbol(sym.DEF,yyline +1, yycolumn +1);}
    {BARRAS}                        {return new Symbol(sym.BARRAS,yyline +1, yycolumn +1);}
    {PIE}                           {return new Symbol(sym.PIE,yyline +1, yycolumn +1);}
    {TITULO}                        {return new Symbol(sym.TITULO,yyline +1, yycolumn +1);}
    {EJEX}                          {return new Symbol(sym.EJEX,yyline +1, yycolumn +1);}
    {EJEY}                          {return new Symbol(sym.EJEY,yyline +1, yycolumn +1);}
    {ETIQUETAS}                     {return new Symbol(sym.ETIQUETAS,yyline +1, yycolumn +1);}
    {VALORES}                       {return new Symbol(sym.VALORES,yyline +1, yycolumn +1);}
    {UNIR}                          {return new Symbol(sym.UNIR,yyline +1, yycolumn +1);}
    {TIPO}                          {return new Symbol(sym.TIPO,yyline +1, yycolumn +1);}
    {CANTIDAD}                      {return new Symbol(sym.CANTIDAD,yyline +1, yycolumn +1);}
    {PORCENTAJE}                    {return new Symbol(sym.PORCENTAJE,yyline +1, yycolumn +1);}
    {TOTAL}                         {return new Symbol(sym.TOTAL,yyline +1, yycolumn +1);}
    {EXTRA}                         {return new Symbol(sym.EXTRA,yyline +1, yycolumn +1);}
    {EJECUTAR}                      {return new Symbol(sym.EJECUTAR,yyline +1, yycolumn +1);}
    {ENTERO}                        {return new Symbol(sym.ENTERO,yyline +1, yycolumn +1, yytext());}
    {DECIMAL}                       {return new Symbol(sym.DECIMAL,yyline +1, yycolumn +1, yytext());}
    {SIGNO_MAS}                          {return new Symbol(sym.SIGNO_MAS,yyline +1, yycolumn +1);}
    {SIGNO_MENOS}                         {return new Symbol(sym.SIGNO_MENOS,yyline +1, yycolumn +1);}
    {SIGNO_POR}                {return new Symbol(sym.SIGNO_POR,yyline +1, yycolumn +1);}
    {SIGNO_DIVISION}                      {return new Symbol(sym.SIGNO_DIVISION,yyline +1, yycolumn +1);}
    {DOS_PUNTOS}                    {return new Symbol(sym.DOS_PUNTOS,yyline +1, yycolumn +1);}
    {PUNTO_COMA}                    {return new Symbol(sym.PUNTO_COMA,yyline +1, yycolumn +1);}
    {PARENTESIS_ABIERTO}                  {return new Symbol(sym.PARENTESIS_ABIERTO,yyline +1, yycolumn +1);}
    {PARENTESIS_CERRADO}                  {return new Symbol(sym.PARENTESIS_CERRADO,yyline +1, yycolumn +1);}
    {CORCHETE_ABIERTO}                    {return new Symbol(sym.CORCHETE_ABIERTO,yyline +1, yycolumn +1);}
    {CORCHETE_CERRADO}                    {return new Symbol(sym.CORCHETE_CERRADO,yyline +1, yycolumn +1);}
    {LLAVE_ABIERTA}                       {return new Symbol(sym.LLAVE_ABIERTA,yyline +1, yycolumn +1);}
    {LLAVE_CERRADA}                       {return new Symbol(sym.LLAVE_CERRADA,yyline +1, yycolumn +1);}
}

<CADENA_BLOQUE>{
    {COMILLA}                       {lexema="";yybegin(YYINITIAL); return new Symbol(sym.CADENA,yyline+1,yycolumn+1,lexema);}
    [^]                             {addLexema(yytext());}
}

<COMENTARIO_BLOQUE>{
    {SALTO_LINEA}                   {yybegin(YYINITIAL);}
    [^]                             {;}
}

[^]                                 {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return new Symbol(sym.EOF);}