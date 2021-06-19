package src.JuegoDamas;

public class ReglaDelJuego {
    private int puntoAFavor;
    private Tabla tabla;
    private Ficha ficha;
    private boolean valido;
    private int posicionInicialX;
    private int posicionInicialY;
    private int posicionFinalX;
    private int posicionFinalY;
    private int numeroJugador;
    private final int[][] matrizGuia;

    // constructor
    public ReglaDelJuego(int puntoAFavor, Tabla tabla, Ficha ficha, boolean valido, int posicionInicialX,
            int posicionInicialY, int posicionFinalX, int posicionFinalY, int numeroJugador) {
        this.puntoAFavor = puntoAFavor;
        this.tabla = tabla;
        this.ficha = ficha;
        this.valido = valido;
        this.posicionInicialX = posicionInicialX;
        this.posicionInicialY = posicionInicialY;
        this.posicionFinalX = posicionFinalX;
        this.posicionFinalY = posicionFinalY;
        this.numeroJugador = numeroJugador;
        this.matrizGuia = new int[tabla.getAncho()][tabla.getAlto()];
        matrizGuia();
    }

    public ReglaDelJuego(Tabla tabla, Ficha ficha, int posicionInicialX, int posicionInicialY, int posicionFinalX,
            int posicionFinalY, int numeroJugador) {
        this(0, tabla, ficha, false, posicionInicialX, posicionInicialY, posicionFinalX, posicionFinalY, numeroJugador);
    }

    // fin constructor
    // matriz guia para el movimiento
    public void matrizGuia() {
        int contador = 1;
        for (int x = 0; x < tabla.getAncho(); x++) {
            for (int y = 0; y < tabla.getAlto(); y++) {
                matrizGuia[x][y] = contador;
                contador++;
            }
        }
    }

    // fin matriz guia
    // que los de la fichas superior se mueva asi abajo y lo contario
    private boolean direccionMovimiento() {
        return (numeroJugador == 0) ? (valorIniciar() > valorFinal()) : ((valorIniciar() < valorFinal()));
    }

    // valor de matriz
    private int valorIniciar() {
        return matrizGuia[posicionInicialX][posicionInicialY];
    }

    private int valorFinal() {
        return matrizGuia[posicionFinalX][posicionFinalY];
    }

    // regla de color y posicion de final sin ficha
    // regla de que solo del mismo color puede mover la ficha
    private boolean mismoColor() {
        return tabla.getTabla()[posicionFinalX][posicionFinalY]
                .getColor() == tabla.getTabla()[posicionInicialX][posicionInicialY].getColor();
    }

    // regla que la posicion final no debe tener ficha
    private boolean posicionFinalNoHayFicha() {
        return !(tabla.getTabla()[posicionFinalX][posicionFinalY].getTengoFicha());
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
