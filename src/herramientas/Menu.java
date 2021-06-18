package src.herramientas;

import src.juegos.JuegoDama;
import src.mesa.Tabla;
import src.usario.ManejoUsurio;
import src.usario.Persona;

public class Menu {
    private ManejoUsurio listado = new ManejoUsurio();
    private JuegoDama damas;

    public Menu() {
        mostrarMenu();
    }

    public void mostrarMenu() {
        System.out.println("Menu Principal");
        System.out.println("1) Registrar usuario");
        System.out.println("2) Mostrar usuario");
        System.out.println("3) Jugar damas (se pidira dos usuarios registrados)");
        int opcion = IngresoDatos.getInt("Escriba la opcion :");
        switch (opcion) {
            case 1:// registrar
                listado.addUsuarioPedir();
                break;
            case 2: // mostrar listado de usuarios
                listado.mostrarListadoUsuarios();
                break;
            case 3: // jugar damas
                //purevas
                Tabla pruevas = new Tabla(8);
                //iniciarDamas();
                break;
        }
    }

    public void iniciarDamas(){
        Persona JugadorUno = listado.ingreseBusquedaPorNickName();
        Persona JugadorDos = listado.ingreseBusquedaPorNickName();
            if ((JugadorUno != null)&&(JugadorDos != null)) {
                damas = new JuegoDama(JugadorUno, JugadorUno,  new Tabla(8));
            }else {
               System.out.println(IngresoDatos.setTextoColor(0, "No fue encontrado un usuario")); 
            }
    }

}
