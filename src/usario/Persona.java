package src.usario;

public class Persona {
    private String nombre;
    private String nickName;
    private int punteo;
    private int victorias;
    private int contadorJuegos;
    // constructores
    public Persona(String nombre,String nickName, int punteo, int victorias, int contadorJuegos){
        this.nombre = nombre;
        this.nickName= nickName;
        this.punteo = punteo;
        this.victorias = victorias;
        this.contadorJuegos = contadorJuegos;
    }
    public Persona(String nombre,String nickName){
        this(nombre, nickName, 0, 0, 0);
    }
    public Persona(){
        this("Benjamin de Jesus Perez Aguilar", "Drymnz");
    }
    // fin constructores
    // metdo de mostrar informaicon
    public String informacion(){
        return "Nombre: "+nombre+", NickName: "+nickName+", victorias: "+victorias+", derrotas: "+(contadorJuegos - victorias)+", cantidad de juegos: " +contadorJuegos;
    }
    // metodo de mostrar todo los colores
    
    // get y set
    public String getNombre(){
        return nombre;
    }
    public String getNickName(){
        return nickName;
    }
    public int getPunteo(){
        return punteo;
    }
    public int getVictorias(){
        return victorias;
    }
    public int getContadorJuegos(){
        return contadorJuegos;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    public void setPunteo(int punteo){
        this.punteo =  punteo;
    }
    public void setVictorias(int victorias){
        this.victorias = victorias;
    }
    public void setContadorJuegos(int contadorJuegos){
        this.contadorJuegos =  contadorJuegos;
    }
    // fin get y set

}
