package src.JuegoDamas;

import src.herramientas.IngresoDatos;
import src.usario.Persona;

public class JuegoDama {
    private Persona jugadorUno;
    private Persona jugadorDos;
    private int punteoJugadorUno;
    private int punteoJugadorDos;
    private int rondas;
    private Tabla tabla;
    private boolean finalizo;

    // constructor
    public JuegoDama(Persona jugadorUno, Persona jugadorDos, int punteoJugadorUno, int punteoJugadorDos, int rondas,
            Tabla tabla, boolean finalizo) {
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.punteoJugadorUno = punteoJugadorUno;
        this.punteoJugadorDos = punteoJugadorDos;
        this.rondas = rondas;
        this.tabla = tabla;
        this.finalizo = finalizo;
        Iniciar();
    }

    public JuegoDama(Persona jugadorUno, Persona jugadorDos, Tabla tabla) {
        this(jugadorUno, jugadorDos, 0, 0, 0, tabla, false);
    }

    public JuegoDama(Persona jugadorUno, Persona jugadorDos) {
        this(jugadorUno, jugadorDos, new Tabla(8, 8));
    }

    // fin constructor
    // inicio del juego
    private void Iniciar() {
        do {
            System.out.println("******************************************************************");
            System.out.println("Jugador Uno es :" + jugadorUno.getNickName());
            System.out.println("Jugador dos es :" + jugadorDos.getNickName());
            tabla.dibujar();
            String turno = (rondas % 2 == 0) ? (" Turno de :" + jugadorUno.getNickName())
                    : (" Turno de :" + jugadorDos.getNickName());
            System.out.println(turno);
            int idFicha = IngresoDatos.getInt("Ingrese el numero de la ficha");
            this.rondas = (moverFicha(idFicha, (IngresoDatos.getInt("Ingrese el numero de columna")) - 1,
                    (IngresoDatos.getInt("Ingrese el numero de fila")) - 1)) ? (this.rondas + 1) : (this.rondas);
        } while (!finalizo);
    }

    // fin del juego
    // mover fichas
    public boolean moverFicha(int idFicha, int posicionFinalX, int posicionFinalY) {
        boolean todoBien = false;
        ManejoFicha manejoFicha = new ManejoFicha();
        Ficha mover = manejoFicha.buscarFicha(idFicha,listadoFicha());
        ReglaDelJuego control = new ReglaDelJuego();
        if (mover != null) {
            int posicionInicialX = manejoFicha.posicionFichaInicialX(tabla.getTabla(), mover,this.tabla.getAncho(),this.tabla.getAlto());
            int posicionInicialY = manejoFicha.posicionFichaInicialY(tabla.getTabla(),mover,this.tabla.getAncho(),this.tabla.getAlto());
            if (finalizo) {
                tabla.getTabla()[posicionInicialX][posicionInicialY].setFicha(null);
                tabla.getTabla()[posicionFinalX][posicionFinalY].setFicha(mover);
            } else {
                todoBien =  false;
            }
            todoBien =  true;
        }
        return todoBien;
    }
    // fihas del jugador de turno
    public Ficha[] listadoFicha() {
        return ((rondas % 2 == 0)) ? tabla.getFichasJugadorUno() : tabla.getFichasJugadorDos();
    }
    // fin moveer fichas
    // get
    public Tabla getTabla() {
        return tabla;
    }
    // fin get
    //sumar punto 
    private void sumarPunteo(int punteo){
        Persona aumentar = (rondas%2 == 0)? jugadorUno: jugadorDos;
        aumentar.setPunteo(aumentar.getPunteo()+punteo);;
    }
    // fin sumar punto 
}
