package modelo.pieza;

import modelo.Color;
import modelo.Pieza;

public class Reina extends Pieza {

    public Reina(int columna, int fila, Color color) {
        super(columna, fila, color, 9);
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
