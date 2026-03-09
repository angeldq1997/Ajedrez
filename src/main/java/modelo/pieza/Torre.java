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

    /**
     * Método con el que podemos hacer que la torre se pueda mover, comprobando todo.
     * @param filaDestino El número de la fila donde queremos mover la pieza
     * @param columnaDestina El número de la columna donde queremos mover la pieza
     * @param tablero Tablero donde se mueve la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */

    @Override
    public boolean puedeMover (int columnaDestino, int filaDestino) {
        boolean puedeMover = false;
        if(columnaDestino == this.getColumna() || filaDestino == this.getFila()) {
           puedeMover = true;
        }
        return puedeMover;
    }

    @Override
    public Pieza copiar () {
        return new Torre (this.getFila(), this.getColumna(), this.getColor()) ;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♖";
        } else {
            return "♜";
        }
    }
}