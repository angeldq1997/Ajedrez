package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.TipoPieza;

public class Alfil extends Pieza {
    public String toString() {
        if (this.getColor() == Color.BLANCA) {
            return "♗";
        } else {
            return "♝";
        }
    }

    public Alfil(int columna, int fila, Color color) {
        super(columna, fila, color, 3, TipoPieza.ALFIL);
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