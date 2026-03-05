package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Peon extends Pieza {
    public String toString() {
        if (this.getColor() == Color.BLANCA) {
            return "♙";
        } else {
            return "♟";
        }
    }
    public Peon(int columna, int fila, Color color) {
      super(columna, fila, color, 1, TipoPieza.PEON);
    }

    @Override
    public boolean puedeMover(int filaDestino, int columnaDestina, Tablero tablero) {
        return false;
    }

    @Override
    public Pieza copiar() {
        return null;
    }


}