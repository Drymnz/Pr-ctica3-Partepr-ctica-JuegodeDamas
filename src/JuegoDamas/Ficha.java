package src.JuegoDamas;

public class Ficha {
    private String caracter;
    private int id;
    // constructor
    public Ficha(String caracter, int id){
        this.caracter = caracter;
        this.id = id;
    }
    public Ficha(int id){
        this("#", id);
    }
    //fin constructor
    // get y set
    public int getId(){
        return id;
    }
    public String getCaracter(){
        return caracter;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setCaracter(String caracter){
        this.caracter = caracter;
    }
    // fin get y set
}
