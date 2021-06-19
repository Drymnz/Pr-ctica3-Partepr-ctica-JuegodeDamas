package src.JuegoDamas;

public class Tabla {
    private final int ancho;
    private final int alto;
    private Ficha[] fichasJugadorUno;
    private Ficha[] fichasJugadorDos;
    private Casilla[][] tabla;
    private String colorUno;
    private String colorDos;

    // constructor
    public Tabla(int ancho, int alto,String colorUno, String colorDos) {
        this.ancho = ancho;
        this.alto = alto;
        this.colorUno = colorUno;
        this.colorDos = colorDos;
        fichasJugadorUno = new Ficha[ancho];
        fichasJugadorDos = new Ficha[ancho];
        tabla = new Casilla[ancho][alto];
        crearFichas();
        crearCasilla();
    }
    public Tabla(int ancho, int alto) {
        this(ancho, alto, "\u001B[40m", "\u001B[47m");
    }
    
    private void crearFichas() {
        for (int i = 0; i < ancho; i++) {
            fichasJugadorUno[i] = new Ficha(i);
            fichasJugadorDos[i] = new Ficha(i);
        }
    }

    private void crearCasilla(){
        String colorOne = "";
        String colorTwo = "";
        for (int i = 0; i < fichasJugadorDos.length; i++) {
            colorOne = (((i%2)==0)  )? colorUno : colorDos;
            colorTwo = (((i%2)==0)  )? colorDos : colorUno;
            for (int j = 0; j < fichasJugadorDos.length; j++) {
                String color = (((j%2)==0)  )? colorOne : colorTwo;
                tabla[i][j] = new Casilla(color);
            }
        }
    }

    // fin contructor
    // dibujar tabla
    public void dibujar( int altoEspacioCasilla) {
        for (int i = 0; i < alto; i++) {
            for (int j = 1; j < (altoEspacioCasilla+1); j++) {
                for (int j2 = 0; j2 < ancho; j2++) {
                    tabla[i][j2].dibujar(j);
                }
                System.out.println("");
            }
        }
    }
    public void dibujar(){
        llenarTablaFichas(0,fichasJugadorUno);
        llenarTablaFichas(alto-2,fichasJugadorDos);
        System.out.println("012345678901234567890123456789");
        this.dibujar(3);
    }
    private void llenarTablaFichas(int filaUno,Ficha[] ordenar){
        for (int i = filaUno; i < filaUno+2; i++) {
            int contador = (i==0)? 0: ((ancho / 2));
            for (int j = (contador == 0)? 0: 1; j < ancho; j+=2) {
                tabla[i][j].setFicha(ordenar[contador]);
                contador ++;
            } 
        }
    }
   
    // fin dibujar tabla
}
