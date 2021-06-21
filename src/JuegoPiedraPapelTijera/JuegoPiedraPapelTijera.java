package src.JuegoPiedraPapelTijera;

import src.herramientas.IngresoDatos;
import src.usario.Persona;

public class JuegoPiedraPapelTijera {
    private Persona JugadorUno;
    private Persona JugadorDos;
    private int punteoJuegadorUno, punteoJuegadorDos;

    // constructor
    public JuegoPiedraPapelTijera(Persona JugadorUno, Persona JugadorDos, int punteoJuegadorUno, int punteoJuegadorDos) {
        this.JugadorUno = JugadorUno;
        this.JugadorDos = JugadorDos;
        this.punteoJuegadorDos = punteoJuegadorDos;
        this.punteoJuegadorUno = punteoJuegadorUno;
    }

    public JuegoPiedraPapelTijera(Persona JugadorUno, Persona JugadorDos) {
        this(JugadorUno, JugadorDos, 0, 0);
    }

    // fin constructor
    // inicio juego
    public void iniciar() {
        do {
            System.out.println("punteo esta "+JugadorUno.getNickName()+" :"+punteoJuegadorUno+" y del "+JugadorDos.getNickName()+" :"+punteoJuegadorDos);
            int seleccionUno = turno(JugadorUno);
            int seleccionDos = turno(JugadorDos);
            
            if (seleccionUno != seleccionDos) {
                Persona gandor = (ganoUno(seleccionUno, seleccionDos)) ? JugadorUno : JugadorDos;
                System.out.println(IngresoDatos.setTextoColor(1, "Gano el jugador"));
                System.out.println(IngresoDatos.setTextoResaltador(3, gandor.getNickName())); 
                if ((ganoUno(seleccionUno, seleccionDos))) {
                    punteoJuegadorUno ++;
                } else {
                    punteoJuegadorDos ++;
                }
            }
        } while (!fin ());
        Persona gandor = (punteoJuegadorUno > punteoJuegadorDos) ? JugadorUno : JugadorDos;
        System.out.println(IngresoDatos.setTextoColor(1,
                "Fin de la partida <<Ganador>> >>>" + IngresoDatos.setTextoResaltador(3, gandor.getNickName())));
    }
    private boolean fin (){
        return (punteoJuegadorUno == 2 || punteoJuegadorDos == 2);
    }
    private boolean ganoUno(int seleccionUno, int seleccionDos) {
        dibujar(seleccionUno, seleccionDos);
        if (seleccionUno == 0 && seleccionDos == 2) {
            return true;
        }
        if (seleccionUno == 1 && seleccionDos == 0) {
            return true;
        }
        if (seleccionUno == 2 && seleccionDos == 1) {
            return true;
        }
        return false;
    }
    private void dibujar(int seleccionUno, int seleccionDos ){

    }

    private int turno(Persona jugador) {
        int seleccion = -1;
        do {
            seleccion = IngresoDatos.getInt("Turno de " + jugador.getNickName() + ", porfavor  es coja 0(PIEDRA),1(PAPEL),2(TIJERA)");
            if (seleccion == 0 || seleccion == 1 || seleccion == 2) {
                return seleccion;
            }
        } while (true);
    }
    // fin juego
    // get y set
    public Persona getGandor() {
        return (punteoJuegadorUno > punteoJuegadorDos) ? JugadorUno : JugadorDos;
    }
    // fin get y set
}