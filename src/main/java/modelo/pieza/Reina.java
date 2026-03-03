package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.TipoPieza;

public class Reina extends Pieza {

    public Reina(int columna, int fila, Color color) {
        super(columna, fila, color, 9, TipoPieza.REINA);
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