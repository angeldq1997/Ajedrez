package modelo.pieza;

import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Torre extends Pieza {
    public Torre(int columna, int fila, Color color) {
        super(columna, fila, color, 5);
        this.tipoPieza = TipoPieza.TORRE;
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
    public int getPuntos() {
        return 5;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♖";
        } else {
            return "♜";
        }
    }
}