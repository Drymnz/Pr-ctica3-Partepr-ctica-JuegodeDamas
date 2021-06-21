package src.JuegoDamas;
// manejo de juego de dama
public class ManejoFicha {
    public ManejoFicha() {

    }

    // buscador ficha
    public int posicionFichaInicialX(Casilla[][] listado, Ficha buscar, int ancho, int alto) {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (listado[i][j].getFicha() == buscar) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int posicionFichaInicialY(Casilla[][] listado, Ficha buscar, int ancho, int alto) {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (listado[i][j].getFicha() == buscar) {
                    return j;
                }
            }
        }
        return -1;
    }

    public Ficha buscarFicha(int id, Ficha[] listado) {
        for (int i = 0; i < listado.length; i++) {
            if (listado[i].getId() == id) {
                return listado[i];
            }
        }
        return null;
    }
    public boolean buscarAliado(Ficha[] listado, Ficha aliado){
        for (int i = 0; i < listado.length; i++) {
            if (listado[i] == aliado) {
                return true;
            }
        }
        return false;
    }
    // fin buscador ficha
}
