package src.JuegoDamas;

public class ReglaDelJuego {
    private int puntoAFavor, numeroJugador;
    private Tabla tabla;
    private Ficha ficha;
    private boolean valido;
    private int posicionInicialX, posicionInicialY;
    private int posicionFinalX, posicionFinalY;
    private int[][] matrizGuia;
    private int posicionXEliminar, posicionYEliminar;

    // constructor
    public ReglaDelJuego(int puntoAFavor, Tabla tabla, Ficha ficha, boolean valido, int posicionInicialX,
            int posicionInicialY, int posicionFinalX, int posicionFinalY, int numeroJugador, int[][] matrizGuia) {
        this.puntoAFavor = puntoAFavor;
        this.tabla = tabla;
        this.ficha = ficha;
        this.valido = valido;
        this.posicionInicialX = posicionInicialX;
        this.posicionInicialY = posicionInicialY;
        this.posicionFinalX = posicionFinalX;
        this.posicionFinalY = posicionFinalY;
        this.numeroJugador = numeroJugador;
        this.matrizGuia = matrizGuia;
        matrizGuia();
        movimiento();
    }

    public ReglaDelJuego(Tabla tabla, Ficha ficha, int posicionInicialX, int posicionInicialY, int posicionFinalX,
            int posicionFinalY, int numeroJugador) {
        this(0, tabla, ficha, false, posicionInicialX, posicionInicialY, posicionFinalX, posicionFinalY, numeroJugador,
                null);
    }

    // fin constructor
    // matriz guia
    private void matrizGuia() {
        this.matrizGuia = new int[tabla.getAlto()][tabla.getAncho()];
        int contador = 1;
        for (int i = 0; i < tabla.getAlto(); i++) {
            for (int j = 0; j < tabla.getAncho(); j++) {
                matrizGuia[i][j] = contador;
                contador++;
            }
        }
    }

    // fin matriz guia
    // tipo de movimiento
    private void movimiento() {
        // movimiento simple
        int distanciaEntreFilas = distanciaEntreFilas();
        int distanciaEntreColumnas = distanciaEntreColumnas();
        if ((espacioDisponible(posicionFinalX, posicionFinalY)) && (distanciaEntreFilas == distanciaEntreColumnas)
                && (retrozederFicha() || ficha.getCoronado()) && (siSonIgualColor(distanciaEntreColumnas))) {
            if (distanciaEntreColumnas > 2) {
                valido = false;
            } else if (distanciaEntreColumnas == 1) {
                valido = true;
            } else if ((distanciaEntreColumnas == 2)) {
                int x = (ficha.getCoronado()) ? ((numeroJugador != 0) ? posicionInicialX + 1 : posicionInicialX - 1)
                        : (numeroJugador == 0) ? posicionInicialX + 1 : posicionInicialX - 1;
                int aumentar = posicionInicialY + 1;
                int disminuir = posicionInicialY - 1;
                elimiar(x, aumentar, disminuir);
            }

        }
        ficha.setCoronado(coronarFicha());
    }

    // eliminar
    private void elimiar(int x, int aumentar, int disminuir) {
        if (aumentar > -1 && disminuir > -1 && aumentar < tabla.getAncho() && disminuir < tabla.getAncho()) {
            int direcicion = (numeroJugador == 0) ? posicionFinalY - posicionInicialY
                    : posicionInicialY - posicionFinalY;
            if (direcicion != 0 && !espacioDisponible(x, disminuir)) {
                if (!(new ManejoFicha()).buscarAliado( ((numeroJugador == 0) ? tabla.getFichasJugadorUno() : tabla.getFichasJugadorDos()) , tabla.getTabla()[x][disminuir].getFicha() )) {
                    posicionXEliminar = x;
                    posicionYEliminar = disminuir;
                    tabla.getTabla()[x][disminuir].setFicha(null);
                    valido = true;
                    puntoAFavor++;
                }
            } else if (direcicion != 0 && !espacioDisponible(x, aumentar)) {
                if (!(new ManejoFicha()).buscarAliado( ((numeroJugador == 0) ? tabla.getFichasJugadorUno() : tabla.getFichasJugadorDos()) , tabla.getTabla()[x][disminuir].getFicha() )) {
                    posicionXEliminar = x;
                    posicionYEliminar = aumentar;
                    tabla.getTabla()[x][aumentar].setFicha(null);
                    valido = true;
                    puntoAFavor++;
                }

            }
        }
    }

    // fin eliminar

    // espacio disponible
    private boolean espacioDisponible(int x, int y) {
        return !tabla.getTabla()[x][y].getTengoFicha();
    }

    // que mida la distancia entre filas para que no realize saltos
    private boolean retrozederFicha() {
        return (numeroJugador == 0)
                ? (matrizGuia[posicionInicialX][posicionInicialY] < matrizGuia[posicionFinalX][posicionFinalY])
                : (matrizGuia[posicionInicialX][posicionInicialY] > matrizGuia[posicionFinalX][posicionFinalY]);
    }

    private int distanciaEntreFilas() {
        int resultado = (numeroJugador == 0) ? posicionFinalY - posicionInicialY : posicionInicialX - posicionFinalX;
        return (resultado < 0) ? (resultado * -1) : resultado;
    }

    private int distanciaEntreColumnas() {
        int resultado = (numeroJugador == 0) ? posicionFinalX - posicionInicialX : posicionInicialX - posicionFinalX;
        return (resultado < 0) ? (resultado * -1) : resultado;
    }

    // que solo se mueve en un color de todos
    private boolean siSonIgualColor(int verificar) {
        boolean parImpar = (verificar % 2 == 0) ? true : false;
        if (parImpar) {
            return (posicionInicialX % 2) == (posicionFinalX % 2) && (posicionInicialY % 2) == (posicionFinalY % 2);
        } else {
            return ((posicionInicialX % 2) != (posicionFinalX % 2)) && ((posicionInicialY % 2) != (posicionFinalY % 2));
        }
    }

    // get
    public int getPuntoAFavor() {
        return puntoAFavor;
    }

    public int getPosicionXEliminar() {
        return posicionXEliminar;
    }

    public int getPosicionYEliminar() {
        return posicionYEliminar;
    }

    public boolean getValido() {
        return valido;
    }

    // fin get
    // corolar ficha
    public boolean coronarFicha() {
        return (ficha.getCoronado()) ? true
                : (numeroJugador == 0) ? (posicionFinalX == (tabla.getAlto() - 1)) : posicionFinalX == 0;
    }
    // fin corolar ficha
}
