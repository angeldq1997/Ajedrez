package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Alfil extends Pieza {

    public Alfil(int columna, int fila, Color color) {
        super(columna, fila, color);
        this.tipoPieza = TipoPieza.ALFIL;
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

    @Override
    public String toString() {
        return "";
    }
}