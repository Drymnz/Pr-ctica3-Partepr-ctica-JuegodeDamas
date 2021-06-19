package src.usario;

import src.herramientas.IngresoDatos;

public class ManejoUsurio {
    private Persona [] listado = new Persona[1];
    private int contadorIngresados = 0;
    public ManejoUsurio(){
    }
    // buqueda usuario
    public Persona porNickName(String nickName){
        for (int i = 0; i < contadorIngresados; i++) {
            if (listado[i].getNickName().equals(nickName)) {
                return listado[i];
            }
        }
        return null;
    }
    public Persona ingreseBusquedaPorNickName(){
        Persona encontrada = porNickName(IngresoDatos.getTexto("Ingrese el nickname del usuario al buscar"));
        if (encontrada != null) {
            System.out.print("\n"+IngresoDatos.setTextoColor(1, " fue encontrado "));
        }else {
            System.out.print("\n"+IngresoDatos.setTextoColor(0, " no fue encontrado "));
        }
        return encontrada;
    }
    // fin busqueda
    // agregar usuario
    public void addUsuario(String nombre, String nickName){
        ampliarEspacio();
        listado[contadorIngresados] = new Persona(nombre, nickName);
        contadorIngresados ++;
    }
    public void addUsuarioPedir(){
        String nombre = IngresoDatos.getTexto("Escriba su nombre ");
        String nickName = IngresoDatos.getTexto("Es criba su nickname");
        this.addUsuario(nombre, nickName);
    }
    private void ampliarEspacio(){
        Persona [] nuevo = new Persona [listado.length +1];
        for (int i = 0; i < contadorIngresados; i++) {
            nuevo[i] = listado[i];
        }
        listado = null;
        listado = nuevo;
    }
    // fin de agregar usuario
    // get y set 
    public int contadorIngresados(){
        return contadorIngresados + 1 ;
    }
    // fin get y set
    // mostrar usuario
    public void mostrarListadoUsuarios(){
        System.out.print("\n Estos son los usuarios registrados :\n");
        for (int i = 0; i < contadorIngresados; i++) {
            System.out.println(listado[i].informacion());
        }
    }
    // fin de mostrar usuario
}
