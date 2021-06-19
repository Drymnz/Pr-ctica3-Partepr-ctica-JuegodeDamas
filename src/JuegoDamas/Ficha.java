package src.JuegoDamas;

public class Ficha {
    private String caracter;
    private int id;
    private boolean coronado;
    // constructor
    public Ficha(String caracter, int id, boolean coronado){
        this.caracter = caracter;
        this.id = id;
    }
    public Ficha(int id){
        this("#", id,false);
    }
    //fin constructor
    // get y set
    public int getId(){
        return id;
    }
    public String getCaracter(){
        return caracter;
    }
    public boolean getCoronado(){
        return coronado;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setCaracter(String caracter){
        this.caracter = caracter;
    }
    public void setCoronado(boolean coronado){
        this.coronado = coronado;
    }
    // fin get y set
}
