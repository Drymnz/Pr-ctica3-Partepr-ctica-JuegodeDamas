package src.herramientas;

import src.JuegoDamas.JuegoDama;
import src.usario.ManejoUsurio;
import src.usario.Persona;

public class Menu {
    private ManejoUsurio listado = new ManejoUsurio();
    private JuegoDama juegoDama;

    public Menu() {
        mostrarMenu();
    }

    public void mostrarMenu() {
        int opcion = 69;
        do {
            System.out.print("**********Menu Principal**********\n");
            System.out.print("1) Registrar usuario\n");
            System.out.print("2) Mostrar usuario\n");
            System.out.print("3) Jugar damas (se pidira dos usuarios registrados)\n");
            System.out.print("0) Salir del programa\n");
            opcion = IngresoDatos.getInt("Escriba la opcion ");
            switch (opcion) {
                case 1:// registrar
                    listado.addUsuarioPedir();
                    break;
                case 2: // mostrar listado de usuarios
                    listado.mostrarListadoUsuarios();
                    break;
                case 3: // jugar damas
                    iniciarDamas();
                    break;
            }
        } while (opcion != 0);
    }

    public void iniciarDamas() {
        Persona JugadorUno = listado.ingreseBusquedaPorNickName();
        Persona JugadorDos = listado.ingreseBusquedaPorNickName();
        if ((JugadorUno != null) && (JugadorDos != null)) {
            String continuar = "";
            do {
               juegoDama = new JuegoDama(JugadorUno, JugadorDos);
               juegoDama.Iniciar();
               continuar = IngresoDatos.getTexto("¿Desea la revancha? \n Escriba Salir para terminar el juego");
            } while (!continuar.equalsIgnoreCase("Salir"));
        } else {
            System.out.println(IngresoDatos.setTextoColor(0, "No fue encontrado un usuario"));
        }
    }

}
