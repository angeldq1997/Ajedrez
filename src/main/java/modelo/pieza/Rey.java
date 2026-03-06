package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Rey extends Pieza {
    public Rey(int columna, int fila, Color color) {
        super(columna, fila, color, 100);
        this.tipoPieza = TipoPieza.REY;
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
        return 100;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♔";
        } else {
            return "♚";
        }
    }
}