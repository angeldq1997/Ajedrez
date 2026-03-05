package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Saltadora;
import modelo.TipoPieza;

public class Caballo extends Pieza implements Saltadora {
    public String toString() {
        if (this.getColor() == Color.BLANCA) {
            return "♘";
        } else {
            return "♞";
        }
    }

    public Caballo(int columna, int fila, Color color) {
        super(columna, fila, color, 3, TipoPieza.CABALLO);
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