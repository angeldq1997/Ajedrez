package modelo.pieza;

import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Torre extends Pieza {
    public Torre(int columna, int fila, Color color) {
        super(columna, fila, color, 5);
        this.tipoPieza = TipoPieza.TORRE;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♖');
        } else {
            this.setIcono('♜');
        }
    }

    @Override
    public boolean puedeMover(int columnaDestino, int filaDestino) {
        boolean puedeMover = false;
        if (this.validaPosicion(columnaDestino, filaDestino)){
            if(columnaDestino == this.getColumna() || filaDestino == this.getFila())
                puedeMover = true;
        }
        return puedeMover;
    }

    @Override
    public Pieza copiar() {
        return null;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♖";
        } else {
            return "♜";
        }
    }
}