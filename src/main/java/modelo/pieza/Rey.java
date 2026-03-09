package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Rey extends Pieza {
    public Rey(int columna, int fila, Color color) {
        super(columna, fila, color, 100);
        this.tipoPieza = TipoPieza.REY;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♔');
        } else {
            this.setIcono('♚');
        }
    }

    @Override
    public boolean puedeMover(int columnaDestino, int filaDestino) {
        if (this.validaPosicion(columnaDestino, filaDestino)){
            if((Math.abs(filaDestino-getFila())<=1) && (Math.abs(columnaDestino-getColumna()) <=1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Pieza copiar() {
        return null;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♔";
        } else {
            return "♚";
        }
    }
}