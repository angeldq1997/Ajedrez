package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
public class Peon extends Pieza {

    public Peon(int columna, int fila, Color color) {
        super(columna, fila, color, 1);
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