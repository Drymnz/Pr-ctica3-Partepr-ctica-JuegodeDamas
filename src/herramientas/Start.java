package src.herramientas;
import src.mesa.*;
public class Start {
    public static void main(String[] args) {
        Menu ejecutar = new Menu();
    }
    public static void colores(){
        String[] colores  = {"\u001B[30m","\u001B[31m","\u001B[32m","\u001B[33m","\u001B[34m","\u001B[35m", "\u001B[36m","\u001B[37m"};
        String[] reslatar = {"\u001B[40m","\u001B[41m","\u001B[42m","\u001B[43m","\u001B[44m","\u001B[45m","\u001B[46m","\u001B[47m"};
        String reset = "\u001B[0m";
        for (int i = 0; i < colores.length; i++) {
            System.out.println(colores[i]+"puevas de colores"+reset);
        }
        System.out.println("!");
        for (int i = 0; i < reslatar.length; i++) {
            System.out.println(reslatar[i]+"puevas de colores"+reset);
        }
    }
}