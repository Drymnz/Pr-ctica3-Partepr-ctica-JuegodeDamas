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
        this.matrizGuia = new int[8][8];
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
        boolean buenaDireccion = retrozederFicha();
        boolean mismaDistaciaCuadrada = distanciaEntreFilas() == distanciaEntreColumnas();
        boolean movimientoSimple = distanciaEntreColumnas() == 1;
        if (buenaDireccion && mismaDistaciaCuadrada && movimientoSimple) {
            valido = siSonIgualColor() && espacioDisponible(posicionFinalX, posicionFinalY);
        } else if (buenaDireccion && !movimientoSimple) {
            int x = (numeroJugador == 0) ? posicionInicialX + 1 : posicionInicialX - 1;
            int aumentar = posicionInicialY + 1;
            int disminuir = posicionInicialY - 1;
            elimiar(x, aumentar, disminuir);
        }
        ficha.setCoronado(coronarFicha());
    }

    // eliminar
    private void elimiar(int x, int aumentar, int disminuir) {
        if (aumentar >-1 && disminuir > -1 && aumentar < tabla.getAncho() && disminuir < tabla.getAncho()) {
            System.out.println("x>>"+x+"Y>>"+aumentar);
            System.out.println("x>>"+x+"Y>>"+disminuir);
            a();
            if (!espacioDisponible(x, aumentar)) {
                posicionXEliminar = x;
                posicionYEliminar = aumentar;
                tabla.getTabla()[x][aumentar].setFicha(null);
                valido = true;
                puntoAFavor++; 
            } else if (!espacioDisponible(x, disminuir)){
                posicionXEliminar = x;
                posicionYEliminar = disminuir;
                tabla.getTabla()[x][disminuir].setFicha(null);
                valido = true;
                puntoAFavor++; 
            }
        }
    }
    private void a (){
        for (int i = 0; i < tabla.getAlto(); i++) {
            for (int j = 0; j < tabla.getAncho(); j++) {
                if (tabla.getTabla()[i][j].getFicha()!=null) {
                    System.out.print("["+tabla.getTabla()[i][j].getFicha().getId()+"]");
                }else {
                    System.out.print("[X"+i+"Y"+j+"]");
                }
            }
            System.out.println(" ");
        }
    }

    // fin eliminar

    // espacio disponible
    private boolean espacioDisponible(int x, int y) {
        return !tabla.getTabla()[x][y].getTengoFicha();
    }

    // que mida la distancia entre filas para que no realize saltos
    private boolean retrozederFicha() {
        boolean retrozer = (numeroJugador == 0)
                ? (matrizGuia[posicionInicialX][posicionInicialY] < matrizGuia[posicionFinalX][posicionFinalY])
                : (matrizGuia[posicionInicialX][posicionInicialY] > matrizGuia[posicionFinalX][posicionFinalY]);
        return (retrozer) || ficha.getCoronado();
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
    private boolean siSonIgualColor() {
        return ((posicionInicialX % 2) != (posicionFinalX % 2)) && ((posicionInicialY % 2) != (posicionFinalY % 2));
    }

    // get
    public int getPuntoAFavor() {
        return puntoAFavor;
    }
    public int getPosicionXEliminar(){
        return posicionXEliminar;
    }
    public int getPosicionYEliminar(){
        return posicionYEliminar;
    }

    public boolean getValido() {
        return valido;
    }

    // fin get
    // corolar ficha
    public boolean coronarFicha() {
        //System.out.println("llego abajo" + (tabla.getAlto() - 1));
        //System.out.println("subio total" + posicionFinalX);
        //System.out.println("posicionFinalY"+posicionFinalY);
        return (numeroJugador == 0) ? (posicionFinalY == (tabla.getAlto() - 1)) : posicionFinalX == 0;
    }
    // fin corolar ficha
}
