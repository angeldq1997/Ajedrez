package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Peon extends Pieza {

    public Peon(int columna, int fila, Color color) {
        super(columna, fila, color);
        this.tipoPieza = TipoPieza.PEON;
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
        return 1;
    }

    @Override
    public String toString() {
        return "";
    }


}