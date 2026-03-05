package modelo.pieza;
import modelo.*;

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
    public boolean puedeMover(int filaDestino, int columnaDestina, Tablero tablero) {
        return false;        
    }

    @Override
    public Pieza copiar() {
        return null;
    }

    @Override
    public String toString() {
        return "";
    }
}