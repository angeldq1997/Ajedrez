package modelo.pieza;
import modelo.*;

public class Caballo extends Pieza implements Saltadora {

    public Caballo(int columna, int fila, Color color) {
        super(columna, fila, color);
        this.tipoPieza = TipoPieza.CABALLO;
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
        return 3;
    }

    @Override
    public String toString() {
        return "";
    }
}