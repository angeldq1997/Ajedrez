package modelo.pieza;

import modelo.Color;
import modelo.Pieza;

public class Rey extends Pieza {

    public Rey(int columna, int fila, Color color) {
        super(columna, fila, color, 100);
    }

    @Override
    public boolean atacar() {
        return false;
    }

    @Override
    public boolean mover() {
        return false;
    }
}
