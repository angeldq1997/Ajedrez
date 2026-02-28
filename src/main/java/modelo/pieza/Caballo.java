package modelo.pieza;

import modelo.Color;
import modelo.Pieza;
import modelo.Saltadora;

public class Caballo extends Pieza implements Saltadora {

    public Caballo(int columna, int fila, Color color) {
        super(columna, fila, color, 3);
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
