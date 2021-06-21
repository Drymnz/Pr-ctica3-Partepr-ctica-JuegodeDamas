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
                // dibujar centro de la ficha
                dibujarLineaCentro();
            } else{
                dibujarLinea();
            }
        }
    }
    // para imprimeir *1*, pero si el tamaño de celda es mayor **1* si el id es mayor 100
    private void dibujarLineaCentro(){
        String id = ficha.getId() +"";
        int diferencia = ((ancho-id.length()));
        if (diferencia>0) {
            String total = "";
            for (int i = 0; i < ancho; i++) {
                String sumar = (i==(ancho/2))? (ficha.getId()+""): (ficha.getCoronado())? "@": ficha.getCaracter();
                total += sumar;
            }
            id = total;
        }else {
            id = id.substring(0, ancho-1);
        }
        System.out.print(id);        
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
