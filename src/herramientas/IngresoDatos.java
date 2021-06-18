package src.herramientas;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IngresoDatos {
    public static String getTexto(String mensaje) {
        System.out.print("\n"+mensaje);
        return (new Scanner(System.in)).nextLine();
    }

    public static int getInt(String mensaje) {
        do {
            String verificar = getTexto(mensaje);
            if (verficarTextoNumero(verificar)) {
                return Integer.parseInt(verificar);
            }
            System.out.print(setTextoColor(0, "\n Ingrese un numero porfavor "));
        } while (true);
    }

    public static boolean verficarTextoNumero(String verificar) {
        Pattern patron = Pattern.compile("[0-9]+");
        Matcher matcher = patron.matcher(verificar);
        return matcher.matches();
    }

    public static String setTextoColor(int color, String texto) {
        switch (color) {
            case 0:
                return "\033[31m" + texto + "\u001B[0m";// color rojo
            case 1:
                return "\033[32m" + texto + "\u001B[0m";// color verde
            case 2:
                return "\033[34m" + texto + "\u001B[0m";// color azul 
            case 3:
                return "\033[37m" + texto + "\u001B[0m";// color blanco  
            case 4:
                return "\033[30m" + texto + "\u001B[0m";// color negro 
            default:
                return texto;
        }
    }
    public static String setTextoResaltador(int color, String texto) {
        switch (color) {
            case 0:
                return "\u001B[40m" + texto + "\u001B[0m";// color negro
            case 1:
                return "\u001B[47m" + texto + "\u001B[0m";// color blando
            case 2:
                return "\u001B[42m" + texto + "\u001B[0m";// color verde 
            case 3:
                return "\u001B[46m" + texto + "\u001B[0m";// color celeste  
            case 4:
                return "\u001B[45m" + texto + "\u001B[0m";// color morado 
            default:
                return texto;
        }
    }
}
