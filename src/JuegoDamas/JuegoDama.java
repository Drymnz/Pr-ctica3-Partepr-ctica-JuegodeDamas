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

    // constructor
    public JuegoDama(Persona jugadorUno, Persona jugadorDos, int punteoJugadorUno, int punteoJugadorDos, int rondas,Tabla tabla) {
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.punteoJugadorUno = punteoJugadorUno;
        this.punteoJugadorDos = punteoJugadorDos;
        this.rondas = rondas;
        this.tabla = tabla;
    }

    public JuegoDama(Persona jugadorUno, Persona jugadorDos, Tabla tabla) {
        this(jugadorUno, jugadorDos, 0, 0, 0, tabla);
    }

    public JuegoDama(Persona jugadorUno, Persona jugadorDos) {
        this(jugadorUno, jugadorDos, new Tabla(8, 8));
    }

    // fin constructor
    // inicio del juego
    public void Iniciar() {
        do {
            System.out.println(
                    "****************************************************************** Ronda : " + (rondas + 1));
            System.out.println("Jugador Uno es :" + jugadorUno.getNickName() + " punteo es : " + punteoJugadorUno);
            System.out.println("Jugador Dos es :" + jugadorDos.getNickName() + " punteo es : " + punteoJugadorDos);
            tabla.dibujar();
            String turno = (rondas % 2 == 0) ? (" Turno de :" + jugadorUno.getNickName())
                    : (" Turno de :" + jugadorDos.getNickName());
            System.out.println(turno);
            int idFicha = IngresoDatos.getInt("Ingrese el numero de la ficha");
            this.rondas = (moverFicha(idFicha, (IngresoDatos.getInt("Ingrese el numero de columna")) - 1,
                    (IngresoDatos.getInt("Ingrese el numero de fila")) - 1)) ? (this.rondas + 1) : (this.rondas);
        } while (!finalizo());
        Persona gandor = (punteoJugadorUno > punteoJugadorDos) ? jugadorUno : jugadorDos;
        Persona perdedor = (punteoJugadorUno < punteoJugadorDos) ? jugadorUno : jugadorDos;
        gandor.setVictorias(gandor.getVictorias() + 1);
        gandor.setContadorJuegos(gandor.getContadorJuegos() + 1);
        perdedor.setContadorJuegos(perdedor.getContadorJuegos() + 1);
        System.out.println(IngresoDatos.setTextoColor(1, "Gano el jugador"));
        System.out.println(IngresoDatos.setTextoResaltador(3, gandor.getNickName()));
    }

    private boolean finalizo() {
        return ((punteoJugadorUno == tabla.getAncho()) || (punteoJugadorDos == tabla.getAncho())) ? true : false;
    }

    // fin del juego
    // mover fichas
    private boolean moverFicha(int idFicha, int posicionFinalY, int posicionFinalX) {
        boolean todoBien = false;
        ManejoFicha manejoFicha = new ManejoFicha();
        Ficha mover = manejoFicha.buscarFicha(idFicha, listadoFicha());
        boolean dentroMargenTabla = (((tabla.getAncho() > posicionFinalX) && (posicionFinalX >= 0))
                && ((tabla.getAlto() > posicionFinalY)) && (posicionFinalY >= 0)) ? true : false;
        if ((mover != null) && (dentroMargenTabla)) {
            int posicionInicialX = manejoFicha.posicionFichaInicialX(tabla.getTabla(), mover, tabla.getAncho(),
                    this.tabla.getAncho());
            int posicionInicialY = manejoFicha.posicionFichaInicialY(tabla.getTabla(), mover, tabla.getAncho(),
                    this.tabla.getAlto());
            ReglaDelJuego control = new ReglaDelJuego(tabla, mover, posicionInicialX, posicionInicialY, posicionFinalX,
                    posicionFinalY, (rondas % 2));
            if (control.getValido()) {
                tabla.getTabla()[posicionInicialX][posicionInicialY].setFicha(null);
                tabla.getTabla()[posicionFinalX][posicionFinalY].setFicha(mover);
                sumarPunteo(control.getPuntoAFavor(), control.getPosicionXEliminar(), control.getPosicionYEliminar());
                todoBien = true;
            } else {
                System.out.println(IngresoDatos.setTextoColor(0, "No valido el momieminto"));
                todoBien = false;
            }
        }
        return todoBien;
    }

    // fihas del jugador de turno
    private Ficha[] listadoFicha() {
        return ((rondas % 2 == 0)) ? tabla.getFichasJugadorUno() : tabla.getFichasJugadorDos();
    }

    // fin moveer fichas
    // get
    public Tabla getTabla() {
        return tabla;
    }

    // fin get
    // sumar punto
    private void sumarPunteo(int punteo, int posicionX, int posicionY) {
        Persona modificar = (rondas % 2 == 0) ? jugadorUno : jugadorDos;
        if (rondas % 2 == 0 && punteo != 0) {
            punteoJugadorUno += punteo;
            tabla.getTabla()[posicionX][posicionY].setFicha(null);
            modificar.setPunteo(modificar.getPunteo() + punteo);
        } else if ( punteo != 0) {
            punteoJugadorDos += punteo;
            tabla.getTabla()[posicionX][posicionY].setFicha(null);
            modificar.setPunteo(modificar.getPunteo() + punteo);
        }
    }
    // fin sumar punto
}
