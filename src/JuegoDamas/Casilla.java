package src.JuegoDamas;

public class Casilla {
    private Ficha ficha;
    private String color;
    private int ancho;
    private int alto;

    // contructor
    public Casilla(Ficha ficha, String color, int ancho, int alto) {
        this.ficha = ficha;
        this.color = color;
        this.ancho = ancho;
        this.alto = alto;
    }

    public Casilla(String color) {
        this(null, color, 3, 3);
    }
    // fin de constructor
    // dibujar espacio
    public void dibujar(int linea){
        if (alto >= linea) {
             // dibujar ariva y dibujar abajo
            if (linea != (centroAlto())) {
                dibujarLinea();
            }else if (ficha != null){
                // dibujar centro
                for (int i = 0; i < ancho; i++) {
                    System.out.print(ficha.getCaracter());
                }
            } else{
                dibujarLinea();
            }
        }
    }

    private void dibujarLinea() {
        for (int i = 0; i < ancho; i++) {
            if (i == ( ancho / 2) && ficha != null) {
                System.out.print(ficha.getCaracter());
            }else {
                System.out.print(color+" "+"\u001B[0m");
            }
        }
    }

    private int centroAlto() {
        boolean parImpar = (alto % 2) == 0;
        if (parImpar) {
            return alto / 2;
        } else {
            return (alto / 2) + 1;
        }
    }

    

    // fin dibujar espacio
    // tengo ficha en mi casilla
    public boolean getTengoFicha() {
        return ficha != null;
    }

    // get
    public Ficha getFicha() {
        return ficha;
    }

    public String getColor() {
        return color;
    }

    public int getAltura() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    // fin de get
    // set
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAltura(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    // fin set
}
