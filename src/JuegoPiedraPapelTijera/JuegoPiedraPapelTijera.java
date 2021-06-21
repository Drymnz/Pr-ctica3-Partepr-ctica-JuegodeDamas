package src.JuegoPiedraPapelTijera;

import src.usario.Persona;

public class JuegoPiedraPapelTijera {
    private Persona JugadorUno;
    private Persona JugadorDos;
    private int punteoJuegadorUno, punteoJuegadorDos;
    // constructor 
    public JuegoPiedraPapelTijera(Persona JugadorUno, Persona JugadorDos,  int punteoJuegadorUno,int punteoJuegadorDos){
        this.JugadorUno = JugadorUno; 
        this.JugadorDos = JugadorDos;
        this.punteoJuegadorDos = punteoJuegadorDos;
        this.punteoJuegadorUno = punteoJuegadorUno;        
    }
    public JuegoPiedraPapelTijera(Persona JugadorUno, Persona JugadorDos){
        this(JugadorUno, JugadorDos, 0 , 0);
    }
    // fin constructor
    // inicio juego
    public void iniciar(){
        
    }
    // fin juego
    // get y set
    public Persona getGandor(){
        return (punteoJuegadorUno > punteoJuegadorDos)? JugadorUno : JugadorDos;
    }
    // fin get y set
}