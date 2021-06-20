package src.JuegoDamas;

public class ReglaDelJuego {
    private int puntoAFavor;
    private Casilla[][] tabla;
    private Ficha ficha;
    private boolean valido;
    private int posicionInicialX;
    private int posicionInicialY;
    private int posicionFinalX;
    private int posicionFinalY;
    private int numeroJugador;

    // constructor
    public ReglaDelJuego(int puntoAFavor, Casilla[][] tabla, Ficha ficha, boolean valido, int posicionInicialX,
            int posicionInicialY, int posicionFinalX, int posicionFinalY, int numeroJugador) {
        this.puntoAFavor = puntoAFavor;
        this.tabla = tabla;
        this.ficha = ficha;
        this.valido = valido;
        this.posicionInicialX = posicionInicialX;
        System.out.println("posicionInicialX >>" + posicionInicialX);
        this.posicionInicialY = posicionInicialY;
        System.out.println("posicionInicialY>>>" + posicionInicialY);
        this.posicionFinalX = posicionFinalX;
        System.out.println("posicionFinalX>>>" + posicionFinalX);
        this.posicionFinalY = posicionFinalY;
        System.out.println("posicionFinalY>>" + posicionFinalY);
        this.numeroJugador = numeroJugador;
        movimiento();
    }

    public ReglaDelJuego(Casilla[][] tabla, Ficha ficha, int posicionInicialX, int posicionInicialY, int posicionFinalX,
            int posicionFinalY, int numeroJugador) {
        this(0, tabla, ficha, false, posicionInicialX, posicionInicialY, posicionFinalX, posicionFinalY, numeroJugador);
    }

    // fin constructor
    // tipo de movimiento
    private void movimiento() {
        // movimiento simple
        System.out.println("distanciaEntreFilas()");
        if ((distanciaEntreFilas()== distanciaEntreColumnas()) && retrozederFicha()) {
            System.out.println("solo una fila");
                valido = siSonIgualColor() && espacioDisponible();
        } else {
            System.out.println("tengo fiahca >>>" + tabla[posicionFinalX][posicionFinalY].getTengoFicha());
                valido = tabla[posicionFinalX][posicionFinalY].getTengoFicha();
        }
    }
    // espacio disponible
    private boolean espacioDisponible(){
        return !tabla[posicionFinalX][posicionFinalY].getTengoFicha();
    }

    // que mida la distancia entre filas para que no realize saltos
    private boolean retrozederFicha(){
        int resultado = (numeroJugador == 0) ? posicionFinalY - posicionInicialY : posicionInicialX - posicionFinalX;
        return (resultado>0) || ficha.getCoronado();
    }
  
    private int distanciaEntreFilas(){
        int resultado = (numeroJugador == 0) ? posicionFinalY - posicionInicialY : posicionInicialX - posicionFinalX;
        return (resultado < 0)? (resultado*-1) : resultado;
    }
    private int distanciaEntreColumnas(){
        int resultado = (numeroJugador == 0) ? posicionFinalX - posicionInicialX : posicionInicialX - posicionFinalX;
        return (resultado < 0)? (resultado*-1) : resultado;
    }
    
   
    // que solo se mueve en un color de todos
    private boolean siSonIgualColor() {
        return ((posicionInicialX % 2) != (posicionFinalX % 2)) && ((posicionInicialY % 2) != (posicionFinalY % 2));
    }

    // get
    public int getPuntoAFavor() {
        return puntoAFavor;
    }

    public boolean getValido() {
        return valido;
    }

    // fin get
}
