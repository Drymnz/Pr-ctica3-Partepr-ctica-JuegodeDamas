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
            moverFicha(idFicha, (IngresoDatos.getInt("Ingrese el numero de columna"))-1, (IngresoDatos.getInt("Ingrese el numero de fila"))-1);
        } while (!finalizo);
    }

    // fin del juego
    // mover fichas
    public void moverFicha(int idFicha, int posicionFinalX, int posicionFinalY) {
        Ficha mover = buscarFicha(idFicha);
        do {
            if ((mover==null)) {
                idFicha = IngresoDatos.getInt("Ingrese el numero de la ficha");
            }else {
                tabla.getTabla()[posicionFichaInicialX(tabla.getTabla(),mover)][posicionFichaInicialY(tabla.getTabla(),mover)].setFicha(null);
                tabla.getTabla()[posicionFinalX][posicionFinalY].setFicha(mover);
            }
        } while (!(mover!=null));
    }
        // buscador ficha

        private int posicionFichaInicialX (Casilla[][] listado, Ficha buscar) {
            for (int i = 0; i < this.tabla.getAlto(); i++) {
                for (int j = 0; j < this.tabla.getAncho(); j++) {
                    if (listado[i][j].getFicha() == buscar) {
                        return i;
                    }
                }
            }
            return -1;
        }
        private int posicionFichaInicialY (Casilla[][] listado, Ficha buscar) {
            for (int i = 0; i < this.tabla.getAlto(); i++) {
                for (int j = 0; j < this.tabla.getAncho(); j++) {
                    if (listado[i][j].getFicha() == buscar) {
                        return j;
                    }
                }
            }
            return -1;
        }
       

        private Ficha buscarFicha(int id) {
            Ficha[] listado = listadoFicha();
            for (int i = 0; i < listado.length; i++) {
                if (listado[i].getId() == id) {
                    return listado[i];
                }
            }
            return null;
        }
    
        private Ficha[] listadoFicha() {
            return ((rondas % 2 == 0)) ? tabla.getFichasJugadorUno() : tabla.getFichasJugadorDos();
        }
        // fin buscador ficha
    // fin moveer fichas
    // reglas del juego

    // fin reglas del juego
    // get
    public Tabla getTabla() {
        return tabla;
    }
    // fin get
}
