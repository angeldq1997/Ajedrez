package modelo.pieza;

import modelo.Color;
import modelo.Pieza;

public class Torre extends Pieza {

    public Torre(int columna, int fila, Color color) {
        super(columna, fila, color, 5);
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
