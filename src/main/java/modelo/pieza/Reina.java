package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Reina extends Pieza {
    public String toString() {
        if (this.getColor() == Color.BLANCA) {
            return "♕";
        } else {
            return "♛";
        }
    }

    public Reina(int columna, int fila, Color color) {
        super(columna, fila, color);
        this.tipoPieza = TipoPieza.REINA;
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
        return 9;
    }

    @Override
    public String toString() {
        return "";
    }


}