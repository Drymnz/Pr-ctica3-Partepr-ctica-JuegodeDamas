package src.JuegoDamas;

public class Tabla {
    private final int ancho;
    private final int alto;
    private int espaciosBlanco = 0;
    private Ficha[] fichasJugadorUno;
    private Ficha[] fichasJugadorDos;
    private Casilla[][] tabla;
    private String colorUno;
    private String colorDos;

    // constructor
    public Tabla(int ancho, int alto,int espaciosBlanco, String colorUno, String colorDos) {
        this.ancho = ancho;
        this.alto = alto;
        this.espaciosBlanco = espaciosBlanco;
        this.colorUno = colorUno;
        this.colorDos = colorDos;
        fichasJugadorUno = new Ficha[ancho];
        fichasJugadorDos = new Ficha[ancho];
        tabla = new Casilla[ancho][alto];
        crearFichas();
        crearCasilla();
        // coloca fichas
        llenarTablaFichas(0, fichasJugadorUno);
        llenarTablaFichas(alto - 2, fichasJugadorDos);
    }

    public Tabla(int ancho, int alto) {
        this(ancho, alto,0,"\u001B[40m", "\u001B[47m");
    }

    // fin contructor
    // crear fichas y casillas, y colocarlas en sus posicion inicial
    private void crearFichas() {
        for (int i = 0; i < ancho; i++) {
            fichasJugadorUno[i] = new Ficha((i+1));
            fichasJugadorDos[i] = new Ficha((i+1));
        }
    }
    //aqui crea las casiilas y le su color clasico
    private void crearCasilla() {
        String colorOne = "";
        String colorTwo = "";
        for (int i = 0; i < alto; i++) {
            colorOne = (((i % 2) == 0)) ? colorUno : colorDos;
            colorTwo = (((i % 2) == 0)) ? colorDos : colorUno;
            for (int j = 0; j < ancho; j++) {
                String color = (((j % 2) == 0)) ? colorOne : colorTwo;
                tabla[i][j] = new Casilla(color);
            }
        }
    }

    private void llenarTablaFichas(int filaUno, Ficha[] ordenar) {
        for (int i = filaUno; i < filaUno + 2; i++) {
            int contador = (i == filaUno) ? 0 : ((ancho / 2));
            for (int j = (contador == 0) ? 0 : 1; j < ancho; j += 2) {
                tabla[i][j].setFicha(ordenar[contador]);
                contador++;
            }
        }
    }

    // fin crear fichas y casillas, y colocarlas en sus posicion inicial
    // dibujar tabla

    public void dibujar(int filas) {
        guiasTablaSuperior();
        for (int i = 0; i < filas; i++) {
            for (int j = 1; j < (tabla[0][0].getAltura() + 1); j++) {
                espacios();
                guiaTablaLateral((j-1),(i+1),false);
                for (int j2 = 0; j2 < ancho; j2++) {
                    tabla[i][j2].dibujar(j);
                }
                guiaTablaLateral((j-1),(i+1),true);
            }
        }
        guiasTablaSuperior();
    }

    public void dibujar() {
        this.dibujar(alto);
    }

    private void espacios(){
        for (int i = 0; i < espaciosBlanco; i++) {
            System.out.print(" ");
        }
    }

    private void guiaTablaLateral(int fila,int contador,boolean saltoLinea) {
        if (fila == (tabla[0][0].getAltura() / 2)) {
            System.out.print((colorUno+contador+ "\u001B[0m"));
        } else {
            System.out.print(colorDos+"*"+ "\u001B[0m");
        }
        String imprimir = (saltoLinea)? ("\n") : "";
        System.out.print(imprimir);
    }

    private void guiasTablaSuperior() {
        espacios();
        System.out.print(colorDos+"*"+ "\u001B[0m");
        for (int j = 0; j < ancho; j++) {
            for (int i = 0; i < tabla[0][0].getAncho(); i++) {
                if (i == (tabla[0][0].getAncho() / 2)) {
                    System.out.print(colorUno+(j + 1)+ "\u001B[0m");
                } else {
                    System.out.print(colorDos+"*"+ "\u001B[0m");
                }
            }
        }
        System.out.print(colorDos+"*"+ "\u001B[0m \n");
    }
    // fin dibujar tabla
}
