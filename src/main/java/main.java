import controlador.ControladorTablero;
import modelo.Casilla;
import modelo.Pieza;
import modelo.Tablero;

import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        Tablero t = new Tablero();
        ControladorTablero controladorTablero = new ControladorTablero();
        controladorTablero.setTableroActual(t);

        System.out.println(t.mostrarTablero());

        Casilla c = t.getCasillas()[0][1];
        System.out.println(c.getIcono());
        controladorTablero.moverPieza(2,2, t.getPieza(0, 1));
        System.out.println(t.mostrarTablero());

        controladorTablero.moverPieza(4,4, t.getPieza(2, 2));
    }
}