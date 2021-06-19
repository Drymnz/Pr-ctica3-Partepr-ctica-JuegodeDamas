package src.JuegoDamas;

public class ReglaDelJuego {
    private int puntoAFavor;
    // constructor
    public ReglaDelJuego(int puntoAFavor){
        this.puntoAFavor = puntoAFavor;
    }
    public ReglaDelJuego(){
        this(0);
    }
    // fin constructor
    // si la casilla a donde mover es no es del mismo color que la que la ficha
    public boolean reglaUno(){
        return true;
    }
    // get
    public int getPuntoAFavor(){
        return puntoAFavor;
    }
    //fin get
}
