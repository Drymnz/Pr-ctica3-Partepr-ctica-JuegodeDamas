package src.JuegoPiedraPapelTijera;

public class Diseño {
    private final int lineasMaximas = 13;

    public Diseño() {

    }

    // dibujos
    public String getPiedra(int linea) {
        switch (linea) {
            case 0:
                return "_______________    ";
            case 1:
                return "     ********      ";
            case 2:
                return "    *         *    ";
            case 3:
                return "   *           *   ";
            case 4:
                return " *              *  ";
            case 5:
                return "*                * ";
            case 6:
                return "*       ROCK    ***";
            case 7:
                return "  *               *";
            case 8:
                return "   *              *";
            case 9:
                return "    *             *";
            case 10:
                return "     *          *  ";
            case 11:
                return "       *      **   ";
            case 12:
                return "       ********    ";
            default:
                return "                   ";
        }
    }

    public String getPapel(int linea) {
        switch (linea) {
            case 0:
                return "_______________    ";
            case 1:
                return "**************     ";
            case 2:
                return "*           * *    ";
            case 3:
                return "*           *  *   ";
            case 4:
                return "*           *   *  ";
            case 5:
                return "*           *    * ";
            case 6:
                return "*           *******";
            case 7:
                return "*                 *";
            case 8:
                return "*                 *";
            case 9:
                return "*                 *";
            case 10:
                return "*                 *";
            case 11:
                return "*                 *";
            case 12:
                return "*******************";
            default:
                return "                   ";
        }
    }

    public String getTijera(int linea) {
        switch (linea) {
            case 0:
                return "_______________    ";
            case 1:
                return " *       * *       ";
            case 2:
                return "* *     *  *       ";
            case 3:
                return "*  *   *   *       ";
            case 4:
                return " *  *  *   *       ";
            case 5:
                return "  *   *    *       ";
            case 6:
                return "   *       *       ";
            case 7:
                return "   *   @   *       ";
            case 8:
                return "  *           *    ";
            case 9:
                return "*       **      *  ";
            case 10:
                return "*  @   *  *   @  * ";
            case 11:
                return "*      *   *      *";
            case 12:
                return "  *****     *******";
            default:
                return "                   ";
        }
    }

    // fin dibujos
    // get
    public int getLineasMaximas() {
        return lineasMaximas;
    }
    // fin get
}
